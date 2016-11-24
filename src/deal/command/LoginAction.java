package deal.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import deal.bean.LogonDBBean;

public class LoginAction implements CommandAction {
	

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id") ;
		String pw = request.getParameter("pw") ;
		HttpSession session = request.getSession();
		
		LogonDBBean member = LogonDBBean.getInstance();
		
		int check = member.userCheck(id,pw) ;
		
		
		String command = request.getParameter("command") ;
		if(command != null && command.equals("logout")){
			session.invalidate();
			return "/loginForm.jsp" ;
		}
		if(id == null || pw == null)
			return "/loginForm.jsp" ;
		if(id.equals("admin") && pw.equals("admin")){
			session.setAttribute("id", id);
			return "/adminIndex.jsp" ;
		}if(check == 1){
			session.setAttribute("id", id);
			request.setAttribute("check", check);
			System.out.println("sksskskskkjkjds");
			return "/memberIndex.jsp"; 
		}
		else{
			session.removeAttribute("id");
			request.setAttribute("error", "notMatch");
			return "/loginForm.jsp" ;
		}
		
	

	}
	

}
