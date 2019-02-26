package com.internousdev.ShoppingSite.action.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction  extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive + Send
	private List<String> errorMsg;
	private List<String> successMsg;

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

		return SUCCESS;
	}

	//	Getter Setter
	public List<String> getErrorMsg()
	{
		return errorMsg;
	}
	public void setErrorMsg(List<String> errorMsg)
	{
		this.errorMsg = errorMsg;
	}

	public List<String> getSuccessMsg()
	{
		return successMsg;
	}
	public void setSuccessMsg(List<String> successMsg)
	{
		this.successMsg = successMsg;
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
