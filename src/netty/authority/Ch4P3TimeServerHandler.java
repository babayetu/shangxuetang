package netty.authority;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Ch4P3TimeServerHandler extends ChannelInboundHandlerAdapter{

	private int counter;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String) msg;
		System.out.println("The time server receive order : "+ body + "; the counter is:" + ++counter);
		String currentTime = "query time order".equalsIgnoreCase(body) ? 
				new Date(System.currentTimeMillis()).toString() : "bad order";
		currentTime = currentTime + System.getProperty("line.separator");
		System.out.println("currentTime : " + currentTime);
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes()); //"utf-8"
		ctx.writeAndFlush(resp);		
	}
	
	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }
}
