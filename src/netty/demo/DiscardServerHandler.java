package netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// Discard the received data silently.
        ByteBuf in = (ByteBuf) msg;
        try {
			while(in.isReadable()) {
				System.out.print((char)in.readByte());
				System.out.flush();
			}
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
	public void exceptionCaught(ChannelHandlerContext  ctx, Throwable cause) {
		// Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
	}
}
