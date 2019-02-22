package com.internousdev.ShoppingSite.action.user.signup;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.SignUpDAO;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String login_id;
	private String login_pass;
	private String user_name;
	private String email;

	private String errorMsg;

	public String execute()
	{
		//	入力値チェック
		errorMsg = "";

		//	パスワードチェック
		if(login_pass == null || login_pass.length() < 8)
		{
			errorMsg += "パスワードは8文字以上でなければなりません。<br />";
		}
		if(login_pass.length() > 60)
		{
			errorMsg += "パスワードは60文字以下でなければなりません。<br />";
		}
		if(!StringChecker.IsOnlyAlphabet_Number(login_pass))
		{
			errorMsg += "パスワードは半角英数字のみ使用できます。<br/>";
		}

		//	ログインIDチェック
		if(login_id == null || login_id.length() < 4)
		{
			errorMsg += "ログインIDは4文字以上でなければなりません。<br />";
		}
		if(login_id.length() > 60)
		{
			errorMsg += "ログインIDは60文字以下でなければなりません。<br />";
		}
		if(!StringChecker.IsOnlyAlphabet_Number(login_id))
		{
			errorMsg += "ログインIDは半角英数字のみ使用できます。<br/>";
		}

		//	ユーザー名チェック
		if(user_name == null || login_id.length() < 4)
		{
			errorMsg += "ユーザー名は4文字以上でなければなりません。<br />";
		}
		if(user_name.length() > 60)
		{
			errorMsg += "ユーザー名は60文字以下でなければなりません。<br />";
		}
		if(!StringChecker.IsSafeString(user_name))
		{
			errorMsg += "ユーザー名に不正な文字が含まれています。<br/>";
		}

		if(email.getBytes().length > 255)
		{
			errorMsg += "メールアドレスは255バイト以下でなければなりません。<br/>";
		}
		if(!StringChecker.IsMailAddress(email))
		{
			errorMsg += "メールアドレスの値が不正です。";
		}

		if(!errorMsg.isEmpty()) return ERROR;

		if(SignUpDAO.SignUp(login_id, email, login_pass, user_name, false))
		{
			return SUCCESS;
		}
		else
		{
			errorMsg = "ユーザーの登録に失敗しました。<br/>IDまたはメールアドレスが既に使用されています。";
			return ERROR;
		}
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin_id() {
		return login_id;
	}


	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getLogin_pass() {
		return login_pass;
	}

	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}