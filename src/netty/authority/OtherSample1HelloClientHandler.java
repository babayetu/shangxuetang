package netty.authority;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class OtherSample1HelloClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	
       String sendCommand = "Tell me what time is it now";
       ByteBuf sendBuf = ctx.alloc().buffer(4 * sendCommand.length());
       
       sendBuf.writeBytes(sendCommand.getBytes());
       ctx.writeAndFlush(sendBuf);
    }
    
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf b = (ByteBuf)msg;
        
        byte[] bb = new byte[b.readableBytes()];
        b.readBytes(bb);
        
        System.out.println("Server said:" + new String(bb,"UTF-8"));
       
        //释放资源
        b.release();
    }
	
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }
    
	 @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
