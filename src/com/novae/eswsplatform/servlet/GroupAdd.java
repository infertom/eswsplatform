package com.novae.eswsplatform.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.service.AdminServiceImp;

/**
 * Servlet implementation class GroupApply
 */
@WebServlet("/GroupAdd")
public class GroupAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private com.novae.eswsplatform.service.AdminService adminService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupAdd() {
        super();
        adminService = new com.novae.eswsplatform.service.AdminServiceImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int quota = Integer.parseInt(request.getParameter("quota"));
		com.novae.eswsplatform.bean.GroupBean groupBean = new com.novae.eswsplatform.bean.GroupBean(name, quota, false);
		adminService.addGroup(groupBean);
		response.sendRedirect("SuperAdminstrator/GroupAdd.jsp");
	}

}
