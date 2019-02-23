package com.internousdev.ShoppingSite.action.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.LoginDAO;
import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserPasswordAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	private String nowPassword;
	private String newPassword;
	private String newPassword2;

	//	Send
	private List<String> errorMsgList;
	private List<String> successMsgList;

	//	Session
	private Map<String, Object> session;
	
	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoUserInfoAction");
			return "needLogin";
		}

		int user_id = SessionSafeGetter.getInt(session, "user_id");
		String login_user_id = SessionSafeGetter.getString(session, "login_user_id");

		//	入力値チェック
		if(!LoginDAO.CheckPassword(login_user_id, nowPassword))
		{
			errorMsgList.add("パスワードが間違っています。");
		}
		errorMsgList.addAll(StringChecker.CheckEqual(newPassword, newPassword2, "新しいパスワード", "新しいパスワード（確認）"));
		errorMsgList.addAll(StringChecker.Check(newPassword, "パスワード", 8, 60, CharType.Alphabet, CharType.Number));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		if(UserDAO.ChangeUserPassword(user_id, login_user_id, newPassword))
		{
			successMsgList.add("パスワードの変更に成功しました。");
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("パスワードの変更に失敗しました。");
			return ERROR;
		}
	}

	//	Getter Setter
	public String getNowPassword()
	{
		return nowPassword;
	}
	public void setNowPassword(String nowPassword)
	{
		this.nowPassword = nowPassword;
	}
	
	public String getNewPassword()
	{
		return newPassword;
	}
	public void setNewPassword(String newPassword)
	{
		this.newPassword = newPassword;
	}
	
	public String getNewPassword2()
	{
		return newPassword2;
	}
	public void setNewPassword2(String newPassword2)
	{
		this.newPassword2 = newPassword2;
	}
	
	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}
	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}
	
	public List<String> getSuccessMsgList()
	{
		return successMsgList;
	}
	public void setSuccessMsgList(List<String> successMsgList)
	{
		this.successMsgList = successMsgList;
	}
	
	public Map<String, Object> getSession()
	{
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
