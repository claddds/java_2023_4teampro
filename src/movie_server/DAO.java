package movie_server;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

//DB처리하는 메서드들을 가지고 있는 클래스
public class DAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	// 싱글턴 패턴 (동기화처리) : 프로그램이 종료될 때 까지 한번 만들어진 객체를 재 사용한다.
		private synchronized  static SqlSession getSession() {
			if(ss == null) {
				ss = DBService.getFactory().openSession();
			}
			return ss;
		}
		
		// DB처리하는 메서드들
		// customer 테이블 전체보기 
		// select , 결과는 여러개 , 파라미터가 없음
		public static List<CustomerVO> getList() {
			List<CustomerVO> list = null;
			// selectList() : 결과가 하나이상일때 
			// selectOne()  : 반드시 결과가 하나일때
			// 파라미터가 있는 메서드와 파라미터가 없는메서드로 나눈다.
			// 파라미터가 있는 메서드 : selectList("mepper의 id",파라미터);
			// 파라미터가 없는 메서드  : selectList("mepper의 id")
			list = getSession().selectList("custList");
			return list;
		}
		
		// select, 결과는 하나, 파라미터 있음(String)
		public static CustomerVO getOne(String cust_id) {
			CustomerVO vo = getSession().selectOne("custOne", cust_id);
			return vo;
		}
		
		// insert, delete, update 결과 int, 파라미터있음
		// 반드시  commit를 해야 된다.
		public static int getIns(CustomerVO vo) {
			int result = 0;
			if(!(vo.getCust_id().isEmpty())) {
				result = getSession().insert("custins", vo);
				ss.commit();
				return result;
			}else
			return 0;
		}
		
		public static int getDelete(CustomerVO vo) {
			int result = getSession().delete("custdel", vo);
			ss.commit();
			return result;
		}
		public static int getUpdate(CustomerVO vo) {
			int result = getSession().update("custupdate", vo);
			ss.commit();
			return result;
		}
		public static int getIdChk(String cust_id) {
			int result = 0;
			CustomerVO vo = getSession().selectOne("idchk", cust_id);
			return result;
		}
		
		public static CustomerVO getLogin(CustomerVO vo1) {
			CustomerVO vo = null;
			vo = getSession().selectOne("login", vo1);
			return vo;
		}
		
		/*
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
		*/
		
		
}
