package com.yinnut.io.randomfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.yinnut.io.util.CloseStream;

public class SplitFile {
	// 文件路径
	private String filePath;
	// 块数
	private long size;
	// 每块大小
	private long blockSize;
	// 每块名称
	private List<String> blockPath;

	public SplitFile() {
		blockPath = new ArrayList<String>();
	}

	public SplitFile(String filePath) {
		this(filePath, 1024);
	}

	public SplitFile(String filePath, long blockSize) {
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		init();
	}

	private void init() {
		File f = new File(this.filePath);
		if (filePath == null || !f.exists()) {
			return;
		}

		if (f.isDirectory()) {
			return;
		}

		// 计算块数
		long fileSize = f.length();

		if (fileSize < blockSize) {
			this.blockSize = fileSize;
		}
		this.size = (long) Math.ceil(fileSize * 1.0 / blockSize);

		for (int i = 0; i < this.size; i++) {
			blockPath.add(this.filePath + ".part" + i);
		}
	}

	// 文件的分割
	public void split() throws IOException {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(filePath, "r");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
			return;
		}

		int len = 0;
		byte[] car = new byte[1024];
		int actualSize = 0;

		for (int i = 0; i < this.size; i++) {
			raf.seek(blockSize * i);
			File oneFile = new File(blockPath.get(i));
			OutputStream os = new BufferedOutputStream(new FileOutputStream(
					oneFile));

			if (i != this.size - 1) {
				actualSize = (int) blockSize;
			} else {
				actualSize = (int) (raf.length() % blockSize);
			}

			while (-1 != (len = raf.read(car))) {
				if (actualSize >= len) {
					os.write(car, 0, len);
					actualSize -= len;
				} else {
					os.write(car, 0, actualSize);
					break;
				}

			}

			os.flush();
			os.close();

		}

		if (raf != null) {
			raf.close();
		}
	}

	public void combine(String destFile) throws IOException {
		File dest = new File(destFile);
		OutputStream wFile = new BufferedOutputStream(new FileOutputStream(dest,true));
		
		for (String eachOne : blockPath) {
			File eachBlock = new File(eachOne);

			int len = 0;
			byte[] car = new byte[1024];

			RandomAccessFile raf = new RandomAccessFile(eachBlock, "r");
			while (-1 != (len = raf.read(car))) {
				wFile.write(car,0,len);
			}
			
			CloseStream.close(raf);
		}
		
		CloseStream.close(wFile);
	}

	public void combine2(String destFile) throws IOException {
		File dest = new File(destFile);
		OutputStream wFile = new BufferedOutputStream(new FileOutputStream(dest,true));
		
		//创建一个容器
		Vector<InputStream> vi = new Vector<InputStream>();
		for (String eachOne : blockPath) {
			File eachBlock = new File(eachOne);
			vi.add(new BufferedInputStream(new FileInputStream(eachBlock)));
		}
		
		SequenceInputStream si = new SequenceInputStream(vi.elements());
		
		int len = 0;
		byte[] car = new byte[1024];

		while (-1 != (len = si.read(car))) {
			wFile.write(car,0,len);
		}
		
		CloseStream.close(si);

		CloseStream.close(wFile);
	}
	
	public static void main(String[] args) {
		SplitFile sf = new SplitFile("t3.txt", 100);

		System.out.println(sf.size);

		try {
			sf.split();
			sf.combine2("newt2.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
