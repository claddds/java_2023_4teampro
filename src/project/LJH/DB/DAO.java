package project.LJH.DB;

import java.nio.channels.Selector;
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
	public static List<VO> getMovieList() {
		List<VO> movieList = null;
		movieList = getSession().selectList("prn_movie");
		
		return movieList;
	}
	

	//mapper 로가서 prn_theater sql문 실행하고 값을 가져오자.
	public static List<VO> getTheaterList() {
		List<VO> theaterList = null;
		theaterList = getSession().selectList("prn_theater");
		
		return theaterList;
	}
	
	//mapper 로가서 prn_time sql문 실행하고 값을 가져오자.
	public static List<VO> getTimeList() {
		List<VO> timeList = null;
		timeList = getSession().selectList("prn_time");
		
		return timeList;
	
	}
	//mapper로 가서 인자값 cust_id 받아오면, 그 사람의 포인트를 가져올수있도록 sql
	public static int getPoint (VO vo){
		int point = getSession().selectOne("prn_point", vo);
		return point;
		
	}
	

	
	}
	
