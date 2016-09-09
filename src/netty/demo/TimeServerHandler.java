package netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {
	@Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
//        final ByteBuf time = ctx.alloc().buffer(4);
//        //从unix纪元时间转换成NTP时间戳
//        long current_time = System.currentTimeMillis()/1000L + 2208988800L;
//        time.writeInt((int)current_time);
//        final ChannelFuture f = ctx.writeAndFlush(time);
//        f.addListener(new ChannelFutureListener(){
//			public void operationComplete(ChannelFuture future) throws Exception {
//				assert f == future;
//				ctx.close();
//			}
//        });
//        
//        System.out.println(current_time);
		
		ChannelFuture f = ctx.writeAndFlush(new UnixTime());
		f.addListener(ChannelFutureListener.CLOSE);
    }
	
	public void exceptionCaught(ChannelHandlerContext  ctx, Throwable cause) {
		// Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
	}
}
