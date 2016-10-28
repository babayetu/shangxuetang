package netty.authority;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class OtherSample1HelloHandler extends ChannelInboundHandlerAdapter {

	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf b = (ByteBuf)msg;
        
        byte[] bb = new byte[b.readableBytes()];
        b.readBytes(bb);
        
        System.out.println("Input command is:" + new String(bb,"UTF-8"));
        
        //释放资源
        b.release();
        
        String resp = new Date(System.currentTimeMillis()).toString();
        
        ByteBuf outBuff = ctx.alloc().buffer(4 * resp.length());
        
        outBuff.writeBytes(resp.getBytes());
        
        ctx.writeAndFlush(outBuff);
    }
	
	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
	
	 @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
