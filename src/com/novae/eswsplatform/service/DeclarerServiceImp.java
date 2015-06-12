package com.novae.eswsplatform.service;

import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.*;
import com.novae.eswsplatform.dao.*;

public class DeclarerServiceImp implements DeclarerService {
	DeclarerBeanDAO dao = new DeclarerBeanDAO();
	DeclarerBean bean;
	
	/*****?*****/
	/**�ж��û����Ƿ��Ѿ���ռ��
	 * @param account ��Ҫ�жϵ��û���
	 * @return true���ѱ�ռ�� false��δ��ռ��
	 */
	@Override
	public Boolean declarerAccountIsUsed(String account) {
		Boolean ans = false;
		
		List a = dao.findByAccount(account);
		if ( a.isEmpty() ) ans = true;
		else ans = false;
		
		return ans;
	}

	/**�걨��ע��
	 * @param account �µ��˻�
	 * @param psw ����
	 */
	@Override
	public void declarerRegister(String account, String psw) {
		bean = new DeclarerBean();
		bean.setAccount(account);
		bean.setPassword(psw);
		dao.save(bean);
	}

	/**�жϸ��걨���Ƿ����ύ�걨��Ϣ
	 * �걨�߲����ظ����ύ
	 * @param ID �걨��ID
	 * @return true�����ύ����Ϣ false:δ�ύ
	 */
	@Override
	public boolean isSubmit(int ID) {
		Boolean ans = false;
		bean = dao.findById(ID);
		
		ans = bean.getSubmit();
		
		return ans;
	}

	/**��ȡ����Ϣ
	 * ��ע��ҳ������Ҫ��ʾ�걨�������Ļ���Ϣ
	 * @param ID �걨��ID
	 * @return ָ���걨�ߵĻ���Ϣ
	 */
	@Override
	public DeclarerBean getBasicInform(int ID) {
		bean = dao.findById(ID);
		
		return bean;
	}

	/**�������Ϣ
	 * ����Ϣ�������ʱ��Ҫ���õķ���
	 * @param db �޸ĺ����Ϣ
	 * @param ID �걨��ID
	 */
	@Override
	public void saveBasicInform(DeclarerBean db, int ID) {
		DeclarerBeanDAO declarerBeanDAO = new DeclarerBeanDAO();
		DeclarerBean declarerBean = declarerBeanDAO.findById(ID);
		dao.attachDirty(db);
	}

	/**��ȡ���Ƽ�����������ƺ����
	 * ��ע��ҳ������Ҫ��ʾ�걨�������Ľ���ͳƺ����
	 * @param ID �걨��ID
	 * @return ָ���걨���������Ƽ�����������ƺ����
	 */
	@Override
	public List<AwardBean> getAward(int ID) {
		AwardBeanDAO awardBeanDAO = new AwardBeanDAO();
		List a = awardBeanDAO.findByDeclarerId(ID);
		return (List<AwardBean>)a;
	}

	/**�������Ƽ�����������ƺ����
	 * ����ͳƺŵ������ʱ��Ҫ���õķ���
	 * @param db
	 */
	@Override
	public void saveAward(ArrayList<AwardBean> ab) {
		AwardBeanDAO awardBeanDAO = new AwardBeanDAO();
		for (AwardBean awardBean:ab ){
			awardBeanDAO.save(awardBean);
		}
	}

	// ��ȡ�������ĺ�ר�����
	@Override
	public List<TreatiseBean> getTreatise(int ID) {
		TreatiseBeanDAO treatiseBeanDAO = new TreatiseBeanDAO();
		List a = treatiseBeanDAO.findByDeclarerId(ID);
		return (List<TreatiseBean>)a;
	}

	// ���淢�����ĺ�ר�����
	@Override
	public void saveTreatise(ArrayList<TreatiseBean> tb) {
		TreatiseBeanDAO treatiseBeanDAO = new TreatiseBeanDAO();
		for ( TreatiseBean treatiseBean: tb ){
			treatiseBeanDAO.save(treatiseBean);
		}
	}

	// ��ȡ�����������
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

	// ��ȡ�����ش󹤳̼�����Ŀ���
	@Override
	public List<ProjectBean> getProject(int ID) {
		ProjectBeanDAO projectBeanDAO = new ProjectBeanDAO();
		return projectBeanDAO.findByDeclarerId(ID);
	}

	// ��������ش󹤳̼�����Ŀ���
	@Override
	public void saveProject(ArrayList<ProjectBean> pb) {
		ProjectBeanDAO projectBeanDAO = new ProjectBeanDAO();
		for ( ProjectBean projectBean: pb ){
			projectBeanDAO.save(projectBean);
		}

	}

	// ��ȡ�Ƽ��ɹ�ת�������պͿƼ��������
	@Override
	public List<AchConvertBean> getAchConvert(int ID) {
		AchConvertBeanDAO achConvertBeanDAO = new AchConvertBeanDAO();
		return achConvertBeanDAO.findByDeclarerId(ID);
	}

	 // ����Ƽ��ɹ�ת�������պͿƼ��������
	@Override
	public void saveAchConvert(ArrayList<AchConvertBean> cb) {
		AchConvertBeanDAO achConvertBeanDAO = new AchConvertBeanDAO();
		for ( AchConvertBean achConvertBean: cb ){
			achConvertBeanDAO.save(achConvertBean);
		}

	}

	// ��ȡ�ۺ��Ƽ�����
	@Override
	public String getReferReason(int ID) {
		bean = dao.findById(ID);
		return bean.getReferReason();
	}

	// �����ۺ��Ƽ�����
	@Override
	public void saveReferReason(String test, int ID) {
		bean = dao.findById(ID);
		bean.setReferReason(test);
		dao.attachClean(bean);
	}

	/**�ύ
	 * ������ʱ��Ҫ���õķ���
	 * @param ID �걨��ID
	 */
	@Override
	public void submit(int ID) {
		bean = dao.findById(ID);
		bean.setSubmit(true);
		dao.attachDirty(bean);
	}

}
