package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUpdateItemAction extends ActionSupport implements SessionAware
{
	private int id;
	private String item_name;
	private int item_price;
	private int item_quantity;
	private String description;
	private int seller;
	private int image_num;
	
	private Map<String, Object> session;
	
	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemPageAction?id=" + id);
			return "needLogin";
		}
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}
		
		boolean result = ItemDAO.UpdateItem(id, item_name, item_price, item_quantity, description, seller, image_num);
		return result ? SUCCESS : ERROR;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}

	public int getImage_num() {
		return image_num;
	}

	public void setImage_num(int image_num) {
		this.image_num = image_num;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
