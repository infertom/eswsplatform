package com.novae.eswsplatform.servletForAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommitteeQoutaReset
 */
@WebServlet("/CommitteeQoutaReset")
public class CommitteeQoutaReset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.AdminService adminService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommitteeQoutaReset() {
		super();
		adminService = new com.novae.eswsplatform.service.AdminServiceImp();
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
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int ID = Integer.parseInt(request.getParameter("ID"));
		adminService.returnGroupResult(ID);
		response.sendRedirect("SuperAdminstrator/GroupVotaManagement.jsp");
	}

}
