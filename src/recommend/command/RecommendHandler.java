package recommend.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import broadcast.model.Broadcast;
import mvc.command.CommandHandler;
import recommend.dao.RecommendationDao;
import recommend.service.RecommendList;
import recommend.service.RecommendService;
import recommend.service.RecommendationData;

public class RecommendHandler implements CommandHandler{

	private RecommendService recommendService = new RecommendService();
	
//	private static final String SERVERNAME = "localhost";
//	private static final String USERNAME = "root";
//	private static final String PASSWORD = "1004";
//	private static final String DATABASE = "nursnars";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String member = req.getParameter("user");
		int viewer_id = Integer.parseInt(member);
		
		List<Broadcast> recommendList = recommendService.getRecommendation(viewer_id);
		
		
		System.out.println("RecommendHandler -> ");
		
		for(Broadcast broadcast : recommendList) {
			System.out.println("b_id : " + broadcast.getBroadcastId());
			System.out.println("b_name : " + broadcast.getName());
			System.out.println("product_nm : " + broadcast.getProductName());
		}
		
		req.setAttribute("recommendList", recommendList);
			
		return "/WEB-INF/view/main.jsp";
	}
	
}
