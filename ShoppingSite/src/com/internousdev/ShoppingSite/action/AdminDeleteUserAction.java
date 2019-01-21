package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDeleteUserAction extends ActionSupport implements SessionAware
{
	private int id;
	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";

		UserDAO.DeleteUser(id);

		return SUCCESS;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}