package com.internousdev.ShoppingSite.action.cart;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class MyCartAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Send
	private List<ItemDTO> itemList;
	private int totalPrice;
	
	//	Sesiion
	private Map<String, Object> session;
	
	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "MyCartAction");
			return "needLogin";
		}
		
		int user_id = SessionSafeGetter.getInt(session, "user_id");

		itemList = MyCartDAO.GetMyCart(user_id);
		totalPrice = itemList.stream().mapToInt(i -> i.getItem_price() * i.getItem_count()).sum();

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
