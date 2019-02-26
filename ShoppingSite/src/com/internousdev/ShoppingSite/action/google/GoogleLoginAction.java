package com.internousdev.ShoppingSite.action.google;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthGMailInfo;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthToken;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthTokenInfo;
import com.opensymphony.xwork2.ActionSupport;

public class GoogleLoginAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private String code;
	private String state;
	private String scope;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		GoogleOAuthToken goooAuthToken = GoogleOAuth.FetchGoogleToken(code,"http://localhost:8080/ShoppingSite/GoogleLoginAction.action");
		GoogleOAuthTokenInfo googleOAuthTokenInfo = GoogleOAuth.FetchGoogleTokenInfo(goooAuthToken);
		GoogleOAuthGMailInfo googleOAuthGmailInfo = GoogleOAuth.GetGmailInfo(goooAuthToken, googleOAuthTokenInfo.user_id);

		String email = googleOAuthGmailInfo.emailAddress;
		String planePass = googleOAuthTokenInfo.user_id;

		//	Emailでログインを試す
		UserDTO userDTO = UserDAO.LoginByEmail(email, planePass);

		//	ログインできていない、もしくは認証ユーザーではないならログインさせない
		if(userDTO == null || !userDTO.isOauthUser())
		{
			return ERROR;
		}

		session.put("isAdmin", userDTO.isAdmin());
		session.put("userId", userDTO.getId());
		session.put("loginId", userDTO.getLoginId());
		session.put("userName", userDTO.getUserName());
		session.put("isLogin", true);

		return SUCCESS;
	}

	//	Getter Setter
	public String getScope()
	{
		return scope;
	}
	public void setScope(String scope)
	{
		this.scope = scope;
	}

	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}

	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
