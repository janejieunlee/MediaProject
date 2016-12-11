package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	
	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where m_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getString("m_id"),
						rs.getString("m_name"), 
						//rs.getString("m_pic"),
						rs.getString("m_email"),
						rs.getString("m_ph_num"),
						rs.getDouble("m_grade"),
						rs.getString("m_password"),
						rs.getString("m_introduction"));
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into member (m_id, m_name, m_email, m_ph_num, m_password) values (?,?,?,?,?)")) {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getEmail());
			pstmt.setString(4, mem.getPhoneNumber());
			pstmt.setString(5, mem.getPassword());
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set m_name = ?, m_email = ?, m_introduction = ?, m_ph_num = ?, m_password = ? where m_id = ?")) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getIntroduction());
			pstmt.setString(4, member.getPhoneNumber());
			pstmt.setString(5, member.getPassword());
			pstmt.setString(6, member.getId());
			pstmt.executeUpdate();
		}
	}
}
