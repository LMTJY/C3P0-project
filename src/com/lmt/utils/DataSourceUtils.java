package com.lmt.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class DataSourceUtils {
  private static ComboPooledDataSource ds = new ComboPooledDataSource();
  /**
   * 获取数据源
   * @return
   */
  public static DataSource getDataSource() {
	  return ds;
  }
  /**
   * 获取连接
   * @return 连接
   * @throws SQLException
   */
 public static Connection getConnection() throws SQLException {
	 return ds.getConnection();
 }
 /**
  * 释放链接
  * @param conn
  * @param st
  * @param rs
  */
 public static void closeResource(Connection conn,Statement st,ResultSet rs) {
	 closeResultSet(rs);
	 closeStatement(st);
	 closeConn(conn);
 }
   private static void closeConn(Connection conn){
	   if(conn != null) {
		   try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   conn =null;
	   }
}
private static void closeStatement(Statement st) {
	if(st != null) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st = null;
	}
}
private static void closeResultSet(ResultSet rs) {
	if(rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	rs = null;
}
/**
 * 测试连接
 * @throws SQLException
 */
	@Test
   public void test() throws SQLException {
	   System.out.println(ds.getClass());
	   System.out.println(ds.getConnection().toString());
   }
}