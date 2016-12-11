package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comment.model.Comment;
import jdbc.JdbcUtil;

public class CommentDao {

	public Comment insert(Connection conn, Comment comment) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn
					.prepareStatement("insert into comment " + "(writer,subject,content,grade)" + "values (?,?,?,?)");
			pstmt.setString(1, comment.getWriter());
			pstmt.setString(2, comment.getSubject());
			pstmt.setString(3, comment.getContent());
			pstmt.setDouble(4, comment.getGrade());

			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from comment");
				if (rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Comment(newNum, comment.getWriter(), comment.getSubject(), comment.getContent(),
							comment.getGrade());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	public int SelectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from comment");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Comment> select(Connection conn, int startRow, int size, String broadcasterId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from comment where subject = ? " + "order by c_id desc limit ?,?");
			pstmt.setString(1, broadcasterId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, size);
			rs = pstmt.executeQuery();
			List<Comment> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertComment(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Comment convertComment(ResultSet rs) throws SQLException {
		return new Comment(rs.getInt("c_id"), rs.getString("writer"), rs.getString("subject"), rs.getString("content"),
				rs.getDouble("grade"));
	}
}
