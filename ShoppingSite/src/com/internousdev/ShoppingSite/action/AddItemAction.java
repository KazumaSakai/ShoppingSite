package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AddItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddItemAction extends ActionSupport implements SessionAware
{
	private int item_id;
	private int request_count;
	private Map<String, Object> session;

	public String execute()
	{
		int user_id = (int)session.get("user_id");
		if(request_count < 0) request_count = 1;

		AddItemDAO addItemDAO = new AddItemDAO();

		boolean result = addItemDAO.addItemToCart(item_id, user_id, 1);

		return result ? SUCCESS : ERROR;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
