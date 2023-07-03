package c_loginout;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

//DB처리하는 메서드들을 가지고 있는 클래스
public class Loginout_DAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	// 싱글턴 패턴 (동기화처리) : 프로그램이 종료될 때 까지 한번 만들어진 객체를 재 사용한다.
		private synchronized  static SqlSession getSession() {
			if(ss == null) {
				ss = Loginout_DBService.getFactory().openSession();
			}
			return ss;
		}
		
		// DB처리하는 메서드들
		// customer 테이블 전체보기 
		// select , 결과는 여러개 , 파라미터가 없음
		public static List<Loginout_VO> getList(){
			List<Loginout_VO> list = null;
			// selectList() : 결과가 하나이상일때 
			// selectOne()  : 반드시 결과가 하나일때
			// 파라미터가 있는 메서드와 파라미터가 없는메서드로 나눈다.
			// 파라미터가 있는 메서드 : selectList("mepper의 id",파라미터);
			// 파라미터가 없는 메서드  : selectList("mepper의 id")
			list = getSession().selectList("custList");
			return list;
		}
		// select, 결과는 하나, 파라미터 있음(String)
		public static Loginout_VO getOne(String cust_id) {
			Loginout_VO vo = getSession().selectOne("custOne", cust_id);
			return vo;
		}
}
