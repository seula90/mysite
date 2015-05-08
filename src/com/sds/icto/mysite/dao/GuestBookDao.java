package com.sds.icto.mysite.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.GuestBookVo;


public class GuestBookDao {
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		// 1 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2 connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");

		return conn;
	}

	public void insert(GuestBookVo vo) throws ClassNotFoundException,
			SQLException {
		// 1 connection 생성
		Connection conn = getConnection();

		// 2 Statement 준비
		String sql = "insert into GUESTBOOK values(guestbook_seq.nextval, ?,?,?);";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3 바인딩
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getMsg());
		
		// 4 쿼리실행
		pstmt.executeUpdate();

	}

	
	public void delete(GuestBookVo vo) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		
		String sql = "delete from GUESTBOOK where NO=? and PASSWORD=?";

		// statement 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setLong(1, vo.getNo());
		pstmt.setString(2, vo.getPwd());
		
		pstmt.executeUpdate();
		
		// 자원정리

	/*	try {
			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
		}*/

	}

	public List<GuestBookVo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();

		Connection conn = getConnection();

		// 3 statement 생성
		Statement stmt = conn.createStatement();

		// 4 SQL문 실행
		String sql = "select * from guestbook";

		ResultSet rs = stmt.executeQuery(sql);

		// 5 결과 처리
		while (rs.next()) {
			Long no = rs.getLong(1);
			String nm = rs.getString(2);
			String msg = rs.getString(4);
			

			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);
			vo.setName(nm);
			vo.setMsg(msg);
			
			
			list.add(vo);
		}

		return list;
	}
}
