package com.internousdev.ShoppingSite.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.Pager;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserListAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 10;

	//	Receive
	private int page;

	//	Send
	private int[] pager;
	private List<UserDTO> userList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		this.page = Math.max(1, this.page) - 1;
		
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "AdminUserListAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		this.userList = UserDAO.SelectList(pageLength * page, pageLength);
		this.pager = Pager.CreatePager(page, Pager.PageCount(UserDAO.Count(), pageLength), 7);

		return SUCCESS;
	}

	//	Getter Setter
	public int getPage()
	{
		return page;
	}
	public void setPage(int page)
	{
		this.page = page;
	}
	public int[] getPager()
	{
		return pager;
	}
	public void setPager(int[] pager)
	{
		this.pager = pager;
	}
	public List<UserDTO> getUserList()
	{
		return userList;
	}
	public void setUserList(List<UserDTO> userList)
	{
		this.userList = userList;
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
