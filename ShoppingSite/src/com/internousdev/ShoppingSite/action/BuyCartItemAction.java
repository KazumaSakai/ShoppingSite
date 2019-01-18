package com.internousdev.ShoppingSite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class BuyCartItemAction extends ActionSupport implements SessionAware
{
	private List<ItemDTO> buyItemList;
	private Map<String, Object> session;
	private int totalPrice;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "needLogin";

		int user_id = (int)session.get("user_id");
		List<ItemDTO> itemListDTO = MyCartDAO.GetMyCart(user_id);

		buyItemList = new ArrayList<ItemDTO>(itemListDTO.size());

		boolean AllSuccess = true;
		for (ItemDTO item : itemListDTO)
		{
			if(!item.buyItem(user_id))
			{
				AllSuccess = false;
			}
			else
			{
				buyItemList.add(item);
			}
		}

		totalPrice = 0;
		for (ItemDTO item : buyItemList)
		{
			totalPrice += item.getItem_price() * item.getItem_count();
		}

		return AllSuccess ? SUCCESS : ERROR;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ItemDTO> getBuyItemList() {
		return buyItemList;
	}

	public void setBuyItemList(List<ItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
