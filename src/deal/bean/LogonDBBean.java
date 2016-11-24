package deal.bean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	// 회원 DB 테이블에 회원 insert
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
			
			pstmt = conn.prepareStatement("select passwd from member where id = ?") ;
			pstmt.setString(1,id) ;
			rs=pstmt.executeQuery() ;
			
			if(rs.next()){
				String dbpasswd = rs.getString("passwd");
				if(passwd == dbpasswd ){
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

	// 아이디 중복여부 확인
	public int confirmId(String id) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int x = -1;

	try {
		conn = getConnection();
		pstmt = conn.prepareStatement("select id from member where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			x = 1; // id 중복
		} else {
			x = -1; // id 중복x
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
}
