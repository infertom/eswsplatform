package com.novae.eswsplatform.service;
import java.util.ArrayList;
import java.util.List;

import com.novae.eswsplatform.bean.*;

/**
 * @author Kinslayer
 *
 * 2015骞�鏈�6鏃�
 */
public interface DeclarerService {
	/**鍒ゆ柇鐢ㄦ埛鍚嶆槸鍚﹀凡缁忚鍗犵敤
	 * @param account 闇�鍒ゆ柇鐨勭敤鎴峰悕
	 * @return true锛氬凡琚崰鐢�false锛氭湭琚崰鐢�
	 */
	Boolean declarerAccountIsUsed(String account); //

	/**鐢虫姤鑰呮敞鍐�
	 * @param account 鏂扮殑璐︽埛
	 * @param psw 瀵嗙爜
	 */
	void declarerRegister(String account, String psw); // 

	/**鍒ゆ柇璇ョ敵鎶ヨ�鏄惁宸叉彁浜ょ敵鎶ヤ俊鎭�
	 * 鐢虫姤鑰呬笉鑳介噸澶嶅湴鎻愪氦
	 * @param ID 鐢虫姤鑰匢D
	 * @return true锛氬凡鎻愪氦鍩烘湰淇℃伅 false:鏈彁浜�
	 */
	boolean isSubmit(int ID); // 

	/**鑾峰彇鍩烘湰淇℃伅
	 * 鍦ㄦ敞鍐岄〉闈腑闇�鏄剧ず鐢虫姤鑰呮浘缁忎繚瀛樿繃鐨勫熀鏈俊鎭�
	 * @param ID 鐢虫姤鑰匢D
	 * @return 鎸囧畾鐢虫姤鑰呯殑鍩烘湰淇℃伅
	 */
	DeclarerBean getBasicInform(int ID); // 

	/**淇濆瓨鍩烘湰淇℃伅
	 * 鍩烘湰淇℃伅鐐瑰嚮淇濆瓨鏃堕渶瑕佽皟鐢ㄧ殑鏂规硶
	 * @param jb 淇敼鍚庣殑淇℃伅
	 * @param ID 鐢虫姤鑰匢D
	 */
	void saveBasicInform(DeclarerBean db, int ID); // 

	/**鑾峰彇鎵�幏绉戞妧濂栧姳鍜岃崳瑾夌О鍙锋儏鍐�
	 * 鍦ㄦ敞鍐岄〉闈腑闇�鏄剧ず鐢虫姤鑰呮浘缁忎繚瀛樿繃鐨勫鍔卞拰绉板彿鎯呭喌
	 * @param ID 鐢虫姤鑰匢D
	 * @return 鎸囧畾鐢虫姤鑰呮墍鏈夋墍鑾风鎶�鍔卞拰鑽ｈ獕绉板彿鎯呭喌
	 */
	List<AwardBean> getAward(int ID); // 

	/**淇濆瓨鎵�幏绉戞妧濂栧姳鍜岃崳瑾夌О鍙锋儏鍐�
	 * 濂栧姳鍜岀О鍙风偣鍑讳繚瀛樻椂闇�璋冪敤鐨勬柟娉�
	 * @param jb 
	 */
	void saveAward(ArrayList<AwardBean> ab);  

	List<TreatiseBean> getTreatise(int ID); // 鑾峰彇鍙戣〃璁烘枃鍜屼笓钁楁儏鍐�

	void saveTreatise(ArrayList<TreatiseBean> tb); // 淇濆瓨鍙戣〃璁烘枃鍜屼笓钁楁儏鍐�

	List<SubsidizeBean> getSubsidize(int ID); // 鑾峰彇鑾峰熀閲戣祫鍔╂儏鍐�

	void saveSubsidize(ArrayList<SubsidizeBean> sb); // 淇濆瓨鑾峰熀閲戣祫鍔╂儏鍐�

	List<ProjectBean> getProject(int ID); // 鑾峰彇鍙備笌閲嶅ぇ宸ョ▼鎶�湳椤圭洰鎯呭喌

	void saveProject(ArrayList<ProjectBean> pb); // 淇濆瓨鍙備笌閲嶅ぇ宸ョ▼鎶�湳椤圭洰鎯呭喌

	List<AchConvertBean> getAchConvert(int ID); // 鑾峰彇绉戞妧鎴愭灉杞寲銆佺鏅拰绉戞妧绠＄悊鎯呭喌

	void saveAchConvert(ArrayList<AchConvertBean> cb); // 淇濆瓨绉戞妧鎴愭灉杞寲銆佺鏅拰绉戞妧绠＄悊鎯呭喌

	String getReferReason(int ID); // 鑾峰彇缁煎悎鎺ㄨ崘鐞嗙敱

	void saveReferReason(String test,int ID); // 淇濆瓨缁煎悎鎺ㄨ崘鐞嗙敱

	/**鎻愪氦
	 * 鐐瑰嚮鎻愪环鏃堕渶瑕佽皟鐢ㄧ殑鏂规硶
	 * @param ID 鐢虫姤鑰匢D
	 */
	void submit(int ID);

}
