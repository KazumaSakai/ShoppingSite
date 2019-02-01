package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class GoAddAddressAction extends ActionSupport implements SessionAware
{
	private boolean goBuy;
	
	private String errorMsg;
	
	private Map<String, Object> session;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoAddAddressAction");
			return "needLogin";
		}
		
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

	public boolean isGoBuy() {
		return goBuy;
	}

	public void setGoBuy(boolean goBuy) {
		this.goBuy = goBuy;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
