package deal.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.bean.LogonDBBean;

public class ConfirmIdAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	// TODO Auto-generated method stub
	
	request.setCharacterEncoding("utf-8") ;
	
	String id = request.getParameter("id") ;
	System.out.println(id);
	
	LogonDBBean manager = LogonDBBean.getInstance() ;
	int check = manager.confirmId(id) ;
	
	System.out.println(check);
	request.setAttribute("check", check);
	//System.out.println(check); 
	return "/loginPro.jsp";
	
	}

}
