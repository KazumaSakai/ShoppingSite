package com.internousdev.ShoppingSite.action.go;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class GoSalesDataAction extends ActionSupport implements SessionAware
{
	private int item_id;
	private Map<String, Object> session;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoSalesDataAction");
			return "needLogin";
		}
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";
		
		return SUCCESS;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
}