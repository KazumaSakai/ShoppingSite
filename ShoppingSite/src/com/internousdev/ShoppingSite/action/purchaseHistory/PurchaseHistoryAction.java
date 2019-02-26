package com.internousdev.ShoppingSite.action.purchaseHistory;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 50;

	//	Send
	private List<PurchaseHistoryDTO> purchaseHistoryList;
	private int page;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "MyPurchaseHistoryAction");
			return "needLogin";
		}

		int userId = SessionSafeGetter.getInt(session, "userId");
		purchaseHistoryList = PurchaseHistoryDAO.SelectListByUserId(page * pageLength, pageLength, userId);

		return SUCCESS;
	}

	//	Getter Setter
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
