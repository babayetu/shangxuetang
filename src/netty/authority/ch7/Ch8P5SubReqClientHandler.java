package netty.authority.ch7;

import java.util.ArrayList;
import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.authority.ch7.SubscribeReqProto.SubscribeReq.Builder;

public class Ch8P5SubReqClientHandler extends ChannelInboundHandlerAdapter {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void channelActive(ChannelHandlerContext ctx) {
		
		for (int i = 0; i < 10; i++) {
			ctx.write(oneTimeReqBuilder(i));
		}
		
		ctx.flush();
	}
	
	private SubscribeReqProto.SubscribeReq oneTimeReqBuilder(int seqId) {
		Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqID(seqId);
		builder.setUserName("jingjing");
		builder.setProductName("iphone7");
		
		List address = new ArrayList<String>();
		address.add("nanpu bridge");
		address.add("daning international");
		builder.addAllAddress(address);
		return builder.build();
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
