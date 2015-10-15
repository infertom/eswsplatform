package com.novae.eswsplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.bean.AwardBean;

/**
 * Servlet implementation class Award
 */
@WebServlet("/Award")
public class Award extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private com.novae.eswsplatform.service.DeclarerService declarerService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Award() {
        super();
        declarerService = new com.novae.eswsplatform.service.DeclarerServiceImp();
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
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<AwardBean> ab = new ArrayList<AwardBean>();
		int declarerId = Integer.parseInt(request.getParameter("declarerID"));
		for (int i=0 ; i<99 ; i++) {
			try {
				String name = request.getParameter("name"+i);
				String unit = request.getParameter("unit"+i);
				String date = request.getParameter("date"+i);
				int total = Integer.parseInt(request.getParameter("total"+i));
				int ranking = Integer.parseInt(request.getParameter("ranking"+i));
				AwardBean awardBean = new AwardBean(declarerId, name, unit, date, total, ranking);
				ab.add(awardBean);
				System.out.println(name);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		declarerService.saveAward(ab,declarerId);
		
		response.sendRedirect("Award.jsp");
	}

}
