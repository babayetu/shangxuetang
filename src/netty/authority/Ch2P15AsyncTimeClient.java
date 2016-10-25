package netty.authority;

import java.io.IOException;

//访问Ch2P11TimeServer
public class Ch2P15AsyncTimeClient {
	private int port = 18080;
	
	public static void main(String[] args) throws IOException {
		new Thread(new Ch2P16AsyncTimeClientHandler("AIO-AsyncTimeClientHandler-001")).start();
	}
}
