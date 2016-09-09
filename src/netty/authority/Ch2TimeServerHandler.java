package netty.authority;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Ch2TimeServerHandler implements Runnable{
	
	private Socket so = null;
	
	public Ch2TimeServerHandler(Socket so) {
		this.so = so;
	}

	public void run() {
		if (so != null) {
			BufferedReader br = null;
			PrintWriter out = null;
			try {
				InputStream is = so.getInputStream();
				
				br = new BufferedReader(new InputStreamReader(is));
				
				out = new PrintWriter(new OutputStreamWriter(so.getOutputStream()),true);
				
				String body = null;
				
				while(true) {
					body = br.readLine();
					if (body == null) {
						break;
					}
					System.out.println("get command:" + body);
					
					String resp = body.equalsIgnoreCase("query time order")? new Date().toString():"unkown command";
					out.println(resp);
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br!=null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					out.close();
				}
				
				if(so!=null) {
					try {
						so.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		} else {
			System.out.println("null socket, exit");
		}
	}
	
}
