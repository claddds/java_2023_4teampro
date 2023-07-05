package movie_server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CP_Client extends Thread{
	Socket s;
	Server_book server;

	// 객체 직렬화(objectInputStream, objectOutputStream)
	ObjectInputStream in;
	ObjectOutputStream out;
	String ip;
	
	public CP_Client(Socket s, Server_book server) {
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
		esc:while(true) {
			try {
				Object obj = in.readObject();
				if(obj!=null) {
					Protocol p = (Protocol) obj;
					switch(p.getCmd()) {
					case 0:	// 종료
						out.writeObject(p);
						out.flush();
						break esc; // 접속 해제
						
					case 501:	// 로그인
						int resId = DAO.getIdChk(p.getVo().getCust_id());
						if (resId > 0) {
							CustomerVO vo501 = DAO.getLogin(p.getVo());
							if (vo501 != null) {
								Protocol p501 = new Protocol();
								p501.setCmd(501);
								p501.setResult(0);
								p501.setVo(vo501);

								out.writeObject(p501);
								out.flush();
							} else {
								Protocol p501 = new Protocol();
								p501.setCmd(501);
								p501.setResult(1);
								p501.setVo(vo501);

								out.writeObject(p501);
								out.flush();
							}
						}
						break;
					
					case 502:	// 회원가입
					case 503:	// 아이디 중복 확인
						int result503 = DAO.getIdChk(p.getVo().getCust_id());

						Protocol p503 = new Protocol();
						p503.setCmd(503);
						p503.setResult(result503);
						out.writeObject(p503);
						out.flush();
						break;
						 
					}
				}
			} catch (Exception e) {
			}
		}
	}
	
}

/*
// 마이바티스 셋팅하기 
// 1. config.xml  만들기 - DB 접속
// 2. mapper.xml 만들기 - 실제 SQL 작성하는파일 (실제 DB에 갖다와서 결과를 내보내는 파일)
// 3. VO.java   - DB 에 들어갈 파라미터 및 결과를 저장을 담당하는 파일 (테이블의 컬럼명과 일치)
// 4. DAO.java  - mapper와 연결되서 자바에서  DB 실행 시키는 파일 (DB 처리흔 클래스들을 모아놓은 파일)
// 5. DBService - config.xml 파일을 읽고 MyBatis을 실행할 수 있도록 하는 파일  
*/