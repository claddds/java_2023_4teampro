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
	DefaultTableModel model1;
	JTable table1,table3;
	
	
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
				List<VO> list = null;
				if(obj !=null) {
					Protocol p = (Protocol)obj;
					switch (p.getCmd()) {
					//cmd : 0 : 종료, 301:영화목록 출력 
					//302: 상영시간표 출력 303 : 잔여포인트
					case 0: 
						out.writeObject(p);
						out.flush();
                        break esc;
	
					case 301 :					
						list = DAO.getMovie_name(); // 영화 목록을 DB에서 가져옴
					    System.out.println("영화 목록을 가져왔습니다.");
					    
					    // 영화 이름만 추출하여 문자열 배열로 변환
					    List<VO>[] movieNames = new List[list.size()];
					    for (int i = 0; i < list.size(); i++) {
					    	VO vo = list.get(i);
					        movieNames[i] = vo.getMovie_name();
					    }
					    
					    // 영화 이름을 테이블에 출력하기 위해 DefaultTableModel에 데이터 추가
					    DefaultTableModel model = (DefaultTableModel) table1.getModel();
					    model.setColumnIdentifiers(new Object[] { "영화 이름" }); // 테이블의 열 제목 설정
					    
					    for (List<VO> movieName : movieNames) {
					        model.addRow(new Object[] { movieName }); // 테이블에 새로운 행 추가
					    }
					    
					    p.setList(null); // 영화 목록은 전송하지 않음
					    out.writeObject(p); // 클라이언트에게 프로토콜 전송
					    out.flush();
					    break;
					
				
					case 302 :
						
						break;
					} 
				}
			} catch (Exception e) {
			
			}
		}
	}
	
	public void displayMovieList(List<VO> movieList) {
        model1 = (DefaultTableModel) table1.getModel();
        model1.setRowCount(0); // 기존 테이블 내용 초기화

        for (VO movie : movieList) {
            Object[] rowData = { movie.getMovie_name() };
            model1.addRow(rowData);
        }
    }
	
}
