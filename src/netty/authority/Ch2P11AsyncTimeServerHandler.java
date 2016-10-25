package netty.authority;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class Ch2P11AsyncTimeServerHandler implements Runnable {
	private int port;
	private CountDownLatch latch;
	private AsynchronousServerSocketChannel assc;
	
	public Ch2P11AsyncTimeServerHandler(int port) {
		this.port = port;
		try {
			assc = AsynchronousServerSocketChannel.open();
			assc.bind(new InetSocketAddress(port));
			System.out.println("The time server is started in port:" + port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		
	}

	private void doAccept() {
		assc.accept(this, new AcceptCompletionHandler());
		
	}

	public AsynchronousServerSocketChannel getAssc() {
		return assc;
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	
}
