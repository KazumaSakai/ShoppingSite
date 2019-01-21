package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthGMailInfo;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthToken;
import com.opensymphony.xwork2.ActionSupport;

public class GoogleSignUpAction extends ActionSupport implements SessionAware
{
	private String code;
	private String state;
	private String scope;
	private String email;
	
	private Map<String, Object> session;
	
	public String execute()
	{

		GoogleOAuthToken token = GoogleOAuth.token(code,"http://localhost:8080/ShoppingSite/GoogleSignUpAction.action");
		GoogleOAuthGMailInfo gMailInfo = GoogleOAuth.GetGMailInfo(token);
		email = gMailInfo.emailAddress;
		session.put("gmail", email);
		session.put("googleToken", token);
		session.put("isGoogleOAuth", true);
		
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
