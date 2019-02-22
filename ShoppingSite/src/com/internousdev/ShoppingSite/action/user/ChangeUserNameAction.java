package com.internousdev.ShoppingSite.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserNameAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	private String newUserName;

	private Map<String, Object> session;

	private String errorMsg;
	private String successMsg;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoUserInfoAction");
			return "needLogin";
		}

		//	入力値チェック
		errorMsg = "";
		successMsg = "";

		if(newUserName == null || newUserName.length() < 4)
		{
			errorMsg += "ユーザー名は4文字以上でなければなりません。<br/>";
		}
		else if(newUserName.length() > 60)
		{
			errorMsg += "ユーザー名は60文字以下でなければなりません。<br/>";
		}

		if(!errorMsg.isEmpty())
		{
			return ERROR;
		}

		int user_id = SessionSafeGetter.getInt(session, "user_id");

		if(UserDAO.ChangeUserName(user_id, newUserName))
		{
			successMsg += "ユーザー名の変更に成功しました。<br/>";
			session.put("user_name", UserDAO.GetUserName(user_id));
			return SUCCESS;
		}
		else
		{
			errorMsg += "ユーザー名の変更に失敗しました。<br/>";
			return ERROR;
		}

	}

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
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

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}


}