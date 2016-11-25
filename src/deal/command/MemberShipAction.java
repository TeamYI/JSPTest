package deal.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.bean.LogonDBBean;
import deal.bean.LogonDataBean;

public class MemberShipAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	// TODO Auto-generated method stub
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw") ;
		
		System.out.println(id) ;
		System.out.println(pw) ;
		
		if(id == null || pw == null){
			return "/membershipForm.jsp" ;
		}else{
		
			LogonDataBean member =new LogonDataBean();
			
			member.setId(id) ;
			member.setPasswd(pw) ;
			
			LogonDBBean dbPro = LogonDBBean.getInstance() ;
			dbPro.insertUser(member);
		
			return "/main.jsp";
		}
		
		
	}

}
