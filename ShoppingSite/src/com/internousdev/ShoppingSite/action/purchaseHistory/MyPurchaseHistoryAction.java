package com.internousdev.ShoppingSite.action.purchaseHistory;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AddressDAO;
import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class MyPurchaseHistoryAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	private List<PurchaseHistoryDTO> purchaseHistoryList;
	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "MyPurchaseHistoryAction");
			return "needLogin";
		}
		
		int user_id = (int)session.get("user_id");
		
		purchaseHistoryList = PurchaseHistoryDAO.GetMyPurchaseHistory(user_id);
		
		for (PurchaseHistoryDTO dto : purchaseHistoryList)
		{
			dto.setAddressName(AddressDAO.GetAddress(dto.getAddress()));
		}
		return SUCCESS;
	}
	
	public List<PurchaseHistoryDTO> getPurchaseHistoryList() {
		return purchaseHistoryList;
	}
	public void setPurchaseHistoryList(List<PurchaseHistoryDTO> purchaseHistoryList) {
		this.purchaseHistoryList = purchaseHistoryList;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
