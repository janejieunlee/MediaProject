package broadcast.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import broadcast.dao.BroadcastDao;
import broadcast.model.Broadcast;
import jdbc.connection.ConnectionProvider;

public class ListBroadcastService {
	private BroadcastDao broadcastDao = new BroadcastDao();
	private int size = 10;
	
	public BroadcastPage getBroadcastPage(int pageNum, int ctgId){
		try(Connection conn = ConnectionProvider.getConnection()){
			int total = broadcastDao.selectCount(conn);
			List<Broadcast> content = broadcastDao.select(conn, (pageNum-1)*size, size, ctgId);
			return new BroadcastPage(total, pageNum, size, content);
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public BroadcastPage getSchedulePage(int pageNum, String today, String tomorrow){
		try(Connection conn = ConnectionProvider.getConnection()){
			int total = broadcastDao.selectCount(conn);			
			List<Broadcast> content = broadcastDao.selectByDate(conn,(pageNum-1)*size, size, today, tomorrow);
			return new BroadcastPage(total, pageNum, size, content);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public BroadcastPage getMainPage(int pageNum){
		try(Connection conn = ConnectionProvider.getConnection()){
			int total = broadcastDao.selectCount(conn);
			List<Broadcast> content = broadcastDao.selectByLately(conn, (pageNum-1)*size, size);
			return new BroadcastPage(total, pageNum, size, content);
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
