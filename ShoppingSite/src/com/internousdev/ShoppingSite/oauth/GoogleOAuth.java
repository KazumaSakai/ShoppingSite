package com.internousdev.ShoppingSite.oauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internousdev.ShoppingSite.util.Passworder;

public class GoogleOAuth {
	private static final String client_id = "34746352072-tv6neqgl7uhuqutiqm5e93e4sbhn43li.apps.googleusercontent.com";
	private static final String client_secret = "_H9AFED1Qxt4rcgYCgHaLtEp ";
	
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
		String URL = "https://www.googleapis.com/oauth2/v1/tokeninfo?"
				+ "access_token=" + token.access_token;
		
		return URL;
	}
	
	public static String GMailInfo(GoogleOAuthToken token, String userId)
	{
		String URL = "https://www.googleapis.com/gmail/v1/users/" + userId + "/profile?"
				+ "access_token=" + token.access_token;
		
		return URL;
	}
	
	public static String UserInfo(GoogleOAuthToken token)
	{
		String URL = "https://www.googleapis.com/oauth2/v1/userinfo?"
				+ "access_token=" + token.access_token;
		
		return URL;
	}
	
	public static GoogleOAuthTokenInfo GetTokenInfo(GoogleOAuthToken token)
	{
		String url = GoogleOAuth.TokenInfo(token);
		String json = GoogleOAuth.Get(url);
		GoogleOAuthTokenInfo tokenInfo = null;
		try {
			tokenInfo = new ObjectMapper().readValue(json, GoogleOAuthTokenInfo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tokenInfo;
	}
	
	
	public static GoogleOAuthToken token(String code, String redirct)
	{
		String tokenURL = "https://accounts.google.com/o/oauth2/token?"
				+ "code=" + code
				+ "&grant_type=authorization_code"
				+ "&redirect_uri=" + redirct
				+ "&client_id=" + client_id
				+ "&client_secret=" + client_secret;

		GoogleOAuthToken googleOAuthToken = null;
		try
		{
			googleOAuthToken = new ObjectMapper().readValue(Post(tokenURL), GoogleOAuthToken.class);
        }
		catch (IOException e)
		{
            e.printStackTrace();
        }
		
		return googleOAuthToken;
	}
	
	public static String Get(String urlString)
	{
		String xml = "";
        try {
			URL url = new URL(urlString);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.connect();
		
			// サーバーからのレスポンスを標準出力へ出す
			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String line = "";
			while((line = reader.readLine()) != null)
			xml += line;
			reader.close();
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + urlString);
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Can't connect to " + urlString);
            System.exit(-1);
        }
        
		
		return xml;
	}
	
	public static String Post(String urlString)
	{
        String line = "";
        try {
            URL url = new URL(urlString);
            URLConnection uc = url.openConnection();
            uc.setDoOutput(true);//POST可能にする
 
            uc.setRequestProperty("User-Agent", "@IT java-tips URLConnection");// ヘッダを設定
            uc.setRequestProperty("Accept-Language", "ja");// ヘッダを設定
            OutputStream os = uc.getOutputStream();//POST用のOutputStreamを取得
        
            String postStr = "foo1=bar1&foo2=bar2";//POSTするデータ
            PrintStream ps = new PrintStream(os);
            ps.print(postStr);//データをPOSTする
            ps.close();
 
            InputStream is = uc.getInputStream();//POSTした結果を取得
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = reader.readLine()) != null)
            {
            	line += s;
            }
            reader.close();
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + urlString);
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Can't connect to " + urlString);
            System.exit(-1);
        }
        
        return line;
	}
	
	public static String userTokenURL = "https://www.googleapis.com/auth/userinfo.profile";
	public static String RequestUserToken()
	{
		return RequestToken(userTokenURL);
	}

	public static String gmailTokenURL = "https://www.googleapis.com/auth/gmail.readonly";
	public static String RequestGmailToken()
	{
		return RequestToken(gmailTokenURL);
	}

	public static String RequestToken(String scope, String redirect)
	{
		String URL = "https://accounts.google.com/o/oauth2/auth?client_id=" + client_id
				+ "&redirect_uri=" + redirect
				+ "&scope=" + scope
				+ "&response_type=code"
				+ "&access_type=offline"
				+ "&approval_prompt=force"
				+ "&state=" + Passworder.Random();
		
		return URL;
	}
	public static String RequestToken(String scope)
	{
		String redirect_uri = "http://localhost:8080/ShoppingSite/GoogleOauthAction.action";
		
		return RequestToken(scope,redirect_uri);
	}
}