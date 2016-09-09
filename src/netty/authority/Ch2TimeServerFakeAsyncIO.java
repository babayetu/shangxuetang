package netty.authority;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ch2TimeServerFakeAsyncIO {
	public static void main(String[] args) throws IOException {
		int port = 18080;
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("server started on " + port);
			
			Ch2TimeServerThreadPool tstp = new Ch2TimeServerThreadPool(5,1000);
			
			while (true) {
				Socket so = server.accept();
				tstp.execute(new Ch2TimeServerHandler(so));
			}
			
		} finally {
			if (server != null) {
				server.close();
				server = null;
			}
		}
		
	}
}
