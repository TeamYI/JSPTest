package deal.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.bean.LogonDBBean;
import deal.bean.LogonDataBean;

public class UsersViewAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String	view	=	"/usersView.jsp";
		request.setAttribute("view", view);
		
		ArrayList<LogonDataBean>	list;
		LogonDBBean	users	=	LogonDBBean.getInstance();
		list				=	users.usersView();
		request.setAttribute("users", list);
		
		
		
		return	"/adminIndex.jsp";
	}
}
