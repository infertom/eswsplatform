package com.novae.eswsplatform.service;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.novae.eswsplatform.bean.*;
import com.novae.eswsplatform.dao.*;

public class LoginServiceImp implements LoginService {
	/**�û���������֤
	 * @param account �˺�
	 * @param psw ����
	 * @param role ��ɫ�ţ�1-�걨�ߣ�2-�Ƽ���λ��3-����ר�ң�
	 * @return true���˺�������֤��ȷ false���˺�������֤����
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
	
	/**�ж�ָ��ϵͳ�Ƿ�open
	 * ��open���õ�½
	 * @param role ��ɫ�ţ�1-�걨�ߣ�2-�Ƽ�ר�ң�3-����ר�ң�
	 * @return true���� false����
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
