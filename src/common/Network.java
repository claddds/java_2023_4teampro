package common;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Pay.Pay_VO;

// 현재 사용 안하고 있음.
public class Network implements Runnable{

	private static Pay_VO pay_vo;
	
	// 접속하기 위해 필요한 것들
	private static Socket s = null;
	private static ObjectOutputStream out = null;
	private static ObjectInputStream in = null;

	
	// 접속 메서드
	public void connected() {
		try {
			// 집: 192.168.0.11
			s = new Socket("192.168.0.78", 7789);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			new Thread(this).start();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	// 현재 로그인한 회원을 불러오는 메서드
	public static String getCurrentUserId() {
		try {
			Protocol p = new Protocol();
			p.setCmd(100);
			p.setPay_vo(pay_vo);		
			out.writeObject(p); // objectOutputStream을 통해 Protocol 객체를 서버로 전송
			out.flush(); // 출력 스트림을 비우는 역할
			
			// 서버에서 전달된 프로토콜 객체 받기
			Protocol response = (Protocol)in.readObject();
			int currentUserId = (int) response.getResult();
	        String currentUserIdStr = String.valueOf(currentUserId);
	        return currentUserIdStr;
	    } catch (Exception e) {
	        // 예외 처리
	    }
	    return null;
	}
}