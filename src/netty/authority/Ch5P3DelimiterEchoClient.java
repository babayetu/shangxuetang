package netty.authority;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Ch5P3DelimiterEchoClient {
	public void connect(int port, String host) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
			 .option(ChannelOption.TCP_NODELAY, true)
			 .handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
					ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
					ch.pipeline().addLast(new StringDecoder());
					ch.pipeline().addLast(new Ch5P4DelimiterEchoClientHandler());
				}
				 
			 });
			
			ChannelFuture f = b.connect(host,port).sync();
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int port = 18080;
		String host = "127.0.0.1";
		
		new Ch5P3DelimiterEchoClient().connect(port, host);
	}
}
