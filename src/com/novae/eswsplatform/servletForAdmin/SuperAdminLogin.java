package com.novae.eswsplatform.servletForAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/SuperAdminLogin")
public class SuperAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.LoginService loginService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuperAdminLogin() {
		super();
		this.loginService = new com.novae.eswsplatform.service.LoginServiceImp();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String account = request.getParameter("username");
		String psw = request.getParameter("password");
		if(account.equals("admin")&&psw.equals("admin")) {
			Cookie accountCookie = new Cookie("account", account);
			Cookie pswCookie = new Cookie("psw", psw);
			accountCookie.setPath(request.getContextPath());
			pswCookie.setPath(request.getContextPath());
			response.addCookie(accountCookie);
			response.addCookie(pswCookie);
			response.sendRedirect("SuperAdminstrator/SuperAdminIndex.jsp");
		} else {
			response.sendRedirect("SuperAdminstrator/SuperAdminLogin.jsp");
		}
		// TODO Auto-generated method stub
	}
}
