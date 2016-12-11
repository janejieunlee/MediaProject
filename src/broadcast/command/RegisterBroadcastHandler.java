package broadcast.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import auth.service.User;
import broadcast.service.RegisterBroadcastService;
import broadcast.service.RegisterRequest;
import mvc.command.CommandHandler;

public class RegisterBroadcastHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/newBroadcastForm.jsp";
	private RegisterBroadcastService registerService = new RegisterBroadcastService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User) req.getSession(false).getAttribute("authUser");
		RegisterRequest registerReq;

		registerReq = createRegisterRequest(user, req);
		int newBroadcastNo = registerService.Register(registerReq);
		req.setAttribute("newBroadcastNo", newBroadcastNo);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		return "/WEB-INF/view/newBroadcastSuccess.jsp";

	}

	private RegisterRequest createRegisterRequest(User user, HttpServletRequest req)
			throws IOException {

		String savePath = req.getServletContext().getRealPath("/images");
		int sizeLimit = 1024 * 1024 * 15;

		System.out.println("savePath -> " + savePath);

		MultipartRequest multi = new MultipartRequest(req, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

		int ctgId = 0;
		if (multi.getParameter("ctgId").equals("패션의류"))
			ctgId = 1;
		else if (multi.getParameter("ctgId").equals("잡화/명품"))
			ctgId = 2;
		else if (multi.getParameter("ctgId").equals("화장품"))
			ctgId = 3;
		else if (multi.getParameter("ctgId").equals("유아동/문화"))
			ctgId = 4;
		else if (multi.getParameter("ctgId").equals("스포츠/여행"))
			ctgId = 5;
		else if (multi.getParameter("ctgId").equals("식품/주방"))
			ctgId = 6;
		else if (multi.getParameter("ctgId").equals("가구/생활"))
			ctgId = 7;
		else if (multi.getParameter("ctgId").equals("가전/컴퓨터"))
			ctgId = 8;

		String name = multi.getParameter("name");
		String picture = multi.getFilesystemName("picture");
		String userId = user.getId();
		String productName = multi.getParameter("productName");
		String lowPrice = multi.getParameter("lowPrice");

		return new RegisterRequest(name, picture, user.getId(), productName, Integer.parseInt(lowPrice), ctgId);
	}

}
