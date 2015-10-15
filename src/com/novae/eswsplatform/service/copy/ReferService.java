package com.novae.eswsplatform.service.copy;

import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.*;

public interface ReferService {
	/**判断是否已经提交
	 * 推荐单位不能重复提交
	 * @return true：已经提交 false：未提交
	 */
	Boolean isSubmit(int ID);

	/**获取当前推荐单位的所有申报者
	 * 在推荐单位页面显示所有申报者时调用
	 * @param referID 推荐单位ID
	 * @return 指定推荐单位下所有已提交的申报者
	 */
	List<DeclarerBean> getDeclarers(int referID);

	/**获取指定ID的申报者基本信息
	 * 点击详情是调用
	 * @param ID 申报者ID
	 * @return 指定申报者的基本信息
	 */
	DeclarerBean getDeclarerBean(int ID); 

	/**获取该推荐单位的推荐名额
	 * 显示页面时需要调用
	 * @return 指定推荐单位的名额
	 */
	int getQuota(int ID); 

	/**提交
	 * 选择申报者后点击提交需要调用的方法
	 * @param declarersID 所有打了勾的申报者的ID
	 */
	void submit(ArrayList<Integer> declarersID, int referId); 

}
