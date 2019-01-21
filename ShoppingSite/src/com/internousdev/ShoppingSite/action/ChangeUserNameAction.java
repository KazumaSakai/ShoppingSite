package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserNameAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String newUserName;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "notLogin";
		
		int user_id = (int)session.get("user_id");
		UserDAO.ChangeUserName(user_id, newUserName);
		session.put("user_name", UserDAO.GetUserName(user_id)); 
		
		return SUCCESS;
	}

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}