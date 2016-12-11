package search.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentPage;
import comment.service.ListCommentService;
import member.model.Member;
import member.service.ChangePasswordService;
import mvc.command.CommandHandler;
import search.service.SearchBroadcastPage;
import search.service.SearchBroadcasterPage;
import search.service.SearchService;

public class SearchHandler implements CommandHandler {

	private SearchService searchService = new SearchService();
	private ListCommentService listService = new ListCommentService();
	private ChangePasswordService changePwdSvc = new ChangePasswordService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String searchId = req.getParameter("searchId");
		String searchWord = req.getParameter("word");
		String pageNoVal = req.getParameter("pageNo");

		int searchOption = -1;

		if (searchId.equals("상품명")) {
			searchOption = 0;
		} else if (searchId.equals("판매자")) {
			searchOption = 1;
		}

		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}

		if (searchOption == 0) {
			SearchBroadcastPage searchPage = searchService.getSearchBroadcastPage(pageNo, searchOption, searchWord);
			req.setAttribute("searchPage", searchPage);
			return "/WEB-INF/view/listSearchResult.jsp";
		} else if (searchOption == 1) {
			CommentPage commentPage = listService.getCommentPage(pageNo, searchWord);
			Member broadcasterPage = changePwdSvc.userInformation(searchWord);
			req.setAttribute("broadcasterPage", broadcasterPage);

			req.setAttribute("commentPage", commentPage);
			req.setAttribute("myPageId", searchWord);

			return "/WEB-INF/view/broadcasterPage.jsp";
		}
		return null;
	}
}
