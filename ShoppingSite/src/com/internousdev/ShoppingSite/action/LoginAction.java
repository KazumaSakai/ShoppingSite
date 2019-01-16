package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.LoginDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String login_user_id;
	private String login_pass;
	private String result;

	public String execute()
	{
		LoginDAO loginDAO = new LoginDAO();
		UserDTO userDTO = new UserDTO();

		result = ERROR;
		userDTO = loginDAO.getLoginUserInfo(login_user_id, login_pass);
		session.put("login_user", userDTO);

		if(((UserDTO)session.get("login_user")).getLoginFlg())
		{
			result = SUCCESS;

			session.put("login_user_id", userDTO.getLogin_id());
		}

		return result;
	}


	public String getLogin_user_id() {
		return login_user_id;
	}


	public void setLogin_user_id(String login_user_id) {
		this.login_user_id = login_user_id;
	}

	public String getLogin_pass() {
		return login_pass;
	}

	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}