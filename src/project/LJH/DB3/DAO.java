package project.LJH.DB3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import oracle.net.nt.ConnectDescription;

public class DAO {
	
	Connection conn =null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	private static DAO dao = new DAO();
	public static DAO getInstance() {
		return dao;
	}

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##JERRY";
			String password = "1111";
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {			
		}
		return null;
	}
	
	public ArrayList<VO> getSelectMovie() {
		try {
			conn=getConnection();
			String sql = "select movie_name from movie";
			pstm = conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			ArrayList<VO> list = new ArrayList<>();
			while(rs.next()) {
				VO vo = new VO();
				vo.setMovie_name(rs.getString(1));
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
		}	finally {
				try {
					pstm.close();
					conn.close();
				} catch (Exception e2) {
				}
			}
			return null;
		}
	}
	
	
	
	
	
