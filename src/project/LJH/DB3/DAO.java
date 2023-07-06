package project.LJH.DB3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
//이걸로 합치기
public class DAO {
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) { // null이라는건 안만들어졌다 라는것
			ss = DBService.getFactory().openSession();
		}
		return ss;

	}

	// mapper 로가서 prn_movie sql문 실행하고 값을 가져오자.
	public static List<VO> getMovie_name() {
		System.out.println("DAO와서 sql문 하고올게요");

		List<VO> movieList = getSession().selectList("movie.movieList");
		System.out.println("mapper다녀왔어요" + movieList);
		return movieList;
	}

	// mapper 로가서 prn_time sql문 실행하고 값을 가져오자.
	public static List<VO> getStart_time() {
		System.out.println("DAO와서 sql문11 하고올게요");
		List<VO> stimeList = getSession().selectList("movie.stimeList");

		return stimeList;

	}

	public static List<VO> getEnd_time() {
		System.out.println("DAO와서 sql문22 하고올게요");
		List<VO> etimeList = getSession().selectList("movie.etimeList");

		return etimeList;

	}
	public static List<VO> getMovieTimes(String movieTitle) {
		List<VO> vo = getSession().selectList("movie.getMovieTimes", movieTitle);
		
		return vo;
	}

	// mapper로 가서 인자값 cust_id 받아오면, 그 사람의 포인트를 가져올수있도록 sql
	public static VO getPoint(String cust_id) {
		VO vo = getSession().selectOne("point", cust_id);
		return vo;

	}

	}