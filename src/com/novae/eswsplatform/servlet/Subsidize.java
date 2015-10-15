package com.novae.eswsplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.bean.AwardBean;
import com.novae.eswsplatform.bean.SubsidizeBean;

/**
 * Servlet implementation class Subsidize
 */
@WebServlet("/Subsidize")
public class Subsidize extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.DeclarerService declarerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Subsidize() {
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
		//response.sendRedirect("Subsidize.jsp");
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
		ArrayList<SubsidizeBean> sb = new ArrayList<SubsidizeBean>();
		int declarerId = Integer.parseInt(request.getParameter("declarerID"));
		for (int i = 0; i < 99; i++) {
			try {
				String name = request.getParameter("name" + i);
				int ranking = Integer.parseInt(request.getParameter("ranking"
						+ i));
				String date = request.getParameter("date" + i);
				String terms = request.getParameter("terms" + i);
				String detailsProj = request.getParameter("detailsProj" + i);
				SubsidizeBean subsidizeBean = new SubsidizeBean(declarerId,
						name, ranking, date, terms, detailsProj);
				sb.add(subsidizeBean);
				System.out.println(name);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		declarerService.saveSubsidize(sb, declarerId);
	}

}
