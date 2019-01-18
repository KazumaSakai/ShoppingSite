package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String execute()
	{
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";

		return SUCCESS;
	}
}
