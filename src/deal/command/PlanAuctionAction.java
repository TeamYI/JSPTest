package deal.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlanAuctionAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		String	view	=	"/planAuction.jsp";
		request.setAttribute("view", view);

		return "/adminIndex.jsp";
	}

}
