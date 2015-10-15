package com.novae.eswsplatform.service.copy;
import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.*;

/**
 * @author Kinslayer
 *
 * 2015骞�鏈�6鏃�
 */
public interface DeclarerService {
	/**判断用户名是否已经被占用
	 * @param account 需要判断的用户名
	 * @return true：已被占用 false：未被占用
	 */
	Boolean declarerAccountIsUsed(String account); //

	/**申报者注册
	 * @param account 用户名
	 * @param psw 密码
	 * @param name 姓名
	 * @param sex 性别 1 男 0 女
	 * @param birthDay 出生日期
	 * @param unitname 单位名称
	 */
	void declarerRegister(String account, String psw, String name, boolean sex, String birthDay, String unitname); // 

	/**判断该申报者是否已提交申报信息
	 * 申报者不能重复地提交
	 * @param ID 申报者ID
	 * @return true：已提交基本信息 false:未提交
	 */
	boolean isSubmit(int ID); // 

	/**获取基本信息
	 * 在注册页面中需要显示申报者曾经保存过的基本信息
	 * @param ID 申报者ID
	 * @return 指定申报者的基本信息
	 */
	DeclarerBean getBasicInform(int ID); // 

	/**保存基本信息
	 * 基本信息点击保存时需要调用的方法
	 * @param db 修改后的信息
	 * @param ID 申报者ID
	 */
	void saveBasicInform(DeclarerBean db, int ID); // 

	/**获取所获科技奖励和荣誉称号情况
	 * 在注册页面中需要显示申报者曾经保存过的奖励和称号情况
	 * @param ID 申报者ID
	 * @return 指定申报者所有所获科技奖励和荣誉称号情况
	 */
	List<AwardBean> getAward(int ID); // 

	/**保存所获科技奖励和荣誉称号情况
	 * 奖励和称号点击保存时需要调用的方法
	 * @param db
	 */
	void saveAward(ArrayList<AwardBean> ab);  
	/**
	 * @param ID
	 * @return 获取发表论文和专著情况
	 */
	List<TreatiseBean> getTreatise(int ID); 

	void saveTreatise(ArrayList<TreatiseBean> tb); 

	List<SubsidizeBean> getSubsidize(int ID); 

	void saveSubsidize(ArrayList<SubsidizeBean> sb); 
	
	/**
	 * @param ID
	 * @return 获取参与重大工程技术项目情况
	 */
	List<ProjectBean> getProject(int ID); 

	void saveProject(ArrayList<ProjectBean> pb); 

	/**
	 * @param ID
	 * @return 获取科技成果转化、科普和科技管理情况
	 */
	List<AchConvertBean> getAchConvert(int ID); 

	void saveAchConvert(ArrayList<AchConvertBean> cb); 

	/**
	 * @param ID
	 * @return 获取综合推荐理由
	 */
	String getReferReason(int ID);

	void saveReferReason(String test,int ID); 

	/**鎻愪氦
	 * 鐐瑰嚮鎻愪环鏃堕渶瑕佽皟鐢ㄧ殑鏂规硶
	 * @param ID 鐢虫姤鑰匢D
	 */
	void submit(int ID);

}
