package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.BoardVo;

public class BoardDao {
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

	public void insert(BoardVo vo) throws ClassNotFoundException, SQLException {

		// 1 connection 생성
		Connection conn = getConnection();

		// 2 Statement 준비

		String sql = "insert into board values(board_no_seq.nextval,?,?,?,?,?,sysdate)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3 바인딩
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setLong(3, vo.getMemberno());
		pstmt.setString(4, vo.getMembername());
		pstmt.setLong(5, vo.getViewcnt());

		// 4 쿼리실행
		pstmt.executeUpdate();

	}

	public void delete(BoardVo vo) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();

		String sql = "delete from board where NO=? and Memberno=?";

		// statement 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, vo.getNo());
		pstmt.setLong(2, vo.getMemberno());

		pstmt.executeUpdate();

		// 자원정리

		/*
		 * try { if (pstmt != null) { pstmt.close(); }
		 * 
		 * if (conn != null) { conn.close(); } } catch (SQLException ex) { }
		 */

	}

	public BoardVo View(BoardVo vo) throws ClassNotFoundException, SQLException {
				
		Connection conn = getConnection();

		String sql = "select * from board where no=?";
		// 3 statement 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 4 SQL문 실행
		pstmt.setLong(1, vo.getNo());
		
		
		pstmt.executeQuery();
		
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		// 5 결과 처리
		
		
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			//Long memberno = rs.getLong(4);
			String membername = rs.getString(5);
			Long viewcnt = rs.getLong(6);
			String date = rs.getString(7);
			
			BoardVo vo2 = new BoardVo();
			vo2.setNo(no);
			vo2.setTitle(title);
			vo2.setContent(content);
			//vo2.setMemberno(memberno);
			vo2.setMembername(membername);
			vo2.setViewcnt(viewcnt);
			vo2.setDate(date);
			
			return vo2;

		}
		
	public BoardVo update(BoardVo vo) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();

		String sql = "select * from board where no=?";
		// 3 statement 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 4 SQL문 실행
		pstmt.setLong(1, vo.getNo());
		
		
		pstmt.executeQuery();
		
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		// 5 결과 처리
		
		
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			//Long memberno = rs.getLong(4);
			String membername = rs.getString(5);
			Long viewcnt = rs.getLong(6);
			String date = rs.getString(7);
			
			BoardVo vo2 = new BoardVo();
			vo2.setNo(no);
			vo2.setTitle(title);
			vo2.setContent(content);
			//vo2.setMemberno(memberno);
			vo2.setMembername(membername);
			vo2.setViewcnt(viewcnt);
			vo2.setDate(date);
			
			return vo2;

		}
	

	public List<BoardVo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<BoardVo> list = new ArrayList<BoardVo>();

		Connection conn = getConnection();

		// 3 statement 생성
		Statement stmt = conn.createStatement();

		// 4 SQL문 실행
		String sql = "select * from board";
		ResultSet rs = stmt.executeQuery(sql);

		// 5 결과 처리
		while (rs.next()) {

			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			Long memberno = rs.getLong(4);
			String membername = rs.getString(5);
			Long viewcnt = rs.getLong(6);
			String date = rs.getString(7);

			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMemberno(memberno);
			vo.setMembername(membername);
			vo.setViewcnt(viewcnt);
			vo.setDate(date);

			list.add(vo);

		}
		return list;
	}

}
