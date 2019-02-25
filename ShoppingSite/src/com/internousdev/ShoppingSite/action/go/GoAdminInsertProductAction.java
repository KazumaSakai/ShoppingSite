package com.internousdev.ShoppingSite.action.go;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminInsertProductAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive + Send
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoAdminInsertProductAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		return SUCCESS;
	}

	//	Getter Setter
	public Map<String, Object> getSession()
	{
		return session;
	}
	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}

	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
