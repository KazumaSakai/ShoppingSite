package com.internousdev.ShoppingSite.action.item;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class AddItemAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private int item_id;
	private int request_Quantity;
	
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

		request_Quantity = Math.max(1, request_Quantity);
		int user_id = SessionSafeGetter.getInt(session, "user_id");

		return MyCartDAO.AddItemToCart(item_id, user_id, request_Quantity) ? SUCCESS : ERROR;
	}

	//	Getter Setter
	public int getItem_id()
	{
		return item_id;
	}
	public void setItem_id(int item_id)
	{
		this.item_id = item_id;
	}

	public int getRequest_Quantity()
	{
		return request_Quantity;
	}
	public void setRequest_Quantity(int request_Quantity)
	{
		this.request_Quantity = request_Quantity;
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
