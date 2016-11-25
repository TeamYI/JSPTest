package deal.bean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LogonDBBean {
	private static LogonDBBean instance = new LogonDBBean();

	private LogonDBBean() {
	}

	public static LogonDBBean getInstance() {
	return instance;
	}

	// DB Connection
	public Connection getConnection() throws Exception {
	Context initCtx = new InitialContext();
	Context envCtx = (Context) initCtx.lookup("java:comp/env");
	DataSource ds = (DataSource) envCtx.lookup("jdbc/test");

	return ds.getConnection();
	}

	// ȸ�� DB ���̺� ȸ�� insert
	public void insertUser(LogonDataBean users) {
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = getConnection();

		pstmt = conn.prepareStatement("insert into users values(?, ?)");
		pstmt.setString(1, users.getId());
		pstmt.setString(2, users.getPasswd());
		pstmt.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}
	}
	}
	
	public int userCheck(String id,String passwd){
		
		Connection conn = null ;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		int i  = 0 ;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select passwd from users where id = ?") ;
			pstmt.setString(1,id) ;
			rs=pstmt.executeQuery() ;
			
			if(rs.next()){
				String dbpasswd = rs.getString("passwd");
				if(passwd.equals(dbpasswd)){
					return i = 1  ;
				}else{
					return i ;
				}
				
			}else return i  ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	//아이디 중복체크
	public int confirmId(String id) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int x = -1;

	try {
		conn = getConnection();
		pstmt = conn.prepareStatement("select id from users where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			x = 1; // id가 있음
		} else {
			x = -1; // id가 없음
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}
	}
	return x;
	}

	
	public ArrayList<LogonDataBean> usersView() throws Exception {
		Connection			conn	=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		
		conn	=	getConnection();
		pstmt	=	conn.prepareStatement("select * from users");
		rs		=	pstmt.executeQuery();
		
		ArrayList<LogonDataBean>	result	=	new	ArrayList<LogonDataBean>();
		
		while(rs.next()) {
			LogonDataBean	data	=	new	LogonDataBean();
			data.setId(rs.getString("id"));
			data.setPasswd(rs.getString("passwd"));
			result.add(data);
		}
		return	result;
	}
}
