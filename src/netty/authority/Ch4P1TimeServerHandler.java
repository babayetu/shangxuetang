package netty.authority;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 演示TCP粘包情况
 * @author jingjing03.liu
 *
 */
public class Ch4P1TimeServerHandler extends ChannelInboundHandlerAdapter {
	private int counter;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		byte[] req = new byte[buf.readableBytes()];
		
		buf.readBytes(req);
		String body = new String(req,"UTF-8").substring(0, req.length - System.getProperty("line.separator").length());
		System.out.println("The time server receive order:" + body + ";the counter is:" + ++counter);
		
		String currentTime = "query time order".equalsIgnoreCase(body)
				? new Date(System.currentTimeMillis()).toString():"Bad Order";
		
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(resp);		
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
