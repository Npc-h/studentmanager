package cn.lanqiao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	static ComboPooledDataSource c3p0 = null;
	static {
		c3p0 = new ComboPooledDataSource();
		try {
			Properties prop = new Properties();
			prop.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			
			c3p0.setDriverClass(prop.getProperty("CLASSNAME"));
			c3p0.setJdbcUrl(prop.getProperty("URL"));
			c3p0.setUser(prop.getProperty("USER"));
			c3p0.setPassword(prop.getProperty("PASSWORD"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static Connection getConnection() throws SQLException{
		return c3p0.getConnection();
	}
	public static void close(Connection conn,PreparedStatement ps ,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}