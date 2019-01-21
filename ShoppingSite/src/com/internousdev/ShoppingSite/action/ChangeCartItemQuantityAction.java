package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeCartItemQuantityAction extends ActionSupport implements SessionAware
{
	private int item_id;
	private int newQuantity;
	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "needLogin";

		int user_id = (int)session.get("user_id");
		if(newQuantity <= 0) newQuantity = 0;

		boolean result = MyCartDAO.ChangeCartItemQuantity(item_id, user_id, newQuantity);

		return result ? SUCCESS : ERROR;
	}

	public int getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}