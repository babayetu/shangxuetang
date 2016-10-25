package netty.authority;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

public class ReadCompletionHandler
		implements CompletionHandler<Integer, ByteBuffer> {
	
	private AsynchronousSocketChannel channel;

	public ReadCompletionHandler(AsynchronousSocketChannel asc) {
		if (asc != null) {
			this.channel = asc;
		}
	}

	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] body = new byte[attachment.remaining()];
		attachment.get(body);
		try {
			String command = new String(body,"UTF-8");
			String resp = command.equalsIgnoreCase("query time order")? new Date().toString():"unkown command";
			doWrite(resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void doWrite(String resp) {
		if (resp != null && resp.trim().length() >0) {
			byte[] bytes = resp.getBytes();
			ByteBuffer wb = ByteBuffer.allocate(bytes.length);
			wb.put(bytes);
			wb.flip();
			channel.write(wb, wb, new CompletionHandler<Integer,ByteBuffer>(){

				public void completed(Integer result, ByteBuffer attachment) {
					if (attachment.hasRemaining()) {
						channel.write(attachment,attachment,this);
					}
				}

				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						channel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			});
		}
		
	}

	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			this.channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
