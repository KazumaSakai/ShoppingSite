package com.internousdev.ShoppingSite.action.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserListAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	private List<UserDTO> userList = new ArrayList<UserDTO>();
	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "AdminUserListAction");
			return "needLogin";
		}
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";

		 userList = UserDAO.GetUserList();

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
