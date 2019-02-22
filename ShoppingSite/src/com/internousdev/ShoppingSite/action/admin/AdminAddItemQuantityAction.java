package com.internousdev.ShoppingSite.action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAddItemQuantityAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private int id;
	private int quantity;
	
	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemListAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		ItemDAO.AddItemQuantity(id, quantity);

		return SUCCESS;
	}

	//	Getter Setter
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
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
