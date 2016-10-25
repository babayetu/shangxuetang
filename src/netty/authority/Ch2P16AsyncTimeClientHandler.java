package netty.authority;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class Ch2P16AsyncTimeClientHandler implements Runnable,
	 CompletionHandler<Void,Ch2P16AsyncTimeClientHandler>{
	
	private String name;
	private CountDownLatch latch;
	private AsynchronousSocketChannel client;
	
	public Ch2P16AsyncTimeClientHandler(String name) throws IOException {
		this.name = name;
		client = AsynchronousSocketChannel.open();
	}

	public void run() {
		latch = new CountDownLatch(1);
		client.connect(new InetSocketAddress("127.0.0.1", 18080),this,this);
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void completed(Void result, Ch2P16AsyncTimeClientHandler attachment) {
		byte[] req = "Query time order".getBytes();
		ByteBuffer wb = ByteBuffer.allocate(req.length);
		wb.put(req);
		wb.flip();
		client.write(wb, wb, new CompletionHandler<Integer,ByteBuffer>() {
			public void completed(Integer result, ByteBuffer buffer) {
				if (buffer.hasRemaining()) {
					client.write(buffer, buffer,this);
				} else {
					ByteBuffer rb = ByteBuffer.allocate(1024);
					client.read(rb, rb, new CompletionHandler<Integer, ByteBuffer>() {

						public void completed(Integer result, ByteBuffer buffer) {
							buffer.flip();
							byte[] bytes = new byte[buffer.remaining()];
							buffer.get(bytes);
							try {
								System.out.println(new String(bytes,"UTF-8"));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							latch.countDown();
						}

						public void failed(Throwable exc, ByteBuffer buffer) {
							try {
								client.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							latch.countDown();
						}
						
					});
				}
				
			}

			public void failed(Throwable exc, ByteBuffer attachment) {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				latch.countDown();
				
			}
			
		});
	}

	public void failed(Throwable exc, Ch2P16AsyncTimeClientHandler attachment) {
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		
	}


}
