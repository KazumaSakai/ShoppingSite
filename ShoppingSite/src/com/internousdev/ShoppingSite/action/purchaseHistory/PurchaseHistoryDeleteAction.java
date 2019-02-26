package com.internousdev.ShoppingSite.action.purchaseHistory;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryDeleteAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int purchaseHistoryId;

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
		return PurchaseHistoryDAO.DeleteByIdAndUserId(purchaseHistoryId, userId) ? SUCCESS : ERROR;
	}

	//	Getter Setter
	public int getPurchaseHistoryId()
	{
		return purchaseHistoryId;
	}

	public void setPurchaseHistoryId(int purchaseHistoryId)
	{
		this.purchaseHistoryId = purchaseHistoryId;
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
