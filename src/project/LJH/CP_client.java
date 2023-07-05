package project.LJH;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import project.LJH.DB.DAO;
import project.LJH.DB.VO;

public class CP_client extends Thread{
	Socket s;
	DB_server server;
	
	ObjectInputStream in;
	ObjectOutputStream out;
	ticket_office_main main;
	DefaultTableModel model1;
	
	
	public CP_client(Socket s, DB_server server) {
		this.s = s;
		this.server= server;
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				Object obj = in.readObject();
				List<VO> list = null;
				if(obj !=null) {
					Protocol p = (Protocol)obj;
					switch (p.getCmd()) {
					//cmd : 300 : 종료, 301:영화목록 출력 
					//303: 상영시간표 출력 304 : 잔여포인트
					case 300: 
						out.writeObject(p);
						out.flush();
                        break;
	
					case 301 :					
						System.out.println("왔어?클라이언트로?");
						list = DAO.getMovie_name();
						System.out.println("담아졌니?");
						p.setList(list);
						
						out.writeObject(p);
						out.flush();
						break;
				
					case 303 :
						
						break;
					} 
				}
			} catch (Exception e) {
			
			}
		}
	}
	
	
	
}
