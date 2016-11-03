package netty.authority;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 演示不支持TCP粘包的客户端
 * @author jingjing03.liu
 *
 */
public class Ch4P2TimeClient {
	public void connect(int port, String host) {
		NioEventLoopGroup group = new NioEventLoopGroup();
		
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
			 .option(ChannelOption.TCP_NODELAY, true)
			 .handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new Ch4P2TimeClientHandler());
					
				}
				 
			 });
			
			ChannelFuture f = b.connect(host,port).sync();
			
			f.channel().closeFuture().sync();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
		
	}
	
	public static void main(String[] args) {
		int port = 18080;
		new Ch4P2TimeClient().connect(port, "127.0.0.1");
	}
	
}
