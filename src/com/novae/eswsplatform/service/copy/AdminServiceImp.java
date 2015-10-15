package com.novae.eswsplatform.service.copy;

import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.DeclarerBean;
import com.novae.eswsplatform.bean.ExpertBean;
import com.novae.eswsplatform.bean.GroupBean;
import com.novae.eswsplatform.bean.ReferBean;
import com.novae.eswsplatform.bean.SystemTimeBean;
import com.novae.eswsplatform.dao.DeclarerBeanDAO;
import com.novae.eswsplatform.dao.ExpertBeanDAO;
import com.novae.eswsplatform.dao.GroupBeanDAO;
import com.novae.eswsplatform.dao.ReferBeanDAO;
import com.novae.eswsplatform.dao.SystemTimeBeanDAO;

public class AdminServiceImp implements AdminService {
	SystemTimeBeanDAO systemTimeBeanDAO = new SystemTimeBeanDAO();
	ReferBeanDAO referBeanDAO = new ReferBeanDAO();
	ExpertBeanDAO expertBeanDAO = new ExpertBeanDAO();
	DeclarerBeanDAO declarerBeanDAO = new DeclarerBeanDAO();
	GroupBeanDAO groupBeanDAO = new GroupBeanDAO();
	
	
	/**获取指定系统的开关时间
	 * @param role 角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @return 指定系统的系统开关时间
	 */
	@Override
	public SystemTimeBean getSystemTime(int role) {
		return systemTimeBeanDAO.findById(role);
	}

	/**更改指定系统时间
	 * @param role  角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @param time 修改后的时间
	 */
	@Override
	public void changeTime(int role, SystemTimeBean time) {
		SystemTimeBean systemTimeBean = systemTimeBeanDAO.findById(role);
		systemTimeBean.setCloseTime(time.getCloseTime());
		systemTimeBean.setOpenTime(time.getOpenTime());
		systemTimeBean.setId(role);
		systemTimeBeanDAO.attachDirty(systemTimeBean);
	}

	/**判断推荐单位账号是否被使用
	 * @param account 待判断的推荐单位账号
	 * @return true：账号被使用 false：账号未被使用
	 */
	@Override
	public Boolean referAccountIsUsed(String account) {
		Boolean flag = false;
		List<ReferBean> referBean = referBeanDAO.findByAccount(account);
		if ( referBean.isEmpty() ) flag = false;
		else flag = true;
		return flag;
	}

	/**判断评审专家账号是否被使用
	 * @param account 待判断的评审专家账号
	 * @return true：账号被使用 false：账号未被使用
	 */
	@Override
	public Boolean expertAccountIsUsed(String account) {
		Boolean flag = false;
		List<ExpertBean> expertBeans = referBeanDAO.findByAccount(account);
		if ( expertBeans.isEmpty() ) flag = false;
		else flag = true;
		return flag;
	}

	/**推荐单位注册
	 * @param account 新的账号
	 * @param psw 密码
	 * @param rb 新注册单位的基本信息
	 */
	@Override
	public void referRegister(String account, String psw, ReferBean rb) {
		rb.setAccount(account);
		rb.setPassword(psw);
		referBeanDAO.save(rb);
	}

	/**评审专家注册
	 * @param account 新的账号
	 * @param psw 密码
	 * @param eb 新注册专家的基本信息
	 */
	@Override
	public void expertRegister(String account, String psw, ExpertBean eb) {
		eb.setAccount(account);
		eb.setPassword(psw);
		expertBeanDAO.save(eb);
	}

	/**获取推荐单位
	 * @return 所有的推荐单位
	 */
	@Override
	public List<ReferBean> getRefers() {
		List<ReferBean> list = (List<ReferBean>)referBeanDAO.findAll();
		return list;
	}

	/**获取评审专家
	 * @return 所有的推荐专家
	 */
	@Override
	public List<ExpertBean> getExperts() {
		List<ExpertBean> list = (List<ExpertBean>)expertBeanDAO.findAll();
		return list;
	}

	/**获取当前推荐单位的所有申报者
	 * @param referID 推荐单位ID
	 * @return 指定推荐单位下的所有申报者
	 */
	@Override
	public List<DeclarerBean> getDeclarers(int referID) {
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		return list;
	}

	/**更改密码
	 * @param account 需要修改密码的账号
	 * @param role 需要修改密码的角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @param newPsw 新的密码
	 */
	@Override
	public void changePsw(String account, int role, String newPsw) {
		switch (role) {
		case 1:
			DeclarerBean declarerBean = (DeclarerBean)declarerBeanDAO.findByAccount(account).get(0);
			declarerBean.setPassword(newPsw);
			declarerBeanDAO.attachDirty(declarerBean);
			break;
		case 2:
			ReferBean referBean = (ReferBean)referBeanDAO.findByAccount(account).get(0);
			referBean.setPassword(newPsw);
			referBeanDAO.attachDirty(referBean);
			break;
		case 3:
			ExpertBean expertBean = (ExpertBean)expertBeanDAO.findByAccount(account).get(0);
			expertBean.setPassword(newPsw);
			expertBeanDAO.attachDirty(expertBean);
			break;
		default:
			break;
		}
	}

	/**删除账号
	 * @param account 需要删除的账号
	 * @param role 需要删除的账号的角色号（1-申报者，2-推荐专家，3-评审专家）
	 */
	@Override
	public void deleteAccount(String account, int role) {
		switch (role) {
		case 1:
			DeclarerBean declarerBean = (DeclarerBean)declarerBeanDAO.findByAccount(account).get(0);
			declarerBeanDAO.delete(declarerBean);
			break;
		case 2:
			ReferBean referBean = (ReferBean)referBeanDAO.findByAccount(account).get(0);
			referBeanDAO.delete(referBean);
			break;
		case 3:
			ExpertBean expertBean = (ExpertBean)expertBeanDAO.findByAccount(account).get(0);
			expertBeanDAO.delete(expertBean);
			break;
		default:
			break;
		}
	}

	/**增加科学组（学科组中有个莫名其妙的登陆账号）
	 * @param gb 需要增加的学科组的基本信息
	 */
	@Override
	public void addGroup(GroupBean gb) {
		groupBeanDAO.save(gb);
	}

	/**删除学科组
	 * @param ID 需要删除的学科组的ID
	 */
	@Override
	public void deleteGroup(int ID) {
		GroupBean groupBean = groupBeanDAO.findById(ID);
		groupBeanDAO.delete(groupBean);
	}

	/**修改学科组
	 * @param gb 修改后的学科组的基本信息
	 */
	@Override
	public void modifyGroup(GroupBean gb) {
		GroupBean groupBean = groupBeanDAO.findById(gb.getId());
		groupBean.setName(gb.getName());
		groupBean.setQuota(gb.getQuota());
		groupBean.setSubmit(gb.getSubmit());
		groupBeanDAO.attachDirty(groupBean);
	}

	/**获取所有申报者
	 * @return 所有申报者
	 */
	@Override
	public List<DeclarerBean> getDeclarers() {
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		return list;
	}

	/**指定申报者分配指定学科组
	 * @param CandidateID 申报者ID
	 * @param groupID 学科组ID
	 */
	@Override
	public void changeGroup(int CandidateID, int groupID) {
		DeclarerBean declarerBean = declarerBeanDAO.findById(CandidateID);
		declarerBean.setGroupId(groupID);
		declarerBeanDAO.attachDirty(declarerBean);
	}

	/**将指定申报者的初评结果改成result
	 * @param ID 申报者ID
	 * @param result 初评结果 true：通过 false：不通过
	 */
	@Override
	public void changePreResult(int ID, boolean result) {
		DeclarerBean declarerBean = declarerBeanDAO.findById(ID);
		declarerBean.setPreJugdeRes(result);
		declarerBeanDAO.attachDirty(declarerBean);
	}

	/**获取所有候选人（推荐单位通过的人）
	 * @return 所有候选人（推荐单位通过的人）
	 */
	@Override
	public List<DeclarerBean> getCandidates() {
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		List<DeclarerBean> ans = new ArrayList<DeclarerBean>();
		for (DeclarerBean d: list){
			if ( d.getReferRes() ) ans.add(d);
		}
		return ans;
	}

	/**将指定申报者的终评结果改成result
	 * @param ID 申报者ID
	 * @param result 终评结果 true：通过 false：不通过
	 */
	@Override
	public void changeFinalResult(int ID, boolean result) {
		DeclarerBean declarerBean = declarerBeanDAO.findById(ID);
		declarerBean.setFiJugdeRes(result);
		declarerBeanDAO.attachDirty(declarerBean);
	}

	/**获取所有终评候选人（初评通过的人）
	 * @return 所有终评候选人（初评通过的人）
	 */
	@Override
	public List<DeclarerBean> getPreCandidates() {
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		List<DeclarerBean> ans = new ArrayList<DeclarerBean>();
		for (DeclarerBean d: list){
			if ( d.getPreJugdeRes() ) ans.add(d);
		}
		return ans;
	}

	/**改变推荐单位名额
	 * @param ID 推荐单位ID
	 * @param quota 名额数
	 */
	@Override
	public void changeReferQuota(int ID, int quota) {
		ReferBean referBean = referBeanDAO.findById(ID);
		referBean.setQuota(quota);
		referBeanDAO.attachDirty(referBean);
	}

	/**改变专家组的初评名额
	 * @param ID 专家组ID
	 * @param quota 名额数
	 */
	@Override
	public void changePreQouta(int ID, int quota) {
		GroupBean groupBean = groupBeanDAO.findById(ID);
		groupBean.setQuota(quota);
		groupBeanDAO.attachDirty(groupBean);
	}

	/**改变终评名额
	 * @param quota 终评名额
	 */
	@Override
	public void changeFinalQuota(int quota) {
		// TODO Auto-generated method stub
		/**?**/;
	}

	/**获取所有学科组
	 * @return 所有学科组
	 */
	@Override
	public List<GroupBean> getGroups() {
		List<GroupBean> list = (List<GroupBean>)groupBeanDAO.findAll();
		return list;
	}

	/**获取指定学科组中的候选人
	 * @param ID 学科组ID
	 * @return 制定学科组中的所有候选人
	 */
	@Override
	public List<DeclarerBean> getCandidatesInGroup(int ID) {
		List<DeclarerBean> ans = new ArrayList<DeclarerBean>();
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		for (DeclarerBean d: list){
			if ( d.getGroupId() == ID ) ans.add(d);
		}
		return ans;
	}

	/**退回指定学科组的投票结果
	 * @param ID 学科组ID
	 */
	@Override
	public void returnGroupResult(int ID) {
		/**?**/
		GroupBean groupBean = groupBeanDAO.findById(ID);
		groupBean.setSubmit(false);
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		for (DeclarerBean d: list){
			if ( d.getGroupId() == ID ) {
				d.setPreJugdeCnt(0);
				d.setPreJugdeRes(false);
				declarerBeanDAO.attachDirty(d);
			}
		}
		groupBeanDAO.attachDirty(groupBean);
	}

	/**获取申报者人数总和
	 * @return 申报者人数总和
	 */
	@Override
	public int getTotalDeclarer() {
		return declarerBeanDAO.findAll().size();
	}

	/**获取所有单位已提交人数总和
	 * @return 所有单位已提交人数总和
	 */
	@Override
	public int getTotalSubmit() {
		int ans = 0;
		List<ReferBean> list = (List<ReferBean>)referBeanDAO.findAll();
		for (ReferBean r: list){
			if ( r.getSubmit() ) ans += r.getQuota();
		}
		
		return ans;
	}

	/**根据关键词查找推荐单位
	 * @param keyWord 关键词
	 * @return 符合关键词的所有推荐单位
	 */
	@Override
	public List<ReferBean> getRefers(String keyWord) {
		List<ReferBean> ans = new ArrayList<ReferBean>();
		List<ReferBean> list = (List<ReferBean>)referBeanDAO.findAll();
		for (ReferBean r: list){
			if ( r.getName().contains(keyWord) ) ans.add(r);
		}
		return ans;
	}

	/**退回指定推荐单位的提交结果
	 * @param ID 推荐单位ID
	 */
	@Override
	public void returnReferResult(int ID) {
		/**?**/
		ReferBean referBean = referBeanDAO.findById(ID);
		referBean.setSubmit(false);
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		for (DeclarerBean d: list){
			if ( d.getGroupId() == ID ) {
				d.setReferRes(false);
				declarerBeanDAO.attachDirty(d);
			}
		}
		referBeanDAO.attachDirty(referBean);
	}

	/**获取推荐单位下的申报者
	 * @param ID 推荐单位ID
	 * @return 指定推荐单位下的所有申报者
	 */
	@Override
	public List<DeclarerBean> getDeclarersInRefer(int ID) {
		List<DeclarerBean> list = (List<DeclarerBean>)declarerBeanDAO.findAll();
		List<DeclarerBean> ans = new ArrayList<DeclarerBean>();
		for (DeclarerBean d: list){
			if ( d.getRefer() == ID ) ans.add(d);
		}
		return ans;
	}

}
