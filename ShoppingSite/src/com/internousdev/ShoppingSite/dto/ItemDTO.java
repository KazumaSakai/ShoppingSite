package com.internousdev.ShoppingSite.dto;

import com.internousdev.ShoppingSite.dao.BuyItemDAO;

public class ItemDTO
{
	private int item_id;
	private String item_name;
	private int item_price;
	private int item_count;
	private String description;
	private SellerDTO seller;
	private int image_num;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SellerDTO getSeller() {
		return seller;
	}

	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}

	public int getImage_num() {
		return image_num;
	}

	public void setImage_num(int image_num) {
		this.image_num = image_num;
	}
	private String insert_date;
	private String last_add_date;
	private String last_sell_date;

	public boolean buyItem(int user_id)
	{
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		return buyItemDAO.buyItem(item_id, user_id, item_count);
	}

	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getLast_add_date() {
		return last_add_date;
	}
	public void setLast_add_date(String last_add_date) {
		this.last_add_date = last_add_date;
	}
	public String getLast_sell_date() {
		return last_sell_date;
	}
	public void setLast_sell_date(String last_sell_date) {
		this.last_sell_date = last_sell_date;
	}
}
