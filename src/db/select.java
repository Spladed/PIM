package db;

import java.util.*;

import java.sql.*;

public class select {
	private static String user="root";
	private static String pass="niunian052170";
	
	public static List<HashMap<String, Object>> selectSet(String table,String[] content) {
		Connection conn=null;	
		Statement stmt=null;
		String sql=null;
		List<HashMap<String, Object>> result=new LinkedList<HashMap<String,Object>>();
		
		try {
			Class.forName(DBINFO.JDBC_DRIVER);
			conn=DriverManager.getConnection(DBINFO.DB_URL,user,pass);
			stmt=conn.createStatement();
			
			sql="select "+SQLString.construct(content)+" from "+table;
			
			ResultSet rs=stmt.executeQuery(sql);
						
			while(rs.next()) {
				HashMap m=new HashMap<String,Object>();				
				for(int i=0;i<content.length;i++) {
					m.put(content[i], rs.getObject(content[i]));
				}
				result.add(m);
			}
			rs.close();
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
		return result;
	}
}
