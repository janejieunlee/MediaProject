package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import broadcast.model.Broadcast;
import broadcast.service.BroadcastPage;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {

	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(String userId, String new_email, String new_ph_num, String new_introduction, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId);
			if (member == null) {
				throw new MemberNotFoundException();
			}
			
			if (!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			
			member.changePassword(newPwd);
			member.changeEmail(new_email);
			member.changePhoneNumber(new_ph_num);
			member.changeIntroduction(new_introduction);
			memberDao.update(conn, member);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Member userInformation(String userId){
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId);
			return member;
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}	
}
