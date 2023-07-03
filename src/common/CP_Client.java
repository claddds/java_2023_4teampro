package common;

import java.io.IOException;
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

    // CP_Client 생성자
    // 입출력 스트림 생성
    public CP_Client(Socket s, DB_Server server) {
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
        try {
            while (true) {
                Object obj = in.readObject();
                if (obj != null) {
                    Protocol p = (Protocol) obj;
                    switch (p.getCmd()) {
                        case 0: // 로그인한 회원 찾기
                        	// Pay_DAO.getMemberLogin() 메서드를 사용하여 로그인한 회원의 아이디를 가져옴
                        	String currentUserId = Pay_DAO.getMemberLogin(p.getPay_vo());
                        	System.out.println("로그인한 회원: " + currentUserId);
                        	int currentUserIdAsInt = Integer.parseInt(currentUserId);
                        	p.setResult(currentUserIdAsInt); 
                        	System.out.println("회원 찾았음" + currentUserId);
                        	out.writeObject(p);
                        	out.flush();
                        	break;
                        case 1: // 로그인한 회원의 잔여 포인트 가져오기
                        	int chargepoint = Pay_DAO.getRemainingPoints(p.getPay_vo());
                        	System.out.println(chargepoint + "원 DAO 실행");
                        	p.setResult(chargepoint);
                        	System.out.println(chargepoint + "원 클라이언트한테 보냄");
                        	out.writeObject(p);
                            out.flush();
                            break;
                        case 2: // 결제 완료 후 티켓 INSERT
                        	Pay_VO pay_vo = p.getPay_vo();
                        	result = Pay_DAO.getInsert(pay_vo);
                        	p.setResult(result); // DB 삽입 작업의 결과를 설정
                        	System.out.println(result + "예매 완료!");
                        	out.writeObject(p);
                        	out.flush();
                        	break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}