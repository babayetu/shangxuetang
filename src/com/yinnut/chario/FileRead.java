package com.yinnut.chario;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileRead {

	public static void main(String[] args) throws IOException {
		File f = new File("bing.html");
		File f2 = new File("fucktaobao.html");
		
		Reader fr = new FileReader(f);
		char[] car = new char[1024];
		
		Writer fw = new FileWriter(f2);
		
		int len = 0;
		while((len=fr.read(car))!=-1) {
			fw.write(car,0,len);
		}
		
		fw.flush();
		fw.close();
		fr.close();
	}

}
