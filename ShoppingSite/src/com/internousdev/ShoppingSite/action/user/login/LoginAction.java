package com.internousdev.ShoppingSite.action.user.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.LoginDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private String login_user_id;
	private String login_pass;

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
		errorMsgList.addAll(StringChecker.Check(login_pass, "パスワード", 8, 60, CharType.Alphabet, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(login_user_id, "ログインID", 4, 60, CharType.Alphabet, CharType.Number));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}
		
		//	ユーザー情報を取得
		UserDTO userDTO = LoginDAO.LoginAtUserId(login_user_id, login_pass);
		if(userDTO == null)
		{
			errorMsgList.add("ログインができませんでした、ログインIDまたはパスワードが間違っています。");
			return ERROR;
		}
		
		session.put("isAdmin", userDTO.getAdmin());
		session.put("user_id", userDTO.getId());
		session.put("login_user_id", userDTO.getLogin_id());
		session.put("user_name", userDTO.getUser_name());
		session.put("isLogin", true);
		
		//	セッションにリダイレクト先のアクションが入っているならば、リダイレクトさせる;
		redirectAction = SessionSafeGetter.getString(session, "LoginedRedirectAction");
		if(!redirectAction.isEmpty())
		{
			session.put("LoginedRedirectAction", "");
			return "redirectAction";
		}
		
		return SUCCESS;
	}

	//	Getter Setter
	public String getLogin_user_id()
	{
		return login_user_id;
	}
	public void setLogin_user_id(String login_user_id)
	{
		this.login_user_id = login_user_id;
	}

	public String getLogin_pass()
	{
		return login_pass;
	}
	public void setLogin_pass(String login_pass)
	{
		this.login_pass = login_pass;
	}

	public String getRedirectAction()
	{
		return redirectAction;
	}
	public void setRedirectAction(String redirectAction)
	{
		this.redirectAction = redirectAction;
	}

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}
	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
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
