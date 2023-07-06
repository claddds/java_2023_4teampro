package project.LJH.DB3;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//이걸로 합치기
public class DBService {
	private static SqlSessionFactory factory;
	static String resource = "project/LJH/DB/config.xml";
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
		}
	}

//DAO 에서 factory 를 호출할 메서드
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	
	
	
}
