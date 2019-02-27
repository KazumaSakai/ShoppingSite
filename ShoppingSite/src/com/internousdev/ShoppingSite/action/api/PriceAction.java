package com.internousdev.ShoppingSite.action.api;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.CartDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class PriceAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Send
	private String jsonString;

	//	Sesiion
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			return SUCCESS;
		}
		
		int userId = SessionSafeGetter.getInt(session, "userId");
		this.jsonString = Integer.toString(CartDAO.SumPrice(userId));
		
		return SUCCESS;
	}

	//	Getter Setter
	public String getJsonString()
	{
		return jsonString;
	}

	public void setJsonString(String jsonString)
	{
		this.jsonString = jsonString;
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
}
