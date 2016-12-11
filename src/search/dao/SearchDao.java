package search.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import broadcast.model.Broadcast;
import comment.model.Comment;
import jdbc.JdbcUtil;

public class SearchDao {
	//조회수
	public int selectCount(Connection conn, String searchWord) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select count(*) from broadcast where product_nm = ?");
			pstmt.setString(1, searchWord);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	//검색결과
	public List<Broadcast> selectByProduct_nm(Connection conn, int startRow, int size, String searchWord)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from broadcast where product_nm = ?");
			pstmt.setString(1, searchWord);

			rs = pstmt.executeQuery();

			List<Broadcast> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertBroadcast(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Broadcast convertBroadcast(ResultSet rs) throws SQLException {
		return new Broadcast(rs.getInt("b_id"), rs.getString("b_name"), rs.getString("b_pic"),
				toDate(rs.getTimestamp("b_date")), rs.getString("b_broadcaster"), rs.getString("product_nm"),
				rs.getInt("low_price"), rs.getInt("ctg_id"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public List<Comment> selectByBroadcast_Id(Connection conn, int startRow, int size, String searchWord)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from comment where subject = ?");
			pstmt.setString(1, searchWord);

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
