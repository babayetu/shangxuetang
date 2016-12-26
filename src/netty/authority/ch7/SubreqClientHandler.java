package netty.authority.ch7;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubreqClientHandler extends ChannelInboundHandlerAdapter{

	public void channelActive(ChannelHandlerContext ctx) {
		
		SubscribeReq req = new SubscribeReq();
		req.setUserName("jingjing");
		req.setPhoneNumber("18512341234");
		
		for (int i = 0; i < 10; i++) {
			req.setSubReqId(i);
			ctx.write(req);
		}
		ctx.flush();
	}
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		System.out.println("received server:[" + msg +"]");
	}
	
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
