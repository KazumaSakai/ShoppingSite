package com.internousdev.ShoppingSite.action.user.signup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.SignUpDAO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private String login_id;
	private String login_pass;
	private String user_name;
	private String email;

	//	Send
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;
	
	//	Execute
	public String execute()
	{
		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(login_pass, "パスワード", 8, 60, CharType.Alphabet, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(login_id, "ログインID", 4, 60, CharType.Alphabet, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(user_name, "ユーザー名", 4, 60, CharType.IgnoreSymbol));
		errorMsgList.addAll(StringChecker.CheckEmail(email, "メールアドレス"));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		if(SignUpDAO.SignUp(login_id, email, login_pass, user_name, false))
		{
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("ユーザーの登録に失敗しました。<br/>IDまたはメールアドレスが既に使用されています。");
			return ERROR;
		}
	}

	//	Getter Setter
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getLogin_id()
	{
		return login_id;
	}
	public void setLogin_id(String login_id)
	{
		this.login_id = login_id;
	}

	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}

	public String getLogin_pass()
	{
		return login_pass;
	}
	public void setLogin_pass(String login_pass)
	{
		this.login_pass = login_pass;
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
