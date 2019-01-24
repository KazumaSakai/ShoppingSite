package com.internousdev.ShoppingSite.action;

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
	private String max;
	private String min;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "needLogin";

		int user_id = (int)session.get("user_id");

		myCartItemList = MyCartDAO.GetMyCart(user_id);
		addressList = AddressDAO.GetUserAddressList(user_id);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.add(Calendar.DAY_OF_MONTH, 1);
        min = sdf.format(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 15);
        max = sdf.format(c.getTime());
        
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

}
