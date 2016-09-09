package netty.authority;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ch2TimeClient {
	public static void main(String[] args){
		int port = 18080;
		
		Socket so = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			so = new Socket("127.0.0.1",port);

			
			in = new BufferedReader(new InputStreamReader(so.getInputStream()));
			
			out = new PrintWriter(new OutputStreamWriter(so.getOutputStream()),true);
			
			out.println("query time order");
			
			String resp = in.readLine();
			
			System.out.println(resp);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (out!=null) {
				out.close();
			}
		}
		
		
		
		
	}
}
