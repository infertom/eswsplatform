package com.novae.eswsplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExpertVote
 */
@WebServlet("/ExpertVote")
public class ExpertVote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.CommitteeService committeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExpertVote() {
		super();
		committeeService = new com.novae.eswsplatform.service.CommitteeServiceImp();
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
		
		int role = Integer.parseInt(request.getParameter("role"));
		if (role==0){
			String[] allSelctStrings = request.getParameterValues("select");
			int expertID = Integer.parseInt(request.getParameter("expertID"));
			ArrayList<Integer> declarers = new ArrayList<Integer>();
			for (int i = 0; i < allSelctStrings.length; i++) {
				declarers.add(Integer.parseInt(allSelctStrings[i]));
			}
			committeeService.submitToGroup(declarers, expertID);
		} else if (role==1) {
			String[] allSelctStrings = request.getParameterValues("select");
			int expertID = Integer.parseInt(request.getParameter("expertID"));
			ArrayList<Integer> declarers = new ArrayList<Integer>();
			for (int i = 0; i < allSelctStrings.length; i++) {
				declarers.add(Integer.parseInt(allSelctStrings[i]));
			}
			committeeService.submitToCommittee(declarers, expertID);
		}
		
		response.sendRedirect("ExpertIndex.jsp");
		// TODO Auto-generated method stub
	}

}
