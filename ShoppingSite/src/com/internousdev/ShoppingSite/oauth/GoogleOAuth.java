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

	/**
	 * 	Gmailの情報を取得する
	 * @param token
	 * 	トークン
	 * @return
	 * 	Gmailの情報
	 */
	public static GoogleOAuthGMailInfo GetGmailInfo(GoogleOAuthToken token)
	{
		//	トークン情報からユーザーIDを取得する
		GoogleOAuthTokenInfo googleOAuthTokenInfo = GoogleOAuth.FetchGoogleTokenInfo(token);
		String googleTokenUserId = googleOAuthTokenInfo.user_id;
		
		return GoogleOAuth.GetGmailInfo(token, googleTokenUserId);
	}

	/**
	 * 	Gmailの情報を取得する
	 * @param token
	 * 	トークン
	 * @param googleTokenUserId
	 * 	GoogleTokenInfoユーザーID
	 * @return
	 * 	Gmailの情報
	 */
	public static GoogleOAuthGMailInfo GetGmailInfo(GoogleOAuthToken token, String googleTokenUserId)
	{
		//	Gmail情報取得用のURL
		String urlForGmailInfo = GoogleOAuth.getGmailInfoURL(token, googleTokenUserId);
		
		//	Gmail情報のJSON
		String json = HTTP.GET(urlForGmailInfo);
		
		//	JSONを変換
		GoogleOAuthGMailInfo gMailInfo = null;
		try
		{
			gMailInfo = new ObjectMapper().readValue(json, GoogleOAuthGMailInfo.class);
		}
		catch (JsonParseException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return gMailInfo;
	}

	/**
	 * 	トークンの情報を取得する
	 * @param token
	 * 	トークン
	 * @return
	 * 	トークン情報
	 */
	public static GoogleOAuthTokenInfo FetchGoogleTokenInfo(GoogleOAuthToken token)
	{
		//	トークン情報取得先のURL
		String urlForTokenInfo = GoogleOAuth.getTokenInfoURL(token);

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
	public static GoogleOAuthToken FetchGoogleToken(String code, String redirctURL)
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

	/**
	 * UserInfoを得るためのURL
	 * @return
	 * 	URL
	 */
	public static String getUserInfoURL(GoogleOAuthToken token)
	{
		return "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + token.access_token;
	}

	/**
	 * GmailInfoを得るためのURL
	 * @param userId
	 * 	ユーザーID
	 * @return
	 * 	URL
	 */
	public static String getGmailInfoURL(GoogleOAuthToken token, String userId)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("https://www.googleapis.com/gmail/v1/users/").append(userId)
						.append("/profile?access_token=").append(token.access_token);

		return stringBuilder.toString();
	}

	/**
	 * 	TokenInfoを得るためのURL
	 * @return
	 * 	URL
	 */
	public static String getTokenInfoURL(GoogleOAuthToken token)
	{
		return "https://www.googleapis.com/oauth2/v1/tokeninfo?access_token=" + token.access_token;
	}
}
