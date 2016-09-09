package netty.demo;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
//		ByteBuf b = (ByteBuf)msg;
		UnixTime m = (UnixTime)msg;
		
		System.out.println(m);
		ctx.close();
		
//		try {
//			long ntpTime = b.readUnsignedInt();
//			
//			long unixTimeStamp = (ntpTime - 2208988800L) * 1000L;
//			
//			System.out.println(new Date(unixTimeStamp));
//			
//			ctx.close();
//		} finally {
//			b.release();
//		}
		
		
	}
	
	public void exceptionCaught(ChannelHandlerContext  ctx, Throwable cause) {
		// Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
	}
}
