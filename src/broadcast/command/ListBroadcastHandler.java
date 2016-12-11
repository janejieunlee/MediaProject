package broadcast.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import broadcast.service.BroadcastPage;
import broadcast.service.ListBroadcastService;
import mvc.command.CommandHandler;

public class ListBroadcastHandler implements CommandHandler {
	
	private ListBroadcastService listService = new ListBroadcastService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String pageNoVal = req.getParameter("pageNo");
		String ctgId = req.getParameter("ctgId");
		String ctgName = "";
		int ctgId2 = 0;
		ctgId2 = Integer.parseInt(ctgId);
		
		
		System.out.println("ListHandler ctgId -> " + ctgId);
		int pageNo = 1;
		if(pageNoVal != null){
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		if(ctgId2==1){ctgName="패션의류";}
		else if(ctgId2==2){ctgName="잡화/명품";}
		else if(ctgId2==3){ctgName="화장품";}
		else if(ctgId2==4){ctgName="유아동/문화";}
		else if(ctgId2==5){ctgName="스포츠/여행";}
		else if(ctgId2==6){ctgName="식품/주방";}
		else if(ctgId2==7){ctgName="가구/생활";}
		else if(ctgId2==8){ctgName="가전/컴퓨터";}
		
		BroadcastPage broadcastPage = listService.getBroadcastPage(pageNo,ctgId2);
		req.setAttribute("broadcastPage", broadcastPage);
		req.setAttribute("ctgName", ctgName);
		return "/WEB-INF/view/listBroadcast.jsp";
	}
}
