package com.internousdev.ShoppingSite.oauth;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internousdev.ShoppingSite.util.HTTP;
import com.internousdev.ShoppingSite.util.Passworder;

public class GoogleOAuth
{
	private static final String clientId = "34746352072-tv6neqgl7uhuqutiqm5e93e4sbhn43li.apps.googleusercontent.com";
	private static final String clientSecret = "_H9AFED1Qxt4rcgYCgHaLtEp ";

	public static GoogleOAuthGMailInfo GetGMailInfo(GoogleOAuthToken token)
	{
		GoogleOAuthTokenInfo googleOAuthTokenInfo = GoogleOAuth.GetTokenInfo(token);
		String userId = googleOAuthTokenInfo.user_id;
		return GetGMailInfo(token, userId);
	}

	public static GoogleOAuthGMailInfo GetGMailInfo(GoogleOAuthToken token, String userId)
	{
		String s = GoogleOAuth.GMailInfo(token, userId);
		GoogleOAuthGMailInfo gMailInfo = null;
		try {
			gMailInfo = new ObjectMapper().readValue(GoogleOAuth.Get(s), GoogleOAuthGMailInfo.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gMailInfo;
	}

	public static String TokenInfo(GoogleOAuthToken token)
	{
		String URL = "https://www.googleapis.com/oauth2/v1/tokeninfo?" + "access_token=" + token.access_token;

		return URL;
	}

	public static String GMailInfo(GoogleOAuthToken token, String userId)
	{
		String URL = "https://www.googleapis.com/gmail/v1/users/" + userId + "/profile?" + "access_token="
				+ token.access_token;

		return URL;
	}

	public static String UserInfo(GoogleOAuthToken token)
	{
		String URL = "https://www.googleapis.com/oauth2/v1/userinfo?" + "access_token=" + token.access_token;

		return URL;
	}

	/**
	 * 	トークンの情報を取得する
	 * @param token
	 * 	トークン
	 * @return
	 * 	トークン情報
	 */
	public static GoogleOAuthTokenInfo GetTokenInfo(GoogleOAuthToken token)
	{
		String urlForTokenInfo = GoogleOAuth.TokenInfo(token);

		//	GETでトークン情報を取得
		String tokenInfoJson = HTTP.GET(urlForTokenInfo);

		//	JsonからGoogleOAuthTokenInfoに変換
		GoogleOAuthTokenInfo tokenInfo = null;
		try
		{
			tokenInfo = new ObjectMapper().readValue(tokenInfoJson, GoogleOAuthTokenInfo.class);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return tokenInfo;
	}

	/**
	 *	トークンを取得する
	 * @param code
	 * 	コード
	 * @param redirctURL
	 * 	リダイレクト先
	 * @return
	 * 	トークン
	 */
	public static GoogleOAuthToken getGoogleToken(String code, String redirctURL)
	{
		StringBuilder tokenURL = new StringBuilder();
		tokenURL.append("https://accounts.google.com/o/oauth2/token?code=").append(code)
				.append("&grant_type=authorization_code")
				.append("&redirect_uri=").append(redirctURL)
				.append("&client_id=").append(clientId)
				.append("&client_secret=").append(clientSecret);

		//	POSTして値を得る
		String tokenJson = HTTP.POST(tokenURL.toString());

		//	JSONからGoogleOAuthTokenに変換
		GoogleOAuthToken googleOAuthToken = null;
		try
		{
			googleOAuthToken = new ObjectMapper().readValue(tokenJson, GoogleOAuthToken.class);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return googleOAuthToken;
	}


	/**
	 * 	トークンを得るためのURL先<br/>
	 * 	http://localhost:8080/ShoppingSite/GoogleOauthAction.actionにリダイレクト
	 * @param scope
	 * 	必要なトークン
	 * @return
	 * 	URL
	 */
	public static String URLForRequestToken(GoogleScope...googleScopes)
	{
		String redirectURI = "http://localhost:8080/ShoppingSite/GoogleOauthAction.action";

		return URLForRequestToken(redirectURI, googleScopes);
	}

	/**
	 * 	トークンを得るためのURL先
	 * @param scope
	 * 	必要なトークン
	 * @param redirect
	 * 	トークンを得た後のリダイレクト先
	 * @return
	 * 	URL
	 */
	public static String URLForRequestToken(String redirect, GoogleScope...googleScopes)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("https://accounts.google.com/o/oauth2/auth?client_id=").append(clientId);
		stringBuilder.append("&redirect_uri=").append(redirect);
		stringBuilder.append("&scope=").append(GoogleScope.CreateScopeURL(googleScopes));
		stringBuilder.append("&response_type=code");
		stringBuilder.append("&access_type=offline");
		stringBuilder.append("&approval_prompt=force");
		stringBuilder.append("&state=").append(Passworder.Random());

		return stringBuilder.toString();
	}
}
