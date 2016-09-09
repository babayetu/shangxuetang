package netty.demo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ctx.writeAndFlush(msg);
	}
	
	public void exceptionCaught(ChannelHandlerContext  ctx, Throwable cause) {
		// Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
	}
}
