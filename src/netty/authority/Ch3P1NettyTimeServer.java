package netty.authority;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Ch3P1NettyTimeServer {
	public void bind(int port) throws Exception {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap sb = new ServerBootstrap();
			sb.group(bossGroup, workerGroup)
			  .channel(NioServerSocketChannel.class)
			  .option(ChannelOption.SO_BACKLOG, 1024)
			  .childHandler(new Ch3P1ChildChannelHandler());
			
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
		int port = 18080;
		 new Ch3P1NettyTimeServer().bind(port);
	}
}

