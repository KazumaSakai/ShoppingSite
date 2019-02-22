package com.internousdev.ShoppingSite.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AddressDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AddAddressAction extends ActionSupport implements SessionAware
{
	private boolean goBuy;
	private String address;

	private String errorMsg;

	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoAddAddressAction");
			return "needLogin";
		}

		errorMsg = "";

		if(address == null || address.length() < 10)
		{
			errorMsg += "住所は10文字以上でなければなりません。<br/>";
		}
		else if(address.length() > 100)
		{
			errorMsg += "住所は100文字以下でなければなりません。<br/>";
		}
		if(!StringChecker.IsSafeString(address))
		{
			errorMsg += "住所に不正な文字列が含まれています。<br/>";
		}

		if(!errorMsg.equals(""))
		{
			return ERROR;
		}

		int user_id = (int)session.get("user_id");

		if(AddressDAO.AddUserAddress(user_id, address))
		{
			return goBuy ? "goBuy" : SUCCESS;
		}
		else
		{
			errorMsg += "住所の登録に失敗しました。<br/>";
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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}