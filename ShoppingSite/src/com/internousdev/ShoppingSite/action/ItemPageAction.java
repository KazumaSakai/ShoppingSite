package com.internousdev.ShoppingSite.action;

import java.util.ArrayList;
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
	private boolean reviewExists;
	private int id;
	private ItemDTO itemDTO;
	private List<ItemReviewDTO> itemReviewList = new ArrayList<ItemReviewDTO>();
	private Map<String, Object> session;



	public String execute()
	{
		itemDTO = ItemDAO.GetItem(id);

		ItemReviewDAO itemReviewDAO = new ItemReviewDAO();
		itemReviewList = itemReviewDAO.getItem(id);

		reviewExists = itemReviewList.size() > 0;

		return SUCCESS;
	}

	public boolean isReviewExists() {
		return reviewExists;
	}

	public void setReviewExists(boolean reviewExists) {
		this.reviewExists = reviewExists;
	}

	public List<ItemReviewDTO> getItemReviewList() {
		return itemReviewList;
	}

	public void setItemReviewList(List<ItemReviewDTO> itemReviewList) {
		this.itemReviewList = itemReviewList;
	}

	public ItemDTO getItemDTO() {
		return itemDTO;
	}


	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}