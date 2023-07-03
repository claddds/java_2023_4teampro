package project.LJH.DB2;

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

	public static List<VO> getMovieList() {
		List<VO> movieList = getSession().selectList("getMovieList");
		return movieList;
	}
	

	
	public static List<VO> getTheaterList() {
		List<VO> theaterList= getSession().selectList("theaterOne");	
		return theaterList;	
	
	}
	

	public static List<VO> getTimeList() {
		List<VO> timeList = getSession().selectList("timeOne");	
		return timeList;	
	
	}
	
	public static int getPoint(VO vo) {
		int chargepoint = getSession().selectOne("point", vo);
		return chargepoint;
	}
	

	
	}
	
