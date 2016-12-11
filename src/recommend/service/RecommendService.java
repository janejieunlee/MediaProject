package recommend.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import broadcast.model.Broadcast;
import jdbc.connection.ConnectionProvider;
import recommend.dao.RecommendationDao;
import recommend.model.Recommendation;

public class RecommendService {
	private RecommendationDao recommendationDao = new RecommendationDao();
	private int size = 5;
	
	public List<Broadcast> getRecommendation(Integer broadcast_id) throws Exception {

// 조회수 높은 3개 아이템 추출할 경우		
//		int viewer_id = 0;
//		int broadcast_id=0;
//		List<Integer> favoriteItems = new ArrayList<>();
//		int ItemSize;
//		int favorites[] = {0};
//		int favoriteItem = 0;
//		
//		try(Connection conn = ConnectionProvider.getConnection()){
//			viewer_id = recommendationDao.convertViewerId(conn, member);
//		}
//		
//		//사용자의 조회수 가장 높은 아이템 3개 추출
//		try(Connection conn = ConnectionProvider.getConnection()){
//			favoriteItem = recommendationDao.selectFavoriteItem(conn, viewer_id);
//			ItemSize = favoriteItems.size();
//		}
//		
//		for(int i=0; i < ItemSize; i++){
//			favorites[i]=favoriteItems.get(i);
//		}
		
		
		List<Broadcast> listB = new ArrayList<Broadcast>();
		//List<Integer> listI = RecommendationDao.recommend(viewer_id);//위에서 추출한 조회수 가장 높은 아이템 3개로 viewer_id 대신 쓰기
		List<Integer> listI = RecommendationDao.recommend(broadcast_id);
		
		for(int i=0; i<listI.size(); i++){
			System.out.println("RecommendService DFS : " + listI.get(i));
			try(Connection conn = ConnectionProvider.getConnection()){
			
				Broadcast broadcast = recommendationDao.select(conn, size, listI.get(i));
				listB.add(broadcast);
			}
		}
		return listB;
	}
}
