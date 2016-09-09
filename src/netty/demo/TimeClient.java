package netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
	
	public static void main(String[] args) throws Exception {
//		String host = args[0];
//		int port = Integer.parseInt(args[1]);
		
		String host = "127.0.0.1";
		int port = 37;
		
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			Bootstrap b= new Bootstrap();
			b.group(workerGroup)
			 .channel(NioSocketChannel.class)
			 .handler(new ChannelInitializer<SocketChannel>()
					 {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new TimeDecoder(),new TimeClientHandler());
//							ch.pipeline().addLast(new TimeClientSolutionOneHandler());
						}
				 
					 })
			 .option(ChannelOption.SO_KEEPALIVE, true);
			
			//绑定并开始接受连接请求
			ChannelFuture f = b.connect(host,port).sync();
			
			//等待直到服务器端socket关闭
			//本例中，不会发生，你可以优雅的关闭你的服务器
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}
	
}
