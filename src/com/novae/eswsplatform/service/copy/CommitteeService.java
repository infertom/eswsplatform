package com.novae.eswsplatform.service.copy;

import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.DeclarerBean;

/**给专家模块的接口
 * @author Kinslayer
 *
 * 2015年5月16日
 */

public interface CommitteeService {
	/**获取指定学科组中的候选人
	 * @param ID 学科组ID
	 * @return 学科组中的所有候选人
	 */
	List<DeclarerBean> getCandidatesInGroup(int ID); 

	/**获取指定学科组投票结果
	 * 专家点击查看查看投票结果时所调用的方法
	 * 需要按投票数由高到低排序
	 * @param ID 学科组ID
	 * @return 按照投票数排序的候选人
	 */
	List<DeclarerBean> getResultsInGroup(int ID);

	/**获取指定ID的候选人基本信息
	 * 在点击详情时需要调用该方法（可能会用cookie代替）
	 * @param ID 候选人ID
	 * @return 指定候选人的基本信息
	 */
	DeclarerBean getDeclarerBean(int ID); 

	/**获取指定专家组的分配名额
	 * 页面刷出来时要显示
	 * @param ID 专家组ID
	 * @return 指定专家组分配名额
	 */
	int getGroupQuota(int ID); 

	/**判断该专家是否已经提交
	 * 已经提交的专家不会显示提交到本组按钮
	 * @param ID 专家ID
	 * @return true：已提交 false：未提交
	 */
	Boolean isSubmitToGroup(int ID); 

	/**判断该组所有专家是否已经提交
	 * 所有专家提交时，组长页面显示提交到委员会按钮
	 * @return true：所有专家都已经提交 false：存在专家还未提交
	 */
	Boolean isAllSubmit(int ID); 

	/**判断是否已提交到委员会
	 * 组长提交给委员会后不能重复提交
	 * @param ID 专家组ID
	 * @return true：已提交 false：未提交
	 */
	Boolean isSubmitToCommittee(int ID); 

	/**提交到本组
	 * 专家提交到组长时调用的方法
	 * @param declarers 所选的候选人ID
	 */
	void submitToGroup(ArrayList<Integer> declarers, int expertID); 
	
	/**提交到委员会
	 * 组长提交给委员会
	 * @param declarers 进入终评的名单
	 */
	void submitToCommittee(ArrayList<Integer> declarers, int expertID); 

	/**获取指定委员会的分配名额
	 * 委员会成员登陆时页面刷出来时要显示
	 * @return 委员会名额
	 */
	int getCommitteeQuota(); 

	/**将指定申报者的初评结果改成result
	 * @param ID 申报者ID
	 * @param result true：通过 false：不通过
	 */
	void changePreResult(int ID, boolean result); 

}
