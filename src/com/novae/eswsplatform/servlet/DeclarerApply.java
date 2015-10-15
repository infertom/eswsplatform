package com.novae.eswsplatform.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeclarerApply
 */
@WebServlet("/DeclarerApply")
public class DeclarerApply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.DeclarerService declarerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeclarerApply() {
		super();
		declarerService = new com.novae.eswsplatform.service.DeclarerServiceImp();
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
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		System.out.println("用户名:"+ username);
		String password = request.getParameter("password");
		System.out.println("密码读取成功");
		String name = request.getParameter("name"); 
		System.out.println("姓名:" + name);
		String sexString = request.getParameter("sex");
		System.out.println("性别读取成功");
		boolean sex;
		if (sexString.equals("男")){
			sex = true;
		} else {
			sex = false;
		}
		String birthDay = request.getParameter("birthDay");
		System.out.println("出生日期读取成功");
		String unitname = request.getParameter("unitname");
		System.out.println("工作单位读取成功");

		if (!declarerService.declarerAccountIsUsed(username)) {
			System.out.println("没有重名");
			declarerService.declarerRegister(username, password, name, sex, birthDay, unitname);
			System.out.println("注册成功");
			response.sendRedirect("Login.jsp");
		} else {

		}

		// TODO Auto-generated method stub
	}

}
