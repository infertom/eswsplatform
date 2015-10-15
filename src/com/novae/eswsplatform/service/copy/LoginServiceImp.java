package com.novae.eswsplatform.service.copy;

import java.sql.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.novae.eswsplatform.bean.*;
import com.novae.eswsplatform.dao.*;

public class LoginServiceImp implements LoginService {
	/**用户名密码验证
	 * @param account 账号
	 * @param psw 密码
	 * @param role 角色号（1-申报者，2-推荐单位，3-评审专家）
	 * @return true：账号密码验证正确 false：账号密码验证错误
	 */
	@Override
	public Boolean login(String account, String psw, int role) {
		Boolean ans = false;
		
		switch (role)
		{
			case 1:
				ans = judgeDeclarerBean(account, psw);
				break;
			case 2:
				ans = judgeReferBean(account, psw);
				break;
			case 3:
				ans = judgeExpertBean(account, psw);
				break;
			default :
				break;
		}
		
		
		return ans;
	}

	private Boolean judgeDeclarerBean(String account, String psw)
	{
		DeclarerBeanDAO dao = new DeclarerBeanDAO();
		DeclarerBean bean = (DeclarerBean)dao.findByAccount(account).get(0);
		
		if ( psw.equals(bean.getPassword()) ) return true;
		else return false;
	}
	
	private Boolean judgeReferBean(String account, String psw)
	{
		ReferBeanDAO dao = new ReferBeanDAO();
		ReferBean bean = (ReferBean)dao.findByAccount(account).get(0);
		
		if ( psw.equals(bean.getPassword()) ) return true;
		else return false;
	}
	
	private Boolean judgeExpertBean(String account, String psw)
	{
		ExpertBeanDAO dao = new ExpertBeanDAO();
		ExpertBean bean = (ExpertBean)dao.findByAccount(account).get(0);
		
		if ( psw.equals(bean.getPassword()) ) return true;
		else return false;
	}
	
	/**判断指定系统是否open
	 * 不open不让登陆
	 * @param role 角色号（1-申报者，2-推荐专家，3-评审专家）
	 * @return true：开 false：关
	 */
	@Override
	public Boolean isOpen(int role) {
		Boolean ans = false;
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		SystemTimeBeanDAO dao = new SystemTimeBeanDAO();
		SystemTimeBean bean = dao.findById(role);
		
		if ( currentTime.after(bean.getOpenTime()) && currentTime.before(bean.getCloseTime()) ){
			ans = true;
		}
		
		return ans;
	}

}
