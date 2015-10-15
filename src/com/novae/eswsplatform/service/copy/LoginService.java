package com.novae.eswsplatform.service.copy;

/**
 * @author Kinslayer
 *
 *         2015年5月16日
 */
public interface LoginService {
	/**用户名密码验证
	 * @param account 账号
	 * @param psw 密码
	 * @param role 角色号（1-申报者，2-推荐单位，3-评审专家）
	 * @return true：账号密码验证正确 false：账号密码验证错误
	 */
	Boolean login(String account, String psw, int role);

	/**判断指定系统是否open
	 * 不open不让登陆
	 * @param role 角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @return true：开 false：关
	 */
	Boolean isOpen(int role);
}
