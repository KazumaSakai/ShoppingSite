package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.LoginDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class EmailLoginAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String email;
	private String login_pass;
	private String result;

	public String execute()
	{
		UserDTO userDTO = new UserDTO();

		result = ERROR;
		userDTO = LoginDAO.LoginAtEmail(email, login_pass);
		session.put("login_user", userDTO);

		if(((UserDTO)session.get("login_user")).getLoginFlg())
		{
			result = SUCCESS;

			session.put("isAdmin", userDTO.getAdmin());
			session.put("user_id", userDTO.getId());
			session.put("login_user_id", userDTO.getLogin_id());
			session.put("user_name", userDTO.getUser_name());
			session.put("isLogin", true);
		}

		return result;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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