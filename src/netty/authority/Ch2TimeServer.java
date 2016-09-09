package netty.authority;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ch2TimeServer {
	public static void main(String[] args) throws IOException {
		int port = 18080;
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("server started on " + port);
			
			while (true) {
				Socket so = server.accept();
				new Thread(new Ch2TimeServerHandler(so)).start();
			}
			
		} finally {
			if (server != null) {
				server.close();
				server = null;
			}
		}
		
	}
}
