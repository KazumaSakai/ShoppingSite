package com.internousdev.ShoppingSite.action.google;

import com.internousdev.ShoppingSite.oauth.GoogleOAuth;
import com.opensymphony.xwork2.ActionSupport;

public class StartGoogleOAuthAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	//	Receive + Send
	private String url;

	//	Execute
	public String execute()
	{
		if(url == null || url.isEmpty()) url = "loginSuccess.jsp";
		
		String returnUrl = GoogleOAuth.RequestToken(GoogleOAuth.gmailTokenURL + "%20" + GoogleOAuth.userTokenURL, "http://localhost:8080/ShoppingSite/" + url);

		url = returnUrl;
		
		return "redirect";
	}

	//	Getter Setter
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}


}
