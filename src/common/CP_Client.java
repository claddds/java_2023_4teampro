package common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Pay.Pay_DAO;
import Pay.Pay_VO;

public class CP_Client extends Thread {
	// git test
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
                        case 1: // 영화 삽입
                            Pay_VO pay_vo = p.getPay_vo();
                            result = Pay_DAO.getInsert(pay_vo);

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