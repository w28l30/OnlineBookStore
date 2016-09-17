package cn.w28l30.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;


public class JdbcUtils {
	
	private static DataSource ds;
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	static {
		Properties prop = new Properties();
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
		try {
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError();
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() {
		try{
			Connection conn = tl.get();
			if(conn==null){
				conn = ds.getConnection();
				conn.setAutoCommit(false);
			}
			tl.set(conn);
			return conn;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void startTranscation() {
		
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static void commitTranscation() {
		try {
			Connection conn = getConnection();
			if (conn != null) conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static void closeTranscation() {
		Connection conn = null;
		try{
			conn = getConnection();
			if(conn!=null){
				conn.close();
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tl.remove();
		}
	}
}
