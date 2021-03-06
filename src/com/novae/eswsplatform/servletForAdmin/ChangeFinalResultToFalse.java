package com.novae.eswsplatform.servletForAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.service.AdminServiceImp;

/**
 * Servlet implementation class ChangePreResult
 */
@WebServlet("/ChangeFinalResultToFalse")
public class ChangeFinalResultToFalse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private com.novae.eswsplatform.service.AdminService adminService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeFinalResultToFalse() {
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
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int ID = Integer.parseInt(request.getParameter("ID"));
		System.out.println("请求修改"+ID);
		adminService.changeFinalResult(ID,false);
		response.sendRedirect("SuperAdminstrator/CandidatesFinalResultsManagement.jsp");
	}

}
