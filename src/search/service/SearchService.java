package search.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import broadcast.model.Broadcast;
import comment.model.Comment;
import jdbc.connection.ConnectionProvider;
import search.dao.SearchDao;

public class SearchService {
	private SearchDao searchDao = new SearchDao();
	private int size = 10;
	
	public SearchBroadcastPage getSearchBroadcastPage(int pageNum, int searchOption, String searchWord) {
		
		try (Connection conn = ConnectionProvider.getConnection()) {			
			int total = searchDao.selectCount(conn, searchWord);
			List<Broadcast> content = null;
			content = searchDao.selectByProduct_nm(conn, size, (pageNum-1)*size, searchWord);		
			return new SearchBroadcastPage(total, pageNum, size, content);

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public SearchBroadcasterPage getSearchBroadcasterPage(int pageNum, int searchOption, String searchWord) {
	
		try (Connection conn = ConnectionProvider.getConnection()) {		
			int total = searchDao.selectCount(conn, searchWord);
			List<Comment> content = null;;
			content = searchDao.selectByBroadcast_Id(conn,size, (pageNum-1)*size, searchWord);
			return new SearchBroadcasterPage(total, pageNum, size, content);

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
