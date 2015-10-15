package com.novae.eswsplatform.servletForAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountApply
 */
@WebServlet("/AccountAssignment")
public class AccountAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.AdminService tempAdminService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountAssignment() {
		super();
		this.tempAdminService = new com.novae.eswsplatform.service.AdminServiceImp();
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

		int role = Integer.parseInt(request.getParameter("role"));
		String name = request.getParameter("realName");
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		switch (role) {
		case 1:
			int groupID = Integer.parseInt(request.getParameter("groupID"));
			System.out.println(groupID);
			com.novae.eswsplatform.bean.ExpertBean expertBean;
			expertBean = new com.novae.eswsplatform.bean.ExpertBean(account,
					name, password, 0, 0, false);
			expertBean.setSubGroup(groupID);
			tempAdminService.expertRegister(account, password, expertBean);
			response.sendRedirect("SuperAdminstrator/AccountAssignment.jsp");
			break;
		case 2:
			com.novae.eswsplatform.bean.ReferBean referBean;
			referBean = new com.novae.eswsplatform.bean.ReferBean(account,
					name, password, 0, 0, false);
			tempAdminService.referRegister(account, password, referBean);
			response.sendRedirect("SuperAdminstrator/AccountAssignment.jsp");
			break;
		default:
			response.sendError(500, "error");
		}
		// TODO Auto-generated method stub
	}

}
