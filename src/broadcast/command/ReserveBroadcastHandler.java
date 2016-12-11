package broadcast.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import broadcast.service.ReserveBroadcastService;
import broadcast.service.ReserveRequest;
import mvc.command.CommandHandler;

public class ReserveBroadcastHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/newReserveForm.jsp";
	private ReserveBroadcastService reserveService = new ReserveBroadcastService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res){
		if(req.getMethod().equalsIgnoreCase("GET")){
			return processForm(req,res);
		} else if(req.getMethod().equalsIgnoreCase("POST")){
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res){
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res){
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		//사용자
		User user = (User)req.getSession(false).getAttribute("authUser");
		ReserveRequest reserveReq = createReserveRequest(user,req);
		
		if(!errors.isEmpty()){
			return FORM_VIEW;
		}
		
		int newReserveNo = reserveService.Reserve(reserveReq);
		req.setAttribute("newReserveNo", newReserveNo);
		return "/WEB-INF/view/newReserveSuccess.jsp";
	}
	
	private ReserveRequest createReserveRequest(User user, HttpServletRequest req){
		
		int ctgId =0;
		if(req.getParameter("ctgId").equals("패션의류"))
			ctgId=1;
		else if(req.getParameter("ctgId").equals("잡화/명품"))
			ctgId=2;
		else if(req.getParameter("ctgId").equals("화장품"))
			ctgId=3;
		else if(req.getParameter("ctgId").equals("유아동/문화"))
			ctgId=4;
		else if(req.getParameter("ctgId").equals("스포츠/여행"))
			ctgId=5;
		else if(req.getParameter("ctgId").equals("식품/주방"))
			ctgId=6;
		else if(req.getParameter("ctgId").equals("가구/생활"))
			ctgId=7;
		else if(req.getParameter("ctgId").equals("가전/컴퓨터"))
			ctgId=8;
		
	
		return new ReserveRequest(
				req.getParameter("name"),
				req.getParameter("picture"),
				user.getId(),
				req.getParameter("productName"),
				Integer.parseInt(req.getParameter("lowPrice")),
				ctgId,
				req.getParameter("date"),
				req.getParameter("time"));
	}
	

}
