package com.internousdev.ShoppingSite.action;

import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.opensymphony.xwork2.ActionSupport;

public class StartGoogleOAuthAction extends ActionSupport
{
	private String url;

	public String execute()
	{
		setUrl(GoogleOAuth.RequestToken(GoogleOAuth.gmailTokenURL + "%20" + GoogleOAuth.userTokenURL));
		
		return "redirect";
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
