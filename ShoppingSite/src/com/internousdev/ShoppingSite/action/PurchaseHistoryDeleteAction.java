package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryDeleteAction extends ActionSupport implements SessionAware
{
	private int id;
	private Map<String, Object> session;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "needLogin";
		
		int user_id = (int)session.get("user_id");
		
		boolean result= PurchaseHistoryDAO.DeletePurchaseHistory(id, user_id);
		
		return result ? SUCCESS : ERROR;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
