package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminAddItemAction extends ActionSupport implements SessionAware
{
	private String errorMsg;
	
	private Map<String, Object> session;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoAdminAddItemAction");
			return "needLogin";
		}
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";

		return SUCCESS;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
