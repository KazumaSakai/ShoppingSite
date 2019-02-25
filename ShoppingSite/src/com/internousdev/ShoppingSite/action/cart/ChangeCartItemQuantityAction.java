package com.internousdev.ShoppingSite.action.cart;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.CartDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeCartItemQuantityAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int productId;
	private int productQuantity;
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

		int userId = SessionSafeGetter.getInt(session, "user_id");

		//	カートの中にある商品の数を変更する
		if(CartDAO.IncrementProductQuantity(userId, productId, productQuantity))
		{
			return toCart ? "toCart" : "toItemList";
		}
		else
		{
			return ERROR;
		}
	}

	//	Getter Setter
	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public int getProductQuantity()
	{
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity)
	{
		this.productQuantity = productQuantity;
	}

	public boolean isToCart()
	{
		return toCart;
	}

	public void setToCart(boolean toCart)
	{
		this.toCart = toCart;
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
