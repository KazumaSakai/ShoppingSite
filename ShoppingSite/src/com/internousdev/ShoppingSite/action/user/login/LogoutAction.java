package com.internousdev.ShoppingSite.action.user.login;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		session.put("userId", "");
		session.put("loginUserId", "");
		session.put("userName", "");
		session.put("isLogin", false);
		session.put("isAdmin", false);

		return SUCCESS;
	}

	//	Getter Setter
	public Map<String, Object> getSession()
	{
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

}
