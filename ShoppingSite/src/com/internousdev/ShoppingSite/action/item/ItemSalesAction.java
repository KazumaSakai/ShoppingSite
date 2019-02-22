package com.internousdev.ShoppingSite.action.item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internousdev.ShoppingSite.dao.ItemSalesDAO;
import com.internousdev.ShoppingSite.dto.ItemSalesDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class ItemSalesAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	private int item_id;
	private String resultData;
	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";

		ObjectMapper mapper = new ObjectMapper();
		try
		{
			LocalDateTime time = LocalDateTime.now();
			List<ItemSalesDTO> list = new ArrayList<ItemSalesDTO>();

			List<ItemSalesDTO> getList = ItemSalesDAO.GetItemSales(item_id);
			for(int i = 0; i < 12; i++)
			{
				int y = time.getYear();
				int m = time.getMonthValue();


				boolean notAdd = true;

				for (ItemSalesDTO item : getList) {
					if(item.getMonth() == m && item.getYear() == y)
					{
						list.add(item);

						notAdd = false;
						break;
					}
				}
				if(notAdd)
				{
					ItemSalesDTO dto = new ItemSalesDTO();
					dto.setYear(y);
					dto.setMonth(m);
					list.add(dto);
				}
				time = time.minusMonths(1);
			}
			Collections.reverse(list);
			resultData = mapper.writeValueAsString(list);
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
