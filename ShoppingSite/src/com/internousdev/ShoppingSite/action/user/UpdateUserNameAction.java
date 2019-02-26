package com.internousdev.ShoppingSite.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserNameAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private String newUserName;

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

		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(newUserName, "ユーザー名", 4, 60, CharType.IgnoreSymbol));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		int userId = SessionSafeGetter.getInt(session, "userId");
		UserDTO userDTO = UserDAO.SelectById(userId);
		userDTO.setUserName(newUserName);
		if(UserDAO.Update(userDTO))
		{
			successMsgList.add("ユーザー名の変更に成功しました。");
			session.put("userName", newUserName);
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("ユーザー名の変更に失敗しました。");
			return ERROR;
		}
	}

	//	Getter Setter
	public String getNewUserName()
	{
		return newUserName;
	}

	public void setNewUserName(String newUserName)
	{
		this.newUserName = newUserName;
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
