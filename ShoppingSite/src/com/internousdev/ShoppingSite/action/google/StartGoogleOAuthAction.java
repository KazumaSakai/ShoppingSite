package com.internousdev.ShoppingSite.action.google;

import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.internousdev.ShoppingSite.oauth.GoogleScope;
import com.opensymphony.xwork2.ActionSupport;

public class StartGoogleOAuthAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	//	Receive + Send
	private String redirectURL;

	//	Execute
	public String execute()
	{
		//	リダイレクト先がないならば、loginSuccess.jspへ
		if(redirectURL == null || redirectURL.isEmpty()) redirectURL = "HomeAction";	

		this.redirectURL = GoogleOAuth.URLForRequestToken("http://ec2-54-200-170-136.us-west-2.compute.amazonaws.com:8080/ShoppingSite/" + redirectURL, GoogleScope.UserToken, GoogleScope.GmailToken);

		return "redirect";
	}

	//	Getter Setter
	public String getRedirectURL()
	{
		return redirectURL;
	}
	public void setRedirectURL(String redirectURL)
	{
		this.redirectURL = redirectURL;
	}
}
