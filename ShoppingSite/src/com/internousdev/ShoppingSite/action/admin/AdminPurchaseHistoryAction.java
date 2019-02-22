package com.internousdev.ShoppingSite.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPurchaseHistoryAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int page;

	//	Send
	private List<PurchaseHistoryDTO> purchaseHistoryList;
	
	//	Session
	private Map<String, Object> session;
	
	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemListAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		purchaseHistoryList = PurchaseHistoryDAO.GetAllPurchaseHistory(50 * page, 50);
		
		return SUCCESS;
	}

	//	Getter Setter
	public int getPage()
	{
		return page;
	}
	public void setPage(int page)
	{
		this.page = page;
	}

	public List<PurchaseHistoryDTO> getPurchaseHistoryList()
	{
		return purchaseHistoryList;
	}
	public void setPurchaseHistoryList(List<PurchaseHistoryDTO> purchaseHistoryList)
	{
		this.purchaseHistoryList = purchaseHistoryList;
	}
	
	public Map<String, Object> getSession()
	{
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

}
