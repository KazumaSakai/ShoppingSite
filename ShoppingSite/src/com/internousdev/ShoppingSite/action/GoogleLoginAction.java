package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.LoginDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthGMailInfo;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthToken;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthTokenInfo;
import com.internousdev.ShoppingSite.util.Passworder;
import com.opensymphony.xwork2.ActionSupport;

public class GoogleLoginAction extends ActionSupport implements SessionAware
{
	private String code;
	private String state;
	private String scope;
	
	private Map<String, Object> session;
	
	public String execute()
	{
		GoogleOAuthToken token = GoogleOAuth.token(code,"http://localhost:8080/ShoppingSite/GoogleLoginAction.action");
		GoogleOAuthTokenInfo tokenInfo = GoogleOAuth.GetTokenInfo(token);
		GoogleOAuthGMailInfo gMailInfo = GoogleOAuth.GetGMailInfo(token, tokenInfo.user_id);
		String email = gMailInfo.emailAddress;
		String pass = "AGgh_+" + tokenInfo.user_id;
		String safePass = Passworder.getSafetyPassword(pass, email);

		UserDTO userDTO = new UserDTO();
		userDTO = LoginDAO.LoginAtEmail(email, safePass);
		session.put("login_user", userDTO);

		if(((UserDTO)session.get("login_user")).getLoginFlg())
		{
			session.put("isAdmin", userDTO.getAdmin());
			session.put("user_id", userDTO.getId());
			session.put("login_user_id", userDTO.getLogin_id());
			session.put("user_name", userDTO.getUser_name());
			session.put("isLogin", true);
			
			return SUCCESS;
		}
		
		return ERROR;
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
