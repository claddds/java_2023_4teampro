package movie_server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class CP_Client extends Thread{
	Socket s;
	Server_book server;

	// 객체 직렬화(objectInputStream, objectOutputStream)
	ObjectInputStream in;
	ObjectOutputStream out;
	String ip;
	int result;
	
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
                    case 102: // 로그인한 회원의 잔여 포인트 가져오기
                    	System.out.println("===CP_Client의 case 102===");
                    	
//                    	currentUserId = Session.getCurrentUserId();
//                    	int chargepoint = Pay_DAO.getRemainingPoints(currentUserId);
//                    	p.setResult(chargepoint);
//                    	out.writeObject(p);
//                        out.flush();
                        break;
                    case 103: // 결제 완료 후 티켓 INSERT
                    	System.out.println("===CP_Client의 case 103===");

                    	Pay_VO p_vo = p.getP_vo();
                    	result = DAO.getInsert(p_vo);
                    	p.setResult(result); // DB 삽입 작업의 결과를 설정
                    	System.out.println(result + "예매 완료!");
                    	out.writeObject(p);
                    	out.flush();
                    	break;
                    case 104: // 현재 로그인 회원의 티켓 리스트 출력
                    	System.out.println("===CP_Client의 case 104===");
                    	
//                    	currentUserId = Session.getCurrentUserId();
//                    	DAO dao = new DAO();
//                		ArrayList<MobileTicket_VO> m_list = DAO.getTicketList(currentUserId);
//                		System.out.println("티켓 리스트 가져오기 성공");
//                		p.setList(ticketList);
//                    	out.writeObject(p);
//                    	out.flush();
//                    	break;
                    	
                    case 301 :   //영화목록가져오라는 요청을 받아, 여기서 받아서 DAO로 보내자.            
                        List<TicketBox_VO> t_list = DAO.getMovie_name(); // 영화 목록을 DB에서 가져옴                  
                         p.setT_list(t_list);
                         //영화 이름만 추출하여 문자열 배열로 변환                  
                         out.writeObject(p); // 클라이언트에게 프로토콜 전송
                         out.flush();

                         break;

                     case 302 :
                        //영화 시간 갖고오는 cmd 
                        System.out.println("cmd302 왔음");
                        
                        List<TicketBox_VO> movieTimes = DAO.getMovieTimes(getName());
                        System.out.println("담아서 메인인으로 보내자");
                        p.setT_list(movieTimes);
                        out.writeObject(p);
                        out.flush();
                        break;
                     case 303:
                     	break;
						
					case 501:	// 로그인
						int resId = DAO.getIdChk(p.getC_vo().getCust_id());
						if (resId > 0) {
							CustomerVO vo501 = DAO.getLogin(p.getC_vo());
							if (vo501 != null) {
								Protocol p501 = new Protocol();
								p501.setCmd(501);
								p501.setResult(0);
								p501.setC_vo(vo501);

								out.writeObject(p501);
								out.flush();
							} else {
								Protocol p501 = new Protocol();
								p501.setCmd(501);
								p501.setResult(1);
								p501.setC_vo(vo501);

								out.writeObject(p501);
								out.flush();
							}
						}
						break;
					
					case 502:	// 회원가입
						int result502 = 0;
						result502 = DAO.getIns(p.getC_vo());

						if (result502 > 0) {
							Protocol p502 = new Protocol();
							p502.setCmd(502);
							p502.setResult(result502);
							out.writeObject(p502);
							out.flush();
						}
						break;
					case 503:	// 아이디 중복 확인
						int result503 = DAO.getIdChk(p.getC_vo().getCust_id());

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