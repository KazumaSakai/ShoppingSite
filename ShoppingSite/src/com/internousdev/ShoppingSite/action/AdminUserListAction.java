package com.internousdev.ShoppingSite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AdminUserListDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserListAction extends ActionSupport implements SessionAware
{
	private List<UserDTO> userList = new ArrayList<UserDTO>();
	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";

		 userList = AdminUserListDAO.GetUserList();

		return SUCCESS;
	}

	public List<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDTO> userList) {
		this.userList = userList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
