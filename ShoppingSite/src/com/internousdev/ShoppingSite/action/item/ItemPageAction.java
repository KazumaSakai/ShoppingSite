package com.internousdev.ShoppingSite.action.item;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.dao.ItemReviewDAO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.dto.ItemReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemPageAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private int id;
	
	//	Send
	private ItemDTO itemDTO;
	private List<ItemReviewDTO> itemReviewList;
	private String errorMsg;
	
	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		itemDTO = ItemDAO.GetItem(id);
		itemReviewList = ItemReviewDAO.GetReviewList(id);

		return SUCCESS;
	}

	//	Getter Setter
	public List<ItemReviewDTO> getItemReviewList()
	{
		return itemReviewList;
	}
	public void setItemReviewList(List<ItemReviewDTO> itemReviewList)
	{
		this.itemReviewList = itemReviewList;
	}

	public ItemDTO getItemDTO()
	{
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO)
	{
		this.itemDTO = itemDTO;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public String getErrorMsg()
	{
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
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
