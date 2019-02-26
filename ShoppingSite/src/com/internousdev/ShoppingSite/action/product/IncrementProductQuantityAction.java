package com.internousdev.ShoppingSite.action.product;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.CartDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class IncrementProductQuantityAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int productId;
	private int productQuantity;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "IncrementProductQuantityAction");
			return "needLogin";
		}

		productQuantity = Math.max(1, productQuantity);
		int userId = SessionSafeGetter.getInt(session, "userId");

		return CartDAO.IncrementProductQuantity(userId, productId, productQuantity) ? SUCCESS : ERROR;
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
