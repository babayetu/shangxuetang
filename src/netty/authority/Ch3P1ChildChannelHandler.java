package netty.authority;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class Ch3P1ChildChannelHandler extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new Ch3P1TimeServerHandler());
		
	}
	
}
