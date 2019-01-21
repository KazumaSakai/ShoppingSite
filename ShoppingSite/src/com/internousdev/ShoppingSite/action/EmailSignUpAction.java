package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.SignUpDAO;
import com.opensymphony.xwork2.ActionSupport;

public class EmailSignUpAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String login_id;
	private String login_pass;
	private String user_name;
	private String email;

	public String execute()
	{
		boolean result = SignUpDAO.SignUp(email, email, login_pass, user_name);

		return result ? SUCCESS : ERROR;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin_id() {
		return login_id;
	}


	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
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