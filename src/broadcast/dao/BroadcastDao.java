package broadcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import broadcast.model.Broadcast;
import broadcast.model.Reservation;
import jdbc.JdbcUtil;

public class BroadcastDao {

	public Broadcast insert(Connection conn, Broadcast broadcast) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
					"insert into broadcast " + "(b_name, b_pic, b_date, b_broadcaster, product_nm, low_price, ctg_id) "
							+ "values (?,?,?,?,?,?,?)");
			pstmt.setString(1, broadcast.getName());
			pstmt.setString(2, broadcast.getPicture());
			pstmt.setTimestamp(3, toTimestamp(broadcast.getDate()));
			pstmt.setString(4, broadcast.getBroadcaster());
			pstmt.setString(5, broadcast.getProductName());
			pstmt.setInt(6, broadcast.getLowPrice());
			pstmt.setInt(7, broadcast.getCtgId());

			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from broadcast");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Broadcast(newNo, broadcast.getName(), broadcast.getPicture(), broadcast.getDate(),
							broadcast.getBroadcaster(), broadcast.getProductName(), broadcast.getLowPrice(),
							broadcast.getCtgId());
				}
			}

			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from broadcast");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Broadcast> select(Connection conn, int startRow, int size, int ctgId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn
					.prepareStatement("select * from broadcast where ctg_id = ? " + "order by b_id desc limit ?, ?");
			pstmt.setInt(1, ctgId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, size);
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

	public List<Broadcast> selectByLately(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from broadcast " + "order by b_date desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);

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

	// 방송 조회
	public Broadcast selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from broadcast where b_id = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Broadcast broadcast = null;
			if (rs.next()) {
				broadcast = new Broadcast(rs.getInt("b_id"), rs.getString("b_name"), rs.getString("b_pic"),
						rs.getTimestamp("b_date"), rs.getString("b_broadcaster"), rs.getString("product_nm"),
						rs.getInt("low_price"), rs.getInt("ctg_id"));
			}
			return broadcast;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void increaseReadCount(Connection conn, String member, int no) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		Integer check = -1;
		int viewer_id = 0;

		try {
			pstmt = conn.prepareStatement("select m_num from member where m_id = ?");
			pstmt.setString(1, member);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				viewer_id = rs.getInt("m_num");
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		try {
			pstmt = conn.prepareStatement("select count(*) from viewinfo where viewer_id=? and broadcast_id=?");
			pstmt.setInt(1, viewer_id);
			pstmt.setInt(2, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = rs.getInt(1);
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		if (check == 0) {

			try {
				pstmt = conn
						.prepareStatement("insert into viewinfo (viewer_id, broadcast_id, read_cnt) values (?,?,?)");
				pstmt.setInt(1, viewer_id);
				pstmt.setInt(2, no);
				pstmt.setInt(3, 0);

				int tmp = pstmt.executeUpdate();

			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}

		try {
			pstmt = conn.prepareStatement(
					"update viewinfo set read_cnt = read_cnt + 1 " + "where viewer_id = ? and broadcast_id = ?");

			pstmt.setInt(1, viewer_id);
			pstmt.setInt(2, no);

			int tmp2 = pstmt.executeUpdate();

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

	public Reservation r_insert(Connection conn, Reservation reservation) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		String fullDate;
		fullDate = reservation.getDate() + " " + reservation.getTime() + ":00";
		Timestamp timestamp = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date parseDate = sdf.parse(fullDate);
			timestamp = new Timestamp(parseDate.getTime());

		} catch (Exception e) {

		}

		try {
			pstmt = conn.prepareStatement("insert into broadcast "
					+ "(b_name, b_date, b_broadcaster, product_nm, low_price, ctg_id) " + "values (?,?,?,?,?,?)");
			pstmt.setString(1, reservation.getName());
			pstmt.setTimestamp(2, timestamp);
			pstmt.setString(3, reservation.getBroadcaster());
			pstmt.setString(4, reservation.getProductName());
			pstmt.setInt(5, reservation.getLowPrice());
			pstmt.setInt(6, reservation.getCtgId());

			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				// 신규 방송 번호를 구한다.
				rs = stmt.executeQuery("select last_insert_id() from broadcast");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Reservation(newNo, reservation.getName(),
							reservation.getDate(), reservation.getTime(), reservation.getBroadcaster(),
							reservation.getProductName(), reservation.getLowPrice(), reservation.getCtgId());
				}
			}

			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	public List<Broadcast> selectByDate(Connection conn, int startRow, int size, String today, String tomorrow)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String todayWithTime = today + " 00:00:00";
		String tomorrowWithTime = tomorrow + " 00:00:00";

		try {
			pstmt = conn.prepareStatement("select * from broadcast where b_date between ? and ?");
			pstmt.setString(1, todayWithTime);
			pstmt.setString(2, tomorrowWithTime);
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

}
