package Pay;

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
	public static int getInsert(Pay_VO pay_vo) {
		int result = getsession().insert("movieinsert", pay_vo);
		ss.commit();
		return result;
	}
}
