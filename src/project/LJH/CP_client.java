package project.LJH;

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
	ticket_office_main client;
	
	
	public CP_client(Socket s, DB_server server) {
		this.s = s;
		this.server = server;
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
		} catch (Exception e) {
			
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
					//cmd : 500 : 종료, 501:영화목록 출력 502: 극장관 이름 출력, 503: 상영시간표 출력
					case 501: 
						List<VO> movieList = DAO.getMovieList();
						p.setMovie(movieList.toArray(new String[0]));
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
