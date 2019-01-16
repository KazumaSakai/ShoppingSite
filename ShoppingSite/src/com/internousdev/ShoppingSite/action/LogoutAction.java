package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;

	public String execute()
	{
		String result = SUCCESS;

		session.put("user_id", "");
		session.put("login_user_id", "");
		session.put("user_name", "");
		session.put("isLogin", false);

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}