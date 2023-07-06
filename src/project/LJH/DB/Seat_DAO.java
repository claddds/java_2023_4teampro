package project.LJH.DB;

import org.apache.ibatis.session.SqlSession;
//이걸로 합치기
	public class Seat_DAO {
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) { // null이라는건 안만들어졌다 라는것
			ss = DBService.getFactory().openSession();
		}
		return ss;
		
		
		//좌석불러오기
		
		
		
		
		
		
		
		

	}
}
