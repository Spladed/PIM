package db;

import java.util.*;

import java.sql.*;

public class select {
	
	public static Object selectSet(String user,String pass,String table,String content,String[] selectInfo) {
		if(content.equals("*")) {
			String[] temp= {content};
			return selectSet(user, pass, table, temp, selectInfo);
		}
		
		Connection conn=null;	
		Statement stmt=null;
		String sql=null;
		
		try {
			Class.forName(DBINFO.JDBC_DRIVER);
			conn=DriverManager.getConnection(DBINFO.DB_URL,user,pass);
			stmt=conn.createStatement();
			
			if(selectInfo==null) {
				sql="select "+content+" from "+table;
			}
			else {
				sql="select "+content+" from "+table+" where "+selectInfo[0]+"="+selectInfo[1];
			}
			
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getObject(content);
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
		return null;
	}
	
	public static List<HashMap<String, Object>> selectSet(String user,String pass,String table,String[] content,String[] selectInfo) {
		Connection conn=null;	
		Statement stmt=null;
		String sql=null;
		List<HashMap<String, Object>> result=new LinkedList<HashMap<String,Object>>();
		
		try {
			Class.forName(DBINFO.JDBC_DRIVER);
			conn=DriverManager.getConnection(DBINFO.DB_URL,user,pass);
			stmt=conn.createStatement();
			
			if(selectInfo==null) {
				sql="select "+SQLString.construct(content)+" from "+table;
			}
			else {
				sql="select "+SQLString.construct(content)+" from "+table+" where "+selectInfo[0]+"="+selectInfo[1];
			}
			
			ResultSet rs=stmt.executeQuery(sql);
						
			while(rs.next()) {
				HashMap m=new HashMap<String,Object>();
				//���Ҫ����Ĳ�ѯ����Ϊ*,��Ϊ��֪���е����֣�������Ҫ����ResultSetMetaData����ȡ��������HashMap
				if(content.length==1 && content[0].equals("*")) {
					ResultSetMetaData metaData=rs.getMetaData();		//��ȡ�м�
					for(int i=0;i<metaData.getColumnCount();i++) {		//����������ѭ��
						String str=metaData.getColumnName(i+1);
						m.put(str, rs.getObject(str));	//�е����֡������е����ֻ�ȡֵ
					}
				}
				//֪��������е����֣�����ֱ������������ȡ����
				else
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
	
	public static void main(String[] args) {
		String[] content= {"area","room"};
		String[] selectHouseInfo= {"house_id","A1608"};
		List<HashMap<String,Object>> recieve=(List<HashMap<String, Object>>) selectSet("staff","staff","house","*",null);
		for(HashMap<String,Object> m:recieve) {
			System.out.println(m);		
		}
	}
}
