package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internousdev.ShoppingSite.dao.ItemSalesDAO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class ItemSalesAction extends ActionSupport implements SessionAware
{
	private int item_id;
	private String resultData;
	private Map<String, Object> session;
	
	public String execute()
	{
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";
		
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			resultData = mapper.writeValueAsString(ItemSalesDAO.GetItemSales(item_id));
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getResultData() {
		return resultData;
	}

	public void setResultData(String resultData) {
		this.resultData = resultData;
	}
}
