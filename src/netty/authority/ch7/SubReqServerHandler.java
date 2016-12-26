package netty.authority.ch7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReq req = (SubscribeReq)msg;
        if ("jingjing".equalsIgnoreCase(req.getUserName())) {
        	System.out.println("Server accept client subscribe req:" + req.toString());
        }
        ctx.writeAndFlush(resp(req.getSubReqId()));
    }
    
    public SubscribeResp resp(int subReqId) {
    	SubscribeResp resp = new SubscribeResp();
    	resp.setSubReqId(subReqId);
    	resp.setErrorCode(0);
    	resp.setDesc("Netty book order succeed, 3 days later, sent to designated address");
    	return resp;
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
