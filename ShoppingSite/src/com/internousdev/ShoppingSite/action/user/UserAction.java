package com.internousdev.ShoppingSite.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction  extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int userId;
	
	//	Send
	private UserDTO userDTO;
	
	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "");
			return "needLogin";
		}
		
		userDTO = UserDAO.SelectById(userId);

		return SUCCESS;
	}

	//	Getter Setter
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public UserDTO getUserDTO()
	{
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO)
	{
		this.userDTO = userDTO;
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
