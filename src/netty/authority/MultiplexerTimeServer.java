package netty.authority;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable{
	private Selector selector;
	private volatile boolean stop;
	private ServerSocketChannel servSocketChannel;
	
	public void run() {
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void handleInput(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		if (key.isValid()) {
			if (key.isAcceptable()) {
				//接收新的连接请求
				ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			} else if (key.isReadable()) {
				SocketChannel sc = (SocketChannel)key.channel();
				ByteBuffer bb = ByteBuffer.allocate(1024);
				int readBytes = sc.read(bb);
				if (readBytes >0) {
					bb.flip();
					
				}
			}
			
		}
	}

	public MultiplexerTimeServer(int port) {
		try {
			selector = Selector.open();
			servSocketChannel = ServerSocketChannel.open();
			servSocketChannel.configureBlocking(false);
			servSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",port),1024);
			servSocketChannel.register(selector, SelectionKey.OP_CONNECT);
			System.out.println("Time server listened on port: " + port);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void stop() {
		this.stop = true;
	}
	
	
}
