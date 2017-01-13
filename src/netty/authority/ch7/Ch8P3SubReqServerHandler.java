package netty.authority.ch7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.authority.ch7.SubscribeRespProto.SubscribeResp.Builder;

public class Ch8P3SubReqServerHandler extends ChannelInboundHandlerAdapter{
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq)msg;
		System.out.println("received protobuf message:[" + req.toString() +"]");
		ctx.writeAndFlush(buildResponse(req));
	}
	
	private SubscribeRespProto.SubscribeResp buildResponse(SubscribeReqProto.SubscribeReq req) {
		Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
		builder.setSubReqID(req.getSubReqID());
		builder.setRespCode(0);
		builder.setDesc(req.getUserName() + " order " + req.getProductName()+" successful");
		return builder.build();
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
