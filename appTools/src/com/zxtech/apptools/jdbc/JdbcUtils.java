package com.zxtech.apptools.jdbc;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zxtech.apptools.ConfigUtil;
public class JdbcUtils {
	
	private static Connection conn = null;
	static String  url=ConfigUtil.getValue("jdbc.url"), user=ConfigUtil.getValue("jdbc.username"),
			password=ConfigUtil.getValue("jdbc.password"), driver=ConfigUtil.getValue("jdbc.driver");
	
	static{
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//��̬����, �ر�
	public static void release(Connection conn, PreparedStatement stmt, ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//��̬����, �ر�
	public static void release(Connection conn, CallableStatement stmt, ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		JdbcUtils.getConnection();
	}
	
	
	
}
