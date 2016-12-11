package broadcast.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import broadcast.service.BroadcastPage;
import broadcast.service.ListBroadcastService;
import mvc.command.CommandHandler;

public class MainHandler implements CommandHandler{
	private ListBroadcastService listService = new ListBroadcastService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String pageNoVal = req.getParameter("pageNo");
		
		int pageNo = 1;
		if(pageNoVal != null){
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		BroadcastPage broadcastPage = listService.getMainPage(pageNo);

		req.setAttribute("broadcastPage", broadcastPage);
		return "/WEB-INF/view/main.jsp";
	}

}
