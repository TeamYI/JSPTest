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
		
		// DBBeam에서 id,pw 있는 지 확인하고 로그인시켜줌
		LogonDBBean member = LogonDBBean.getInstance();
		
		int check = member.userCheck(id,pw) ;
		
		String command = request.getParameter("command") ;
		
		// 로그아웃시키면 session에 저장된 값이 다 사라짐
		if(command != null && command.equals("logout")){
			session.invalidate();
			return "/loginForm.jsp" ;
		}
		if(id == null || pw == null)
			return "/loginForm.jsp" ;
		if(id.equals("admin") && pw.equals("admin")){
			// 관리자 로그인
			session.setAttribute("id", id);
			return "/adminIndex.jsp" ;
		}if(check == 1){
			// 일반회원 로그인
			session.setAttribute("id", id);
			String view = "/memberIndex.jsp" ;
			request.setAttribute("view", view);
			return "/memberIndex.jsp"; 
		}
		else{
			// id값이 맞지 않으면 notMatch
			session.removeAttribute("id");
			request.setAttribute("error", "notMatch");
			return "/loginForm.jsp" ;
		}
		
	

	}
	

}
