package project.LJH;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.LJH.DB.DAO;
import project.LJH.DB.VO;

public class CP_client extends Thread{
	Socket s;
	DB_server server;
	
	ObjectInputStream in;
	ObjectOutputStream out;
	ticket_office_main main;
	DefaultTableModel model1,model2,model3;
		
	
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
		esc: while(true) {
			try {
				Object obj = in.readObject();
				//List<VO> list = null;
				if(obj !=null) {
					Protocol p = (Protocol)obj;
					switch (p.getCmd()) {
					// cmd : 0 : 종료, 301:영화목록 출력
					// 302: 상영시간표 시작 시간 출력 303 :잔여포인트
					case 0: 
						out.writeObject(p);
						out.flush();
                        break esc;
	
					case 301 :	//영화목록가져오라는 요청을 받아, 여기서 받아서 DAO로 보내자.				
						List<VO> list = DAO.getMovie_name(); // 영화 목록을 DB에서 가져옴					   
					    p.setList(list);
					    //영화 이름만 추출하여 문자열 배열로 변환					   
					    out.writeObject(p); // 클라이언트에게 프로토콜 전송
					    out.flush();

					    break;

					case 302 :
						//영화 시간 갖고오는 cmd 
						System.out.println("cmd302 왔음");
						//int selectedRow = main.table1.getSelectedRow();
						//String movieTitle = (String) main.table1.getValueAt(selectedRow, 0);
						List<VO> movieTimes = DAO.getMovieTimes(getName());
						System.out.println("담아서 메인인으로 보내자");
						p.setList(movieTimes);
						out.writeObject(p);
						out.flush();
						break;
						
					case 303:
						
						
						
					} 
				}
			} catch (Exception e) {
			
			}
		}
	}
	

	
}
