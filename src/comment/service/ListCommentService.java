package comment.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import comment.dao.CommentDao;
import comment.model.Comment;
import jdbc.connection.ConnectionProvider;

public class ListCommentService {
	
	private CommentDao commentDao = new CommentDao();
	private int size = 10;
	
	public CommentPage getCommentPage(int pageNum, String broadcasterId) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = commentDao.SelectCount(conn);
			List<Comment> content = commentDao.select(conn, (pageNum - 1)*size, size, broadcasterId);
			return new CommentPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
