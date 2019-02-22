package com.internousdev.ShoppingSite.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.LoginDAO;
import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.Passworder;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserPasswordAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private String nowPassword;
	private String newPassword;
	private String newPassword2;

	private String errorMsg;
	private String successMsg;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoUserInfoAction");
			return "needLogin";
		}

		int user_id = SessionSafeGetter.getInt(session, "user_id");
		String login_user_id = SessionSafeGetter.getString(session, "login_user_id");

		//	入力値チェック
		errorMsg = "";
		successMsg = "";

		String safe_nowpassword = Passworder.getSafetyPassword(nowPassword, login_user_id);
		String pass = LoginDAO.LoginAtUserId(login_user_id, nowPassword).getLogin_pass();
		if(!safe_nowpassword.equals(pass))
		{
			errorMsg += "パスワードが間違っています。<br/>";
		}

		if(!newPassword.equals(newPassword2))
		{
			errorMsg += "パスワードが一致しません。<br/>";
		}

		if(!StringChecker.IsOnlyAlphabet_Number(newPassword))
		{
			errorMsg += "パスワードは半角英数字のみ有効です。<br/>";
		}

		if(newPassword.length() < 8)
		{
			errorMsg += "パスワードは8文字以上でなければなりません。<br/>";
		}
		else if(newPassword.length() > 60)
		{
			errorMsg += "パスワードは60文字以下でなければなりません。<br/>";
		}

		if(!errorMsg.isEmpty())
		{
			return ERROR;
		}

		if(UserDAO.ChangeUserPassword(user_id, login_user_id, newPassword))
		{
			successMsg += "パスワードの変更に成功しました。<br/>";
			return SUCCESS;
		}
		else
		{
			errorMsg += "パスワードの変更に失敗しました。<br/>";
			return ERROR;
		}
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getNowPassword() {
		return nowPassword;
	}

	public void setNowPassword(String nowPassword) {
		this.nowPassword = nowPassword;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}


}