package com.internousdev.ShoppingSite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyCartAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private List<ItemDTO> itemList;
	private int totalPrice;

	public String execute()
	{
		boolean isLogin = (boolean)session.get("isLogin");
		if(!isLogin)
		{
			return "login";
		}
		int user_id = (int)session.get("user_id");

		MyCartDAO myCartDAO = new MyCartDAO();
		itemList = myCartDAO.getMyCart(user_id).getCartItemList();

		totalPrice = 0;
		for (ItemDTO item : itemList)
		{
			totalPrice += item.getItem_price() * item.getItem_count();
		}

		return SUCCESS;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}
}
