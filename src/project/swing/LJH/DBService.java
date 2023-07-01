package project.swing.LJH;

import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {

    private SqlSessionFactory sqlSessionFactory;

    public DBService() {
        String resource = "config.xml";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }
    
    
}