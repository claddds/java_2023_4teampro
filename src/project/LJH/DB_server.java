package project.LJH;

import java.net.ServerSocket;
import java.net.Socket;
//이걸로 합치기
public class DB_server implements Runnable{
	ServerSocket ss = null;
	Socket s = null;
	
	public DB_server() {
		try {
			ss= new ServerSocket(7780);
			System.out.println("서버 대기중....");
			
			new Thread(this).start();
		} catch (Exception e) {
		}
	}
	

	@Override
	public void run() {
		while(true) {
			try {
				s = ss.accept();
				System.out.println("client 접속함");
				//서버 접속이 되었는지 확인하기 위한 콘솔 출력
				CP_client cc = new CP_client(s, this);
				cc.start();
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		new DB_server();
	}
}
