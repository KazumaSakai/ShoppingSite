package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDeleteItemAction extends ActionSupport implements SessionAware
{
	private int id;
	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";

		ItemDAO.DeleteItem(id);

		return SUCCESS;
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

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}