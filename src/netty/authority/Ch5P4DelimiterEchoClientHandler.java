package netty.authority;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Ch5P4DelimiterEchoClientHandler extends ChannelInboundHandlerAdapter {
	private int count;
	static final String ECHO_REQ = "Hi, Liu Jingjing. Welcome to Netty.$_";

	public void channelActive(ChannelHandlerContext ctx) {
		for (int i = 0; i < 10; i++) {
			ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
		}
	}
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		System.out.println("This is " + ++count + " times receive server:[" + msg +"]");
	}
	
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
