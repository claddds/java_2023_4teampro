package project.LJH3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import project.LJH.DB.DAO;
import project.LJH.DB.VO;

public class CP_client extends Thread{
	Socket s;
	DB_server server;
	ObjectInputStream in;
	ObjectOutputStream out;
	ticket_office_main main;
	DB_server db_server;
	
	
	public CP_client(Socket s, DB_server db_server) {
		this.s = s;
		this.db_server= db_server;
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
				if(obj !=null) {
					Protocol p = (Protocol)obj;
					switch (p.getCmd()) {
					//cmd : 300 : 종료, 301:영화목록 출력 302: 극장관 이름 출력
					//303: 상영시간표 출력 304 : 잔여포인트
					case 300: 
						out.writeObject(p);
						out.flush();
                        break;
					case 304 :
						VO vo = p.getVo();
						// point = DAO.getPoint(p.getVo());
						//p.setResult(point);
						out.writeObject(p);
						out.flush();
					case 301 :
						List<VO> movieList = p.getList();
						p.setList(movieList);
						out.writeObject(p);
						out.flush();
						
						break;
					/*
					 * case 302 : List<VO> theaterList = p.getList(); p.setList(theaterList);
					 * out.writeObject(p); out.flush(); break;
					 */
					case 303 :
						List<VO> timeList = p.getList();
						p.setList(timeList);
						out.writeObject(p);
						out.flush();
						break;
					} 
				}
			} catch (Exception e) {
			
			}
		}
	}
	
	
	
}
