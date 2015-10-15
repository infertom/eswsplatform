package com.novae.eswsplatform.servletForAdmin;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeChange1
 */
@WebServlet("/TimeChange")
public class TimeChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.AdminService adminService;
	private com.novae.eswsplatform.bean.SystemTimeBean tempSystemTimeBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimeChange() {
		super();
		this.adminService = new com.novae.eswsplatform.service.AdminServiceImp();
		this.tempSystemTimeBean = new com.novae.eswsplatform.bean.SystemTimeBean();
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
		int role = Integer.parseInt(request.getParameter("role"));

		long time = 0;
		StringBuffer stringBuffer;
		stringBuffer = new StringBuffer();
		stringBuffer.append(request.getParameter("startYear"));
		stringBuffer.append(request.getParameter("startMonth"));
		stringBuffer.append(request.getParameter("startDay"));
		stringBuffer.append(request.getParameter("startHour"));
		stringBuffer.append(request.getParameter("startMinute"));
		stringBuffer.append(request.getParameter("startSecond"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"YYYYMMDDhhmmss");
		try {
			time = simpleDateFormat.parse(stringBuffer.toString()).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp openTime = new Timestamp(time);

		stringBuffer = new StringBuffer();
		stringBuffer.append(request.getParameter("endYear"));
		stringBuffer.append(request.getParameter("endMonth"));
		stringBuffer.append(request.getParameter("endDay"));
		stringBuffer.append(request.getParameter("endHour"));
		stringBuffer.append(request.getParameter("endMinute"));
		stringBuffer.append(request.getParameter("endSecond"));
		try {
			time = simpleDateFormat.parse(stringBuffer.toString()).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp endTime = new Timestamp(time);

		System.out.println(openTime);
		System.out.println(endTime);
		this.tempSystemTimeBean.setOpenTime(openTime);
		this.tempSystemTimeBean.setCloseTime(endTime);
		this.tempSystemTimeBean.setId(role);

		this.adminService.changeTime(role, this.tempSystemTimeBean);
	}

}
