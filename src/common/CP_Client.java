package common;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Pay.Pay_DAO;
import Pay.Pay_VO;

public class CP_Client extends Thread {
    // 클라이언트와의 소켓 연결과 DB_Server 객체에 대한 참조를 저장하는 변수
	Socket s;
    DB_Server server;

    // 객체 직렬화를 위한 입출력 스트림
    ObjectInputStream in;
    ObjectOutputStream out;
    String ip;
    int result;
    
    public static String currentUserId;

    // CP_Client 생성자
    // 입출력 스트림 생성
    public CP_Client(Socket s, DB_Server server) {
        this.s = s;
        this.server = server;
        try {
            in = new ObjectInputStream(s.getInputStream());
            out = new ObjectOutputStream(s.getOutputStream());
            //ip = s.getInetAddress().getHostAddress();
        } catch (Exception e) {
        }
    }

    @Override
	public void run() {
		esc: while (true) {
			try {
				System.out.println("===CP_Client run() 실행===");
				Object obj = in.readObject(); // 서버에서 Protocol 객체를 받아 읽는다.
				if (obj != null) {
					Protocol p = (Protocol) obj;
					switch (p.getCmd()) {
					case 100:
						out.writeObject(p);
						out.flush();
						break esc;
                    case 102: // 로그인한 회원의 잔여 포인트 가져오기
                    	System.out.println("===CP_Client의 case 1===");
                    	
                    	currentUserId = Session.getCurrentUserId();
                    	int chargepoint = Pay_DAO.getRemainingPoints(currentUserId);
                    	p.setResult(chargepoint);
                    	out.writeObject(p);
                        out.flush();
                        break;
                    case 103: // 결제 완료 후 티켓 INSERT
                    	System.out.println("===CP_Client의 case 2===");

                    	Pay_VO pay_vo = p.getPay_vo();
                    	result = Pay_DAO.getInsert(pay_vo);
                    	p.setResult(result); // DB 삽입 작업의 결과를 설정
                    	System.out.println(result + "예매 완료!");
                    	out.writeObject(p);
                    	out.flush();
                    	break;
					}
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		try {
			out.close();
			in.close();
			s.close();
		} catch (Exception e) {
		}
	}
}
