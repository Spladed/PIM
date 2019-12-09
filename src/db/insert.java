package db;

import java.sql.*;

public class insert {
	public static void insertSet(String user,String pass,String table,String[] column,String[] content) {
		Connection conn=null;	
		Statement stmt=null;
		
		try {
			Class.forName(DBINFO.JDBC_DRIVER);
			conn=DriverManager.getConnection(DBINFO.DB_URL,user,pass);
			stmt=conn.createStatement();
			String sql="insert into "+table+" "+SQLString.insertColumn(column)+" values "+SQLString.insertValues(content);
			stmt.execute(sql);
			stmt.close();
			conn.close();	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null) stmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
