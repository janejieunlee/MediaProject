package broadcast.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import broadcast.dao.BroadcastDao;
import broadcast.model.Broadcast;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class RegisterBroadcastService {
	private BroadcastDao broadcastDao = new BroadcastDao();

	public Integer Register(RegisterRequest req){
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Broadcast broadcast = toBroadcast(req);
			Broadcast savedBroadcast = broadcastDao.insert(conn, broadcast);
			if(savedBroadcast == null){
				throw new RuntimeException("fail to insert broadcast");
			}
			conn.commit();
			return savedBroadcast.getBroadcastId();
			
		} catch(SQLException e){
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch(RuntimeException e){
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	private Broadcast toBroadcast(RegisterRequest req){
		Date now = new Date();
		return new Broadcast(null, req.getName(), req.getPicture(), now, req.getBroadcaster(),
				req.getProductName(), req.getLowPrice(), req.getCtgId());
	}
	
}
