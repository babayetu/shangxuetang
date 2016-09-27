package netty.authority;

public class Ch2P8TimeServer {
	public static void main(String[] args) {
		int port  = 18080;
		Ch2P8MultiplexerTimerServer timeServer = new Ch2P8MultiplexerTimerServer(port);
		new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
	}
}
