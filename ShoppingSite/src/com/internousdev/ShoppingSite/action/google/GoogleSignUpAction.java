package com.internousdev.ShoppingSite.action.google;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthGMailInfo;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthToken;
import com.internousdev.ShoppingSite.oauth.GoogleOAuthTokenInfo;
import com.internousdev.ShoppingSite.util.Passworder;
import com.opensymphony.xwork2.ActionSupport;

public class GoogleSignUpAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private String code;
	private String state;
	private String scope;
	
	//	Execute
	public String execute()
	{
		GoogleOAuthToken token = GoogleOAuth.FetchGoogleToken(code,"http://localhost:8080/ShoppingSite/GoogleSignUpAction.action");
		GoogleOAuthTokenInfo tokenInfo = GoogleOAuth.FetchGoogleTokenInfo(token);
		GoogleOAuthGMailInfo gMailInfo = GoogleOAuth.GetGmailInfo(token, tokenInfo.user_id);
		
		String email = gMailInfo.emailAddress;
		String planePass = tokenInfo.user_id;
		String safePass = Passworder.getSafetyPassword(planePass, email);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setLoginId(email);
		userDTO.setLoginPass(safePass);
		userDTO.setUserName(email);
		userDTO.setEmail(email);
		userDTO.setDestinationId(0);
		userDTO.setOauthUser(true);
		
		return UserDAO.Insert(userDTO) ? SUCCESS : ERROR;
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
}

