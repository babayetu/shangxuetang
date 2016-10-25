package netty.authority;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler
		implements CompletionHandler<AsynchronousSocketChannel, Ch2P11AsyncTimeServerHandler> {

	public void completed(AsynchronousSocketChannel result, Ch2P11AsyncTimeServerHandler attachment) {
		attachment.getAssc().accept(attachment, this);
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		result.read(readBuffer,readBuffer,new ReadCompletionHandler(result));
	}

	public void failed(Throwable exc, Ch2P11AsyncTimeServerHandler attachment) {
		attachment.getLatch().countDown();		
	}

}
