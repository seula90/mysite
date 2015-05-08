package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sds.icto.mysite.vo.MemberVo;

public class MemberDao {
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

	public void insert(MemberVo vo) throws ClassNotFoundException, SQLException {

		// 1 connection 생성
		Connection conn = getConnection();

		// 2 Statement 준비
		String sql = "insert into member values(member_no_seq.nextval, ?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3 바인딩
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getPassword());
		pstmt.setString(4, vo.getGender());

		// 4 쿼리실행
		pstmt.executeUpdate();

	}

	public MemberVo getMember(MemberVo vo) throws ClassNotFoundException,
			SQLException {

		Connection conn = getConnection();

		String sql = "SELECT * from member where email=? and password=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getEmail());
		pstmt.setString(2, vo.getPassword());

		ResultSet rs = pstmt.executeQuery();

		MemberVo memberVo = null;

		if (rs.next()) {

			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			// String pwd = rs.getString(4);
			String gender = rs.getString(5);

			memberVo = new MemberVo();

			memberVo.setNo(no);
			memberVo.setName(name);
			memberVo.setEmail(email);
			// vo.setPassword(pwd);
			memberVo.setGender(gender);

		}

		rs.close();
		pstmt.close();
		conn.close();

		return memberVo;
	}
}
