package broadcast.service;

import java.sql.Connection;
import java.sql.SQLException;

import broadcast.dao.BroadcastDao;
import broadcast.model.Broadcast;
import jdbc.connection.ConnectionProvider;

public class ReadBroadcastService {
	
	private BroadcastDao broadcastDao = new BroadcastDao();
	
	public BroadcastData getBroadcast(String m_id, int b_id ,boolean increaseReadCount) {
		try(Connection conn = ConnectionProvider.getConnection()){
			Broadcast broadcast = broadcastDao.selectById(conn, b_id);
			if(broadcast == null) {
				throw new BroadcastNotFoundException();
			}

			if(increaseReadCount) {
				broadcastDao.increaseReadCount(conn, m_id ,b_id);
			}

			return new BroadcastData(broadcast);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
