package deal.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuctionAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8"); 
		
		String	view	=	"/auction.jsp";
		request.setAttribute("view", view);
		
		return "/adminIndex.jsp";
	}

}
