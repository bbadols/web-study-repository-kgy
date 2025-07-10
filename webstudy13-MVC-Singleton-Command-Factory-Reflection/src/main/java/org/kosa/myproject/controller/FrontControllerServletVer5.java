package org.kosa.myproject.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import org.kosa.myproject.test1.RedirectUnitTest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Ver 5 : MVC + Singleton + Front Controller + Command + Factory Design Pattern
 */
@WebServlet("/FrontControllerServletVer5")
public class FrontControllerServletVer5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 공통 작업
			// client 요청 분석
			String command = request.getParameter("command");
			// 컨트롤러 객체 생성을 전담하는 Factory 객체인 HandlerMapping을 이용해
			// 적절한 컨트롤러를 반환받는다
			Controller controller = HandlerMapping.getInstance().create(command);
			String path = controller.handleRequest(request, response);
			/* Controller 영역에서 View로 제어를 이동하는 방식 : Forward, Redirect
			   forward 이동 방식 : 기존 request와 response가 유지되면서 이동하는 방식
								 웹 컨테이너 상에서 이동하여 응답되는 방식, 정보 조회용도 request에 공유해서
								 request 되면 request와 response는 소멸한다.
			 					 웹 어플리케이션 상에서 객체를 사용할 수 있는 범위
								 웹 어플리케이션 상에서 공유 객체 범위 : request < session < application
			 특징 : 기존 request가 유지되므로 새로고침시 재동작되는 특성 -> 등록 등 재동작되면 안되는 업무는 적합X
			 */
			if(path.trim().startsWith("redirect:")) {
				response.sendRedirect(path.trim().substring(9));
			}else {
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp"); // Front 에서 예외 처리 공통 정책을 실행 
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 하위 버전에서는 POST 방식일 경우 별도의 한글처리가 필요
		request.setCharacterEncoding("UTF-8");
		this.doDispatch(request, response);
	}
}
