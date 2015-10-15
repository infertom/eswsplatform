package com.novae.eswsplatform.service.copy;

import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.*;
import com.novae.eswsplatform.dao.*;

public class DeclarerServiceImp implements DeclarerService {
	DeclarerBeanDAO dao = new DeclarerBeanDAO();
	DeclarerBeanDAO referBeanDAO = new DeclarerBeanDAO();
	DeclarerBean bean;
	
	/*****?*****/
	/**判断用户名是否已经被占用
	 * @param account 需要判断的用户名
	 * @return true：已被占用 false：未被占用
	 */
	@Override
	public Boolean declarerAccountIsUsed(String account) {
		Boolean ans = false;
		
		List a = dao.findByAccount(account);
		if ( a.isEmpty() ) ans = false;
		else ans = true;
		
		return ans;
	}

	/**申报者注册
	 * @param account 新的账户
	 * @param psw 密码
	 */
	@Override
	public void declarerRegister(String account, String psw, String name, boolean sex, String birthDay, String unitname) {
		bean = new DeclarerBean();
		bean.setAccount(account);
		bean.setPassword(psw);
		bean.setName(name);
		bean.setSex(sex);
		bean.setBirthDay(birthDay);
		bean.setUnitName(unitname);
		dao.save(bean);
	}

	/**判断该申报者是否已提交申报信息
	 * 申报者不能重复地提交
	 * @param ID 申报者ID
	 * @return true：已提交基本信息 false:未提交
	 */
	@Override
	public boolean isSubmit(int ID) {
		Boolean ans = false;
		bean = dao.findById(ID);
		
		ans = bean.getSubmit();
		
		return ans;
	}

	/**获取基本信息
	 * 在注册页面中需要显示申报者曾经保存过的基本信息
	 * @param ID 申报者ID
	 * @return 指定申报者的基本信息
	 */
	@Override
	public DeclarerBean getBasicInform(int ID) {
		bean = dao.findById(ID);
		
		return bean;
	}

	/**保存基本信息
	 * 基本信息点击保存时需要调用的方法
	 * @param db 修改后的信息
	 * @param ID 申报者ID
	 */
	@Override
	public void saveBasicInform(DeclarerBean db, int ID) {
		DeclarerBeanDAO declarerBeanDAO = new DeclarerBeanDAO();
		DeclarerBean declarerBean = declarerBeanDAO.findById(ID);
		dao.attachDirty(db);
	}
	/**获取所获科技奖励和荣誉称号情况
	 * 在注册页面中需要显示申报者曾经保存过的奖励和称号情况
	 * @param ID 申报者ID
	 * @return 指定申报者所有所获科技奖励和荣誉称号情况
	 */
	@Override
	public List<AwardBean> getAward(int ID) {
		AwardBeanDAO awardBeanDAO = new AwardBeanDAO();
		List a = awardBeanDAO.findByDeclarerId(ID);
		return (List<AwardBean>)a;
	}

	/**保存所获科技奖励和荣誉称号情况
	 * 奖励和称号点击保存时需要调用的方法
	 * @param db
	 */
	@Override
	public void saveAward(ArrayList<AwardBean> ab) {
		AwardBeanDAO awardBeanDAO = new AwardBeanDAO();
		for (AwardBean awardBean:ab ){
			awardBeanDAO.save(awardBean);
		}
	}

	
	@Override
	public List<TreatiseBean> getTreatise(int ID) {
		TreatiseBeanDAO treatiseBeanDAO = new TreatiseBeanDAO();
		List a = treatiseBeanDAO.findByDeclarerId(ID);
		return (List<TreatiseBean>)a;
	}

	
	@Override
	public void saveTreatise(ArrayList<TreatiseBean> tb) {
		TreatiseBeanDAO treatiseBeanDAO = new TreatiseBeanDAO();
		for ( TreatiseBean treatiseBean: tb ){
			treatiseBeanDAO.save(treatiseBean);
		}
	}

	
	@Override
	public List<SubsidizeBean> getSubsidize(int ID) {
		SubsidizeBeanDAO subsidizeBeanDAO = new SubsidizeBeanDAO();
		return (List<SubsidizeBean>)subsidizeBeanDAO.findByDeclarerId(ID);
	}

	@Override
	public void saveSubsidize(ArrayList<SubsidizeBean> sb) {
		SubsidizeBeanDAO subsidizeBeanDAO = new SubsidizeBeanDAO();
		for ( SubsidizeBean subsidizeBean: sb ){
			subsidizeBeanDAO.save(subsidizeBean);
		}
	}

	
	@Override
	public List<ProjectBean> getProject(int ID) {
		ProjectBeanDAO projectBeanDAO = new ProjectBeanDAO();
		return projectBeanDAO.findByDeclarerId(ID);
	}

	
	@Override
	public void saveProject(ArrayList<ProjectBean> pb) {
		ProjectBeanDAO projectBeanDAO = new ProjectBeanDAO();
		for ( ProjectBean projectBean: pb ){
			projectBeanDAO.save(projectBean);
		}

	}

	
	@Override
	public List<AchConvertBean> getAchConvert(int ID) {
		AchConvertBeanDAO achConvertBeanDAO = new AchConvertBeanDAO();
		return achConvertBeanDAO.findByDeclarerId(ID);
	}

	
	@Override
	public void saveAchConvert(ArrayList<AchConvertBean> cb) {
		AchConvertBeanDAO achConvertBeanDAO = new AchConvertBeanDAO();
		for ( AchConvertBean achConvertBean: cb ){
			achConvertBeanDAO.save(achConvertBean);
		}

	}

	
	@Override
	public String getReferReason(int ID) {
		bean = dao.findById(ID);
		return bean.getReferReason();
	}


	@Override
	public void saveReferReason(String test, int ID) {
		bean = dao.findById(ID);
		bean.setReferReason(test);
		dao.attachClean(bean);
	}
	/**获取推荐单位
	 * @return 所有的推荐单位
	 */
	public List<ReferBean> getRefers() {
		List<ReferBean> list = (List<ReferBean>)referBeanDAO.findAll();
		return list;
	}
	/**提交
	 * 点击提价时需要调用的方法
	 * @param ID 申报者ID
	 */
	@Override
	public void submit(int ID) {
		bean = dao.findById(ID);
		bean.setSubmit(true);
		dao.attachDirty(bean);
	}

}
