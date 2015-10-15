package com.novae.eswsplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.bean.ProjectBean;

/**
 * Servlet implementation class Project
 */
@WebServlet("/Project")
public class Project extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.DeclarerService declarerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Project() {
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
		ArrayList<ProjectBean> pb = new ArrayList<ProjectBean>();
		int declarerId = Integer.parseInt(request.getParameter("declarerID"));
		for (int i = 0; i < 99; i++) {
			try {
				String name = request.getParameter("name" + i);
				String unit = request.getParameter("unit" + i);
				String details = request.getParameter("details" + i);
				int benefit = Integer.parseInt(request
						.getParameter("benefit" + i));
				ProjectBean projectBean = new ProjectBean(declarerId, name,
						unit, details, benefit);
				pb.add(projectBean);
				System.out.println(name);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		declarerService.saveProject(pb, declarerId);

		response.sendRedirect("Project.jsp");
	}

}
