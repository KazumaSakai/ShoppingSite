package com.internousdev.ShoppingSite.action.google;

import java.util.ArrayList;
import java.util.List;

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
	
	//	Send
	private List<String> errorMsgList;
	
	//	Execute
	public String execute()
	{
		GoogleOAuthToken token = GoogleOAuth.FetchGoogleToken(code,"http://ec2-54-200-170-136.us-west-2.compute.amazonaws.com:8080/ShoppingSite/GoogleSignUpAction.action");
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
		
		if(UserDAO.Insert(userDTO))
		{
			return SUCCESS;
		}
		else
		{
			errorMsgList = new ArrayList<String>();
			errorMsgList.add("ユーザーの登録に失敗しました。");
			errorMsgList.add("既に登録された認証アカウントでないか、確認してください。");
			
			return ERROR;
		}
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

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}
	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}
}

