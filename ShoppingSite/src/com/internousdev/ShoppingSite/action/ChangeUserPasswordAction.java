package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserPasswordAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String newPassword;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "notLogin";
		
		UserDAO.ChangeUserPassword((int)session.get("user_id"),(String)session.get("login_user_id"), newPassword);
		
		return SUCCESS;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}