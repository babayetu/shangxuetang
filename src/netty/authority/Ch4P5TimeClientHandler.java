package netty.authority;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Ch4P5TimeClientHandler extends ChannelInboundHandlerAdapter{
//	private static final Logger logger = Logger.getLogger(Ch4P5TimeClientHandler.class.getName());
	
	private int counter;
	private byte[] req;

	public Ch4P5TimeClientHandler() {
		req = ("query time order" + System.getProperty("line.separator")).getBytes();
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		ByteBuf message = null;
		for (int i = 0; i < 100; i++) {
			message = Unpooled.buffer(req.length);
			message.writeBytes(req);
			ctx.writeAndFlush(message);
		}
	}
	
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String)msg;
        System.out.println("Now is:" + body + ";the counter is:" + ++counter);     
    }
	
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
//        logger.warn("Unexpected exception from downstream:" + cause.getMessage());
    	System.out.println(cause.getMessage());
        ctx.close();
    }
}
