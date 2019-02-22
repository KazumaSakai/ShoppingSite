package com.internousdev.ShoppingSite.action.cart;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeCartItemQuantityAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private int item_id;
	private int newQuantity;
	private boolean toCart;

	//	Session
	private Map<String, Object> session;
	
	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "MyCartAction");
			return "needLogin";
		}

		int user_id = (int)session.get("user_id");

		//	カートの中にある商品の数を変更する
		if(MyCartDAO.ChangeCartItemQuantity(item_id, user_id, newQuantity))
		{
			return toCart ? "toCart" : "toItemList";
		}
		else
		{
			return ERROR;
		}
	}

	//	Getter Setter
	public int getNewQuantity() {
		return newQuantity;
	}
	public void setNewQuantity(int newQuantity) {
		this.newQuantity = Math.max(0, newQuantity);
	}

	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


	public boolean isToCart() {
		return toCart;
	}
	public void setToCart(boolean toCart) {
		this.toCart = toCart;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
