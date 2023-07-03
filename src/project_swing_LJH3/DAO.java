package project_swing_LJH3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {


	private static SqlSession ss;
	
	private synchronized static SqlSession getSession(){
		if(ss==null) {
			ss=DBService.getFactory().openSession();
		}
		return ss;
		
	}
	  
	//영화목록 출력하기
	public static VO getMovieName(VO vo) {
		vo = getSession().selectOne("selectMovie");
		return vo;
	}
	
	
	
	
	}