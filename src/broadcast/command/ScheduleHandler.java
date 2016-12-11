package broadcast.command;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;

import broadcast.service.BroadcastPage;
import broadcast.service.ListBroadcastService;
import mvc.command.CommandHandler;

public class ScheduleHandler implements CommandHandler {
	private ListBroadcastService listService = new ListBroadcastService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String today = req.getParameter("date");
		String pageNoVal = req.getParameter("pageNo");

		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date picked = null;
		String tomorrow = "";

		if (today != null) {
			picked = formatter.parse(today);
			Calendar cal = Calendar.getInstance();
			cal.setTime(picked);
			cal.add(Calendar.DATE, 1);
			tomorrow = formatter.format(cal.getTime());
		} else {
			Date today2 = new Date();
			Date tomorrow2 = new Date(today2.getTime() + (long) (1000 * 60 * 60 * 24));
			today = formatter.format(today2);
			tomorrow = formatter.format(tomorrow2);
		}

		BroadcastPage broadcastPage = listService.getSchedulePage(pageNo, today, tomorrow);
		req.setAttribute("broadcastPage", broadcastPage);

		return "/WEB-INF/view/schedule.jsp";
	}
}
