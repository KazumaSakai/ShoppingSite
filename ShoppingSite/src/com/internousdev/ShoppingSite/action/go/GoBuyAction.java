package com.internousdev.ShoppingSite.action.go;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AddressDAO;
import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.dto.AddressDTO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private List<AddressDTO> addressList;
	private List<ItemDTO> myCartItemList;
	private int totalPrice;
	private String max;
	private String min;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoBuyAction");
			return "needLogin";
		}

		int user_id = (int)session.get("user_id");

		myCartItemList = MyCartDAO.GetMyCart(user_id);
		addressList = AddressDAO.GetUserAddressList(user_id);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");

        c.add(Calendar.DAY_OF_MONTH, 1);
        min = a.format(c.getTime()) + "T08:00";
        c.add(Calendar.DAY_OF_MONTH, 15);
        max = a.format(c.getTime()) + "T22:00";

		totalPrice = 0;
		for (ItemDTO item : myCartItemList)
		{
			totalPrice += item.getItem_price() * item.getItem_count();
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public List<AddressDTO> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressDTO> addressList) {
		this.addressList = addressList;
	}

	public List<ItemDTO> getMyCartItemList() {
		return myCartItemList;
	}

	public void setMyCartItemList(List<ItemDTO> myCartItemList) {
		this.myCartItemList = myCartItemList;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}