package netty.authority;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Ch4P3TimeServer {
	public void bind(int port) throws Exception {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap sb = new ServerBootstrap();
			sb.group(bossGroup, workerGroup)
			  .channel(NioServerSocketChannel.class)
			  .option(ChannelOption.SO_BACKLOG, 1024)
			  .childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
					ch.pipeline().addLast(new StringDecoder());
					ch.pipeline().addLast(new Ch4P3TimeServerHandler());
				}
			  });
			
			//绑定端口，同步等待成功
			ChannelFuture f = sb.bind(port).sync();
			
			//等待服务器监听端口关闭
			f.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
//		System.out.println("line seperator is :" + System.getProperty("line.separator"));
//		System.out.println(System.getProperty("line.separator") == null);
		int port = 18080;
		 new Ch4P3TimeServer().bind(port);
	}
}
