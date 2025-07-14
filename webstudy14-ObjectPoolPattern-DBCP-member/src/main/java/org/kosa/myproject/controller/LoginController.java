package org.kosa.myproject.controller;

import org.kosa.myproject.model.MemberDao;
import org.kosa.myproject.model.MemberVo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVo vo=MemberDao.getInstance().login(id, password);
		String path=null;
		if(vo!=null) {
			HttpSession session = request.getSession();// 기존 세션없으면 새로 생성, 있으면 기존 리턴
			// 세션에 인증정보(회원 객체)를 저장한다
			session.setAttribute("mvo", vo);
			path="redirect: login-ok.jsp";
		}else {
			path = "redirect: login-fail.jsp";
		}
		return path;
	}
}
