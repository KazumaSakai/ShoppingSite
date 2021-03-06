package com.internousdev.ShoppingSite.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class UserPageAction  extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "UserPageAction");
			return "needLogin";
		}

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
