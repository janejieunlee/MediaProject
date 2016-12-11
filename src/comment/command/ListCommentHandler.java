package comment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import comment.service.CommentPage;
import comment.service.ListCommentService;
import member.model.Member;
import member.service.ChangePasswordService;
import mvc.command.CommandHandler;

public class ListCommentHandler implements CommandHandler{
	
	private ListCommentService listService = new ListCommentService();
	private ChangePasswordService changePwdSvc = new ChangePasswordService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		String broadcasterId = req.getParameter("user");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		Member broadcasterPage = changePwdSvc.userInformation(broadcasterId);
		req.setAttribute("broadcasterPage", broadcasterPage);	
		
		CommentPage commentPage = listService.getCommentPage(pageNo, broadcasterId);
		req.setAttribute("commentPage", commentPage);
		req.setAttribute("myPageId", broadcasterId);
		return "/WEB-INF/view/broadcasterPage.jsp";
	}
}
