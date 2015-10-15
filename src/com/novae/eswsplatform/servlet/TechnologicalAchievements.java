package com.novae.eswsplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.bean.AchConvertBean;
import com.novae.eswsplatform.bean.TreatiseBean;

/**
 * Servlet implementation class TechnologicalAchievements
 */
@WebServlet("/TechnologicalAchievements")
public class TechnologicalAchievements extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.DeclarerService declarerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TechnologicalAchievements() {
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
		String details = request.getParameter("details");
		AchConvertBean achConvertBean = new AchConvertBean(declarerId, details);
		ArrayList<AchConvertBean> ab = new ArrayList<AchConvertBean>();
		ab.add(achConvertBean);
		declarerService.saveAchConvert(ab, declarerId);
		response.sendRedirect("TechnologicalAchievements.jsp");
	}

}
