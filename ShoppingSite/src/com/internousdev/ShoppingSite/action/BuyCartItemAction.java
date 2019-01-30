package com.internousdev.ShoppingSite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.BuyItemDAO;
import com.internousdev.ShoppingSite.dao.ItemSalesDAO;
import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class BuyCartItemAction extends ActionSupport implements SessionAware
{
	private List<ItemDTO> buyItemList;
	private Map<String, Object> session;
	private int totalPrice;
	private int address;
	private String phoneNumber;
	private String request_date;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "MyCartAction");
			return "needLogin";
		}
		
		int user_id = (int)session.get("user_id");
		List<ItemDTO> itemListDTO = MyCartDAO.GetMyCart(user_id);

		buyItemList = new ArrayList<ItemDTO>(itemListDTO.size());

		boolean AllSuccess = true;
		
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		for (ItemDTO item : itemListDTO)
		{
			
			if(!buyItemDAO.buyItem(item.getItem_id(), user_id, item.getItem_count()))
			{
				AllSuccess = false;
			}
			else
			{
				buyItemList.add(item);
				
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
				dto.setItem_id(item.getItem_id());
				dto.setQuantity(item.getItem_count());
				dto.setUser_id(user_id);
				dto.setAddress(address);
				dto.setPhoneNumber(phoneNumber);
				dto.setRequest_date(request_date);
				
				PurchaseHistoryDAO.AddPurchaseHistory(dto);
				ItemSalesDAO.AddSalesData(item.getItem_id(), item.getItem_count(), item.getItem_count() * item.getItem_price());
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

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRequest_date() {
		return request_date;
	}

	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}
}
