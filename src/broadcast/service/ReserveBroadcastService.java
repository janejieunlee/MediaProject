package broadcast.service;

import java.sql.Connection;
import java.sql.SQLException;

import broadcast.dao.BroadcastDao;
import broadcast.model.Reservation;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ReserveBroadcastService {
	private BroadcastDao broadcastDao = new BroadcastDao();
	
	public Integer Reserve(ReserveRequest req){
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Reservation reservation = toReservation(req);
			Reservation savedReservation = broadcastDao.r_insert(conn, reservation);
			if(savedReservation == null){
				throw new RuntimeException("fail to insert reservation");
			}
			conn.commit();
			return savedReservation.getBroadcastId();
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
	
	private Reservation toReservation(ReserveRequest req){
		return new Reservation(null, req.getName(), req.getDate(), req.getTime(), req.getBroadcaster(),
				req.getProductName(), req.getLowPrice(), req.getCtgId());
	}

}
