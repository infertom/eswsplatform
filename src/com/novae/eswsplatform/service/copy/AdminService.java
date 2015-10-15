package com.novae.eswsplatform.service.copy;

import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.*;

/**
 * 给超级管理员模块提供的接口
 * @author Kinslayer
 *
 * 2015年5月16日
 */
public interface AdminService {
	
	/**获取指定系统的开关时间
	 * @param role 角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @return 指定系统的系统开关时间
	 */
	SystemTimeBean getSystemTime(int role);

	/**更改指定系统时间
	 * @param role  角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @param time 修改后的时间
	 */
	void changeTime(int role,SystemTimeBean time);

	/**判断推荐单位账号是否被使用
	 * @param account 待判断的推荐单位账号
	 * @return true：账号被使用 false：账号未被使用
	 */
	Boolean referAccountIsUsed(String account);

	/**判断评审专家账号是否被使用
	 * @param account 待判断的评审专家账号
	 * @return true：账号被使用 false：账号未被使用
	 */
	Boolean expertAccountIsUsed(String account);

	/**推荐单位注册
	 * @param account 新的账号
	 * @param psw 密码
	 * @param rb 新注册单位的基本信息
	 */
	void referRegister(String account, String psw, ReferBean rb); 

	/**评审专家注册
	 * @param account 新的账号
	 * @param psw 密码
	 * @param eb 新注册专家的基本信息
	 */
	void expertRegister(String account, String psw, ExpertBean eb); 

	/**获取推荐单位
	 * @return 所有的推荐单位
	 */
	List<ReferBean> getRefers(); 

	/**获取评审专家
	 * @return 所有的推荐专家
	 */
	List<ExpertBean> getExperts(); 

	/**获取当前推荐单位的所有申报者
	 * @param referID 推荐单位ID
	 * @return 指定推荐单位下的所有申报者
	 */
	List<DeclarerBean> getDeclarers(int referID); 

	/**更改密码
	 * @param account 需要修改密码的账号
	 * @param role 需要修改密码的角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @param newPsw 新的密码
	 */
	void changePsw(String account, int role, String newPsw); 

	/**删除账号
	 * @param account 需要删除的账号
	 * @param role 需要删除的账号的角色号（1-申报者，2-推荐专家，3-评审专家）
	 */
	void deleteAccount(String account, int role); 

	/**增加科学组（学科组中有个莫名其妙的登陆账号）
	 * @param gb 需要增加的学科组的基本信息
	 */
	void addGroup(GroupBean gb); 

	/**删除学科组
	 * @param ID 需要删除的学科组的ID
	 */
	void deleteGroup(int ID); 

	/**修改学科组
	 * @param gb 修改后的学科组的基本信息
	 */
	void modifyGroup(GroupBean gb); 

	/**获取所有申报者
	 * @return 所有申报者
	 */
	List<DeclarerBean> getDeclarers(); 

	/**指定申报者分配指定学科组
	 * @param CandidateID 申报者ID
	 * @param groupID 学科组ID
	 */
	void changeGroup(int CandidateID, int groupID); 

	/**将指定申报者的初评结果改成result
	 * @param ID 申报者ID
	 * @param result 初评结果 true：通过 false：不通过
	 */
	void changePreResult(int ID, boolean result); 

	/**获取所有候选人（推荐单位通过的人）
	 * @return 所有候选人（推荐单位通过的人）
	 */
	List<DeclarerBean> getCandidates(); 

	/**将指定申报者的终评结果改成result
	 * @param ID 申报者ID
	 * @param result 终评结果 true：通过 false：不通过
	 */
	void changeFinalResult(int ID, boolean result); 

	/**获取所有终评候选人（初评通过的人）
	 * @return 所有终评候选人（初评通过的人）
	 */
	List<DeclarerBean> getPreCandidates(); 

	/**改变推荐单位名额
	 * @param ID 推荐单位ID
	 * @param quota 名额数
	 */
	void changeReferQuota(int ID, int quota); 

	/**改变专家组的初评名额
	 * @param ID 专家组ID
	 * @param quota 名额数
	 */
	void changePreQouta(int ID, int quota); 

	/**改变终评名额
	 * @param quota 终评名额
	 */
	void changeFinalQuota(int quota); 

	/**获取所有学科组
	 * @return 所有学科组
	 */
	List<GroupBean> getGroups(); 

	/**获取指定学科组中的候选人
	 * @param ID 学科组ID
	 * @return 制定学科组中的所有候选人
	 */
	List<DeclarerBean> getCandidatesInGroup(int ID);

	/**退回指定学科组的投票结果
	 * @param ID 学科组ID
	 */
	void returnGroupResult(int ID); 

	/**获取申报者人数总和
	 * @return 申报者人数总和
	 */
	int getTotalDeclarer(); 

	/**获取所有单位已提交人数总和
	 * @return 所有单位已提交人数总和
	 */
	int getTotalSubmit(); 

	/**根据关键词查找推荐单位
	 * @param keyWord 关键词
	 * @return 符合关键词的所有推荐单位
	 */
	List<ReferBean> getRefers(String keyWord);

	/**退回指定推荐单位的提交结果
	 * @param ID 推荐单位ID
	 */
	void returnReferResult(int ID); 

	/**获取推荐单位下的申报者
	 * @param ID 推荐单位ID
	 * @return 指定推荐单位下的所有申报者
	 */
	List<DeclarerBean> getDeclarersInRefer(int ID); 
}
