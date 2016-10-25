package netty.authority;

public class Ch2P11TimeServer {
	public static void main(String[] args) {
		int port  = 18080;
		Ch2P11AsyncTimeServerHandler timeServer = new Ch2P11AsyncTimeServerHandler(port);
		new Thread(timeServer,"AIO-Time-Server-001").start();
	}
}
