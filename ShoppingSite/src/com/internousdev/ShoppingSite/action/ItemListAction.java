package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemListDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;

	public String execute()
	{
		String result = SUCCESS;

		ItemListDAO itemListDAO = new ItemListDAO();
		session.put("itemList", itemListDAO.getItemList().getCartItemList());

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
