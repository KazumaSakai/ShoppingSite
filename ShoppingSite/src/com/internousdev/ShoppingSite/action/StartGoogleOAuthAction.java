package com.internousdev.ShoppingSite.action;

import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.opensymphony.xwork2.ActionSupport;

public class StartGoogleOAuthAction extends ActionSupport
{
	private String url;

	public String execute()
	{
		if(url == null) url = "loginSuccess.jsp";
		setUrl(GoogleOAuth.RequestToken(GoogleOAuth.gmailTokenURL + "%20" + GoogleOAuth.userTokenURL, "http://localhost:8080/ShoppingSite/" + url));
		
		return "redirect";
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}