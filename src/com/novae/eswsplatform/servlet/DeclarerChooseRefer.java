package com.novae.eswsplatform.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeclarerChooseRefer
 */
@WebServlet("/DeclarerChooseRefer")
public class DeclarerChooseRefer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.DeclarerService declarerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeclarerChooseRefer() {
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
		// TODO Auto-generated method stub
		int declarerId = Integer.parseInt(request.getParameter("declarerId"));
		int refer = Integer.parseInt(request.getParameterValues("refer")[0]);
		declarerService.declarerChooseRefer(declarerId, refer);
		response.sendRedirect("Success.html");
	}

}
