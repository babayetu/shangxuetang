package netty.demo;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientSolutionOneHandler extends ChannelInboundHandlerAdapter {
	private ByteBuf buf;
	

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        buf = ctx.alloc().buffer(4);
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        buf.release();
        buf=null;
    }
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf bb = (ByteBuf)msg;
		
		buf.writeBytes(bb);
		bb.release();
		
		if (buf.readableBytes() >= 4) {
			long ntpTime = buf.readUnsignedInt();
			
			long unixTimeStamp = (ntpTime - 2208988800L) * 1000L;
			
			System.out.println(new Date(unixTimeStamp));
			
			ctx.close();
		}
	}
	
	public void exceptionCaught(ChannelHandlerContext  ctx, Throwable cause) {
		// Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
	}
}
