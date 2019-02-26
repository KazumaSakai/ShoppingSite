package com.internousdev.ShoppingSite.action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminIncrementProductQuantityAction extends ActionSupport implements SessionAware
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
			session.put("LoginedRedirectAction", "ProductListAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		return ProductDAO.IncrementProductQuantity(productId, productQuantity) ? SUCCESS : ERROR;
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
