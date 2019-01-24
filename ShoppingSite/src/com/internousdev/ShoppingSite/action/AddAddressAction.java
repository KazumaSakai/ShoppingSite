package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AddressDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AddAddressAction extends ActionSupport implements SessionAware
{
	private boolean goBuy;
	private String address;
	private Map<String, Object> session;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "needLogin";
		
		int user_id = (int)session.get("user_id");
		
		if(AddressDAO.AddUserAddress(user_id, address))
		{
			return goBuy ? "goBuy" : SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public boolean getGoBuy() {
		return goBuy;
	}

	public void setGoBuy(boolean goBuy) {
		this.goBuy = goBuy;
	}

}
