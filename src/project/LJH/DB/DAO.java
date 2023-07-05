package project.LJH.DB;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;	
	private synchronized static SqlSession getSession() {
		if(ss==null) { //null이라는건 안만들어졌다 라는것
			ss=DBService.getFactory().openSession();		
		}
		return ss;
		
	}
	
	//mapper 로가서 prn_movie sql문 실행하고 값을 가져오자.
	public static List<VO> getMovie_name() {
		System.out.println("DAO");			
		List<VO> movieList = null;
		movieList = getSession().selectList("movieList");
		System.out.println("mapper다녀왓니");
		return movieList;
	}
	
	
	//mapper 로가서 prn_time sql문 실행하고 값을 가져오자.
	public static List<VO> getStart_time() {
		List<VO> stimeList = null;
		stimeList = getSession().selectList("stimeList");
		
		return stimeList;
	
	}
	
	public static List<VO> getEnd_time() {
		List<VO> etimeList = null;
		etimeList = getSession().selectList("etimeList");
		
		return etimeList;
	
	}
	
	//mapper로 가서 인자값 cust_id 받아오면, 그 사람의 포인트를 가져올수있도록 sql
	public static VO getPoint (String cust_id){
		VO vo =getSession().selectOne("point", cust_id);
		return vo;
		
	}
	

	
	}
	
