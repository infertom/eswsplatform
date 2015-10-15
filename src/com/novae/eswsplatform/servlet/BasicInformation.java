package com.novae.eswsplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novae.eswsplatform.bean.AcademicBean;
import com.novae.eswsplatform.bean.DeclarerBean;
import com.novae.eswsplatform.bean.GroupBean;
import com.novae.eswsplatform.bean.ResumeBean;
import com.novae.eswsplatform.bean.SocialJobBean;
import com.novae.eswsplatform.bean.SubjectBean;
import com.novae.eswsplatform.service.AdminServiceImp;

/**
 * Servlet implementation class Basicinformation
 */
@WebServlet("/BasicInformation")
public class BasicInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private com.novae.eswsplatform.service.DeclarerService declarerService;
	private com.novae.eswsplatform.bean.DeclarerBean declarerBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BasicInformation() {
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
		response.setHeader("content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		int ID = Integer.parseInt(request.getParameter("ID"));
		this.declarerBean = declarerService.getBasicInform(ID);
		String idNum = request.getParameter("idNum");
		declarerBean.setIdNum(idNum);
		String name = request.getParameter("name");
		declarerBean.setName(name);
		String sex = request.getParameter("sex");
		if (sex.equals("男")) {
			declarerBean.setSex(true);
		} else {
			declarerBean.setSex(false);
		}
		String nation = request.getParameter("nation");
		declarerBean.setNation(nation);
		String eduBg = request.getParameter("eduBg");
		declarerBean.setEduBg(eduBg);
		String degree = request.getParameterValues("degree")[0];
		declarerBean.setDegree(degree);
		String party = request.getParameter("party");
		declarerBean.setParty(party);
		String birthDay = request.getParameter("birthDay");
		declarerBean.setBirthDay(birthDay);
		String birthPlace = request.getParameter("birthPlace");
		declarerBean.setBirthPlace(birthPlace);
		int subject = Integer
				.parseInt(request.getParameterValues("subject")[0]);
		declarerBean.setSubject(subject);
		com.novae.eswsplatform.service.AdminService adminService = new AdminServiceImp();
		SubjectBean subjectBean = adminService.getSubjectById(subject);
		for (GroupBean groupBean : adminService.getGroups()) {
			if (groupBean.getId() == subjectBean.getGroupId()) {
				declarerBean.setGroupId(groupBean.getId());
				System.out.println("学科组是"+groupBean.getId());
			}
		}
		String addrWork = request.getParameter("addrWork");
		declarerBean.setAddrWork(addrWork);
		String postcode = request.getParameter("postcode");
		declarerBean.setPostcode(postcode);
		String proJob = request.getParameter("proJob");
		declarerBean.setProJob(proJob);
		String exeJob = request.getParameter("exeJob");
		declarerBean.setExeJob(exeJob);
		String telPerNum = request.getParameter("telPerNum");
		declarerBean.setTelPerNum(telPerNum);
		String telWorkNum = request.getParameter("telWorkNum");
		declarerBean.setTelWorkNum(telWorkNum);
		String EMail = request.getParameter("EMail");
		declarerBean.setEMail(EMail);
		String telHomeNum = request.getParameter("telHomeNum");
		declarerBean.setTelHomeNum(telHomeNum);
		String unitName = request.getParameter("unitName");
		declarerBean.setUnitName(unitName);
		String addrHome = request.getParameter("addrHome");
		declarerBean.setAddrHome(addrHome);
		String postcodeHome = request.getParameter("postcodeHome");
		declarerBean.setPostcodeHome(postcodeHome);
		declarerService.saveBasicInform(declarerBean, ID);

		String job = request.getParameter("job");
		SocialJobBean socialJobBean = new SocialJobBean(declarerBean.getId(),
				job);
		ArrayList<SocialJobBean> cb = new ArrayList<SocialJobBean>();
		cb.add(socialJobBean);
		declarerService.saveSocialJob(cb, declarerBean.getId());

		String academicJob = request.getParameter("academicjob");
		AcademicBean academicBean = new AcademicBean(declarerBean.getId(),
				academicJob);
		ArrayList<AcademicBean> ab = new ArrayList<AcademicBean>();
		ab.add(academicBean);
		declarerService.saveAcademicJob(ab, declarerBean.getId());

		ArrayList<ResumeBean> rb = new ArrayList<ResumeBean>();
		for (int i = 0; i < 99; i++) {
			try {
				String timeFrom = request.getParameter("timeFrom" + i);
				String timeTo = request.getParameter("timeTo" + i);
				String details = request.getParameter("details" + i);
				if (timeFrom != null && timeTo != null && details != null) {
					ResumeBean resumeBean = new ResumeBean(
							declarerBean.getId(), timeFrom, timeTo, details);
					rb.add(resumeBean);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		declarerService.saveResume(rb, declarerBean.getId());

		response.sendRedirect("BasicInformation.jsp");
		// TODO Auto-generated method stub
	}

}
