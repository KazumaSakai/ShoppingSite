package com.internousdev.ShoppingSite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AddressDAO;
import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPurchaseHistoryAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private int page;
	private List<PurchaseHistoryDTO> purchaseHistoryList;
	
	public String execute()
	{
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";
		
		purchaseHistoryList = PurchaseHistoryDAO.GetAllPurchaseHistory(50 * page, 50);

		for (PurchaseHistoryDTO dto : purchaseHistoryList)
		{
			dto.setAddressName(AddressDAO.GetAddress(dto.getAddress()));
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<PurchaseHistoryDTO> getPurchaseHistoryList() {
		return purchaseHistoryList;
	}

	public void setPurchaseHistoryList(List<PurchaseHistoryDTO> purchaseHistoryList) {
		this.purchaseHistoryList = purchaseHistoryList;
	}
}
