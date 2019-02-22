package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AddItemAction extends ActionSupport implements SessionAware
{
	private int item_id;
	private int request_Quantity;
	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemListAction");
			return "needLogin";
		}

		this.request_Quantity = Math.max(1, request_Quantity);
		int user_id = (int)session.get("user_id");

		return MyCartDAO.AddItemToCart(item_id, user_id, request_Quantity) ? SUCCESS : ERROR;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public int getRequest_Quantity() {
		return request_Quantity;
	}

	public void setRequest_Quantity(int request_Quantity) {
		this.request_Quantity = request_Quantity;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
