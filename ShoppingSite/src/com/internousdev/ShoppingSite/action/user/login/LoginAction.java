package com.internousdev.ShoppingSite.action.user.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private String loginId;
	private String planeLoginPassword;

	//	Send
	private List<String> errorMsgList;
	private String redirectAction;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(loginId, "ログインID", 4, 60, CharType.Alphabet, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(planeLoginPassword, "パスワード", 8, 60, CharType.Alphabet, CharType.Number));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		//	ユーザー情報を取得
		UserDTO userDTO = UserDAO.Login(loginId, planeLoginPassword);
		if(userDTO == null)
		{
			errorMsgList.add("ログインができませんでした、ログインIDまたはパスワードが間違っています。");
			return ERROR;
		}

		//	セッションにユーザー情報をプットする
		session.put("isAdmin", userDTO.isAdmin());
		session.put("userId", userDTO.getId());
		session.put("loginUserId", userDTO.getLoginId());
		session.put("userName", userDTO.getUserName());
		session.put("isLogin", true);

		//	セッションにリダイレクト先のアクションが入っているならば、リダイレクトさせる
		redirectAction = SessionSafeGetter.getString(session, "LoginedRedirectAction");
		if(!redirectAction.isEmpty())
		{
			session.put("LoginedRedirectAction", "");
			return "redirectAction";
		}

		return SUCCESS;
	}

	//	Getter Setter
	public String getLoginId()
	{
		return loginId;
	}

	public void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}

	public String getPlaneLoginPassword()
	{
		return planeLoginPassword;
	}

	public void setPlaneLoginPassword(String planeLoginPassword)
	{
		this.planeLoginPassword = planeLoginPassword;
	}

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}

	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}

	public String getRedirectAction()
	{
		return redirectAction;
	}

	public void setRedirectAction(String redirectAction)
	{
		this.redirectAction = redirectAction;
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
