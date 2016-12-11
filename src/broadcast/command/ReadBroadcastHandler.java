package broadcast.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import broadcast.model.Broadcast;
import broadcast.service.BroadcastData;
import broadcast.service.BroadcastNotFoundException;
import broadcast.service.ReadBroadcastService;
import mvc.command.CommandHandler;
import recommend.service.RecommendService;

public class ReadBroadcastHandler implements CommandHandler{

	private ReadBroadcastService readService = new ReadBroadcastService();
	private RecommendService recommendService = new RecommendService();
		
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		String member = req.getParameter("user");
		int b_id = Integer.parseInt(noVal);
		String m_id = member;
		
		List<Broadcast> recommendList = recommendService.getRecommendation(/*m_id,*/b_id);
		try{
			BroadcastData broadcastData = readService.getBroadcast(m_id ,b_id, true);

			req.setAttribute("broadcastData", broadcastData);
			req.setAttribute("recommendList", recommendList);	//추천리스트
			return "/WEB-INF/view/readBroadcast.jsp";
		} catch (BroadcastNotFoundException e) {
			req.getServletContext().log("no broadcast", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
