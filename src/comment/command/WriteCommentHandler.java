package comment.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import comment.service.WriteCommentService;
import comment.service.WriteRequest;
import mvc.command.CommandHandler;

public class WriteCommentHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/newCommentForm.jsp";
	private WriteCommentService writeService = new WriteCommentService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User) req.getSession(false).getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user, req);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int newCommentNo = writeService.write(writeReq);
		req.setAttribute("newCommentNo", newCommentNo);
		String subject = (String) req.getAttribute("subject");

		req.setAttribute("subject", subject);
		return "/WEB-INF/view/newCommentSuccess.jsp";
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		String grade = req.getParameter("searchGrade");
		System.out.println("grade -> " + grade);
		double grade2 = 0;
		grade2 = Double.parseDouble(grade);

		return new WriteRequest(user.getId(), req.getParameter("subject"), req.getParameter("content"), grade2);
	}
}
