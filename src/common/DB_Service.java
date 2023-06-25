package common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DB_Service {
	//MyBastis를 사용하기 위해 SqlSession클래스가 필요하고 
	//SqlSessionFactory 클래스를 가지고 SqlSession을 만듦
	private static SqlSessionFactory factory;
	static String resource = "common/config.xml";
	
	// static 초기화
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
		}
	}
	
	// DAO에서 factory를 호출할 메서드
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
