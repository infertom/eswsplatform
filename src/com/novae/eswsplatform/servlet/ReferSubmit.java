package com.novae.eswsplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.bean.ReferBean;

/**
 * Servlet implementation class ReferSubmit
 */
@WebServlet("/ReferSubmit")
public class ReferSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private com.novae.eswsplatform.service.ReferService referService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReferSubmit() {
        super();
        referService = new com.novae.eswsplatform.service.ReferServiceImp();
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
		int referId = Integer.parseInt(request.getParameter("referid"));
		String[] selectStrings = request.getParameterValues("select");
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		for (int i = 0; i < selectStrings.length; i++) {
			IDs.add(Integer.parseInt(selectStrings[i]));
		}
		referService.submit(IDs, referId);
		response.sendRedirect("ReferIndex.jsp");
	}

}
