package com.internousdev.ShoppingSite.oauth;

import java.util.HashMap;

public enum GoogleScope
{
	GmailToken,
	UserToken;

    public static final HashMap<GoogleScope, String> URLMap = new HashMap<GoogleScope, String>()
	{
		private static final long serialVersionUID = 1L;

    	{
            put(GoogleScope.GmailToken, "https://www.googleapis.com/auth/gmail.readonly");
            put(GoogleScope.UserToken, "https://www.googleapis.com/auth/userinfo.profile");
    	}
	};

	public static String CreateScopeURL(GoogleScope[] googleScopeCollection)
	{
		StringBuilder url = new StringBuilder();

		boolean isFirst = true;
		for (GoogleScope googleScope : googleScopeCollection)
		{
			if(isFirst)
			{
				isFirst = false;
			}
			else
			{
				url.append("%20");
			}

			url.append(GoogleScope.URLMap.get(googleScope));
		}

		return url.toString();
	}

	public static String CreateScopeURL(Iterable<GoogleScope> googleScopeCollection)
	{
		StringBuilder url = new StringBuilder();

		boolean isFirst = true;
		for (GoogleScope googleScope : googleScopeCollection)
		{
			if(isFirst)
			{
				isFirst = false;
			}
			else
			{
				url.append("%20");
			}

			url.append(GoogleScope.URLMap.get(googleScope));
		}

		return url.toString();
	}
}
