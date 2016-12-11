package recommend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.IDRescorer;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.Rescorer;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.common.LongPair;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import broadcast.model.Broadcast;
import jdbc.JdbcUtil;
import recommend.model.Recommendation;

public class RecommendationDao {
	private static final String SERVERNAME = "35.162.132.169";
	private static final String USERNAME = "mediaproject";
	private static final String PASSWORD = "1234";
	private static final String DATABASE = "nursnars";

	public static List<Integer> recommend(int broadcast_id) throws Exception {

		System.out.println("RecommendationDao -> ");
		System.out.println("broadcast_id : " + broadcast_id);

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName(SERVERNAME);
		dataSource.setUser(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setDatabaseName(DATABASE);

		List<Integer> listB = new ArrayList<Integer>();

		try {
			JDBCDataModel model = new MySQLJDBCDataModel(dataSource, "viewinfo", "viewer_id", "broadcast_id",
					"read_cnt", null);

			// 유사도 측정, 다른 유사도 써도 됨
			TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(model);
			// ItemSimilarity sim = new PearsonCorrelationSimilarity(model);
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, sim);

			// model.getNumItems();

			int x = 1;
			for (LongPrimitiveIterator items = model.getItemIDs(); items.hasNext();) {
				long itemID = items.nextLong();

				List<RecommendedItem> recommendations = recommender.mostSimilarItems(itemID, 4);

				for (RecommendedItem recommendation : recommendations) {
					System.out.println("itemID : " + itemID + ", getItemID : " + recommendation.getItemID() + " , "
							+ recommendation.getValue());

					if (itemID == broadcast_id) { //
						System.out.println("i'me here" + (int) recommendation.getItemID());
						listB.add((int) recommendation.getItemID());
					}
				}
				x++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listB;
	}

	public int convertViewerId(Connection conn, String member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int viewer_id = 0;

		try {
			pstmt = conn.prepareStatement("select m_num from member where m_id = ?");
			pstmt.setString(1, member);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				viewer_id = rs.getInt("m_num");
			}
			return viewer_id;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 해당 사용자의 가장 높은 조회수 아이템 3개 추출
	public int selectFavoriteItem(Connection conn, int viewer_id) throws SQLException, IndexOutOfBoundsException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int favoriteItem = 0;

		System.out.println("selectFavoriteItem viewer_id: " + viewer_id);
		try {
			pstmt = conn.prepareStatement(
					"select broadcast_id from viewinfo where viewer_id = ? order by read_cnt desc limit 1"); // limit
																												// 3
			pstmt.setInt(1, viewer_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				favoriteItem = rs.getInt("broadcast_id");
			}

			return favoriteItem;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

	}

	public Broadcast select(Connection conn, int size, int b_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from broadcast where b_id = ?");
			pstmt.setInt(1, b_id);
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

}
