package project.LJH2;

import java.net.ServerSocket;
import java.net.Socket;

public class DB_server implements Runnable{
	ServerSocket ss = null;
	Socket s = null;
	
	public DB_server() {
		try {
			ss= new ServerSocket(7789);
			System.out.println("서버 대기중....");
			
			new Thread(this).start();
		} catch (Exception e) {
		}
	}
	
	
	
	
	
	@Override
	public void run() {
		while(true) {
			try {
				Socket s = ss.accept();
				CP_client cc = new CP_client(s, this);
				cc.start();
			} catch (Exception e) {
				
			}
		}

	}
	
	public static void main(String[] args) {
		
	}
}
