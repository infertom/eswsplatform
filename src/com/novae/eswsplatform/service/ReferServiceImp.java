package com.novae.eswsplatform.service;

import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.*;
import com.novae.eswsplatform.dao.*;

public class ReferServiceImp implements ReferService {
	ReferBeanDAO dao = new ReferBeanDAO();
	ReferBean bean;

	@Override
	public Boolean isSubmit(int ID) {
		bean = dao.findById(ID);
		return bean.getSubmit();
	}

	/**获取当前推荐单位的所有申报者
	 * 在推荐单位页面显示所有申报者时调用
	 * @param referID 推荐单位ID
	 * @return 指定推荐单位下所有已提交的申报者
	 */
	@Override
	public List<DeclarerBean> getDeclarers(int referID) {
		DeclarerBeanDAO declarerBeanDAO = new DeclarerBeanDAO();
		List a = declarerBeanDAO.findByRefer(referID);
		return (List<DeclarerBean>)a;
	}

	/**获取指定ID的申报者基本信息
	 * 点击详情是调用
	 * @param ID 申报者ID
	 * @return 指定申报者的基本信息
	 */
	@Override
	public DeclarerBean getDeclarerBean(int ID) {
		DeclarerBeanDAO declarerBeanDAO = new DeclarerBeanDAO();
		DeclarerBean declarerBean = declarerBeanDAO.findById(ID);
		return declarerBean;
	}

	/**获取该推荐单位的推荐名额
	 * 显示页面时需要调用
	 * @return 指定推荐单位的名额
	 */
	@Override
	public int getQuota(int ID) {
		bean = dao.findById(ID);
		return bean.getQuota();
	}

	/**提交
	 * 选择申报者后点击提交需要调用的方法
	 * @param declarersID 所有打了勾的申报者的ID
	 */
	@Override
	public void submit(ArrayList<Integer> declarersID, int referId) {
		DeclarerBeanDAO declarerBeanDAO = new DeclarerBeanDAO();
		for (Integer i: declarersID){
			DeclarerBean declarerBean = declarerBeanDAO.findById(i);
			declarerBean.setReferRes(true);
			declarerBeanDAO.attachDirty(declarerBean);
		}
		bean = dao.findById(referId);
		bean.setSubmit(true);
		dao.attachDirty(bean);
	}

}
