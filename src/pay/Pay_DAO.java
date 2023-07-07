package pay;

import org.apache.ibatis.session.SqlSession;

import common.DB_Service;

public class Pay_DAO {
	// 실제 사용하는 클래스
	private static SqlSession ss;
 
	// 싱글턴 패턴(동기화 처리) : 프로그램 종료시까지 한 번 만들어진 객체를 재사용하는 형식
	private synchronized static SqlSession getsession() {
		if (ss == null) {
			ss = DB_Service.getFactory().openSession();
		}
		return ss;
	}
	 
		
	//DB 처리하는 메서드들
	
	// TICKET 테이블에 예매 정보 삽입
	public static int getInsert(Pay_VO pay_vo) {
	    int result = getsession().insert("movieinsert", pay_vo);
	    //System.out.println("insert 완료");  // 삽입 완료 로깅
	    ss.commit();
	    //System.out.println("commit 완료");  // 커밋 완료 로깅
	    return result;
	}
	
	// 로그인 한 회원 ID 가져오기
	public static String getMemberLogin(Pay_VO pay_vo) {
		System.out.println("[DAO] getMemberLogin");
		String cust_id= getsession().selectOne("getMemberLogin", pay_vo);
		return cust_id;
	}
	
	// 해당 회원의 잔여포인트 가져오기
	public static int getRemainingPoints(String custid) {
		System.out.println("[DAO] getRemainingPoints" + custid);
		int chargepoint = getsession().selectOne("getRemainingPoints", custid);
		return chargepoint;
	}
	
	// 포인트 충전
	public static void updatePoint(Pay_VO pay_vo) {
		 System.out.println("Updating point: " + pay_vo.getPoint());
		 System.out.println("Updating Cust_id: " + pay_vo.getCust_id());
		
		try {
			getsession().update("updateCustomerPoint", pay_vo);
			getsession().update("updateLoginInfoPoint", pay_vo);
			getsession().update("updateRemainingPoint", pay_vo);
			ss.commit(); // commit 호출
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
