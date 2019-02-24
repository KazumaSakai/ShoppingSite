package com.internousdev.ShoppingSite.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.DestinationDAO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AddAddressAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private boolean goBuy;
	private String address;

	//	Send
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoAddAddressAction");
			return "needLogin";
		}

		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(address, "住所", 10, 100, CharType.IgnoreSymbol));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		int user_id = SessionSafeGetter.getInt(session, "user_id");
		if(DestinationDAO.AddAddress(user_id, address))
		{
			return goBuy ? "goBuy" : SUCCESS;
		}
		else
		{
			errorMsgList.add("住所の登録に失敗しました。");
			return ERROR;
		}
	}

	//	Getter Setter
	public boolean isGoBuy()
	{
		return goBuy;
	}
	public void setGoBuy(boolean goBuy)
	{
		this.goBuy = goBuy;
	}

	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}
	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
