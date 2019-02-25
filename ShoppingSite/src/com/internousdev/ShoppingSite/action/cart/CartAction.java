package com.internousdev.ShoppingSite.action.cart;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.CartDAO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 50;

	//	Receive
	private int page;

	//	Send
	private List<ProductDTO> productDTOList;
	private int totalPrice;

	//	Sesiion
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

		this.productDTOList = CartDAO.SelectProductListByUserId(page * pageLength, pageLength, userId);
		this.totalPrice = CartDAO.SumPrice(userId);

		return SUCCESS;
	}

	//	Getter Setter
	public int getPage()
	{
		return page;
	}
	public void setPage(int page)
	{
		this.page = page;
	}
	public List<ProductDTO> getProductDTOList()
	{
		return productDTOList;
	}
	public void setProductDTOList(List<ProductDTO> productDTOList)
	{
		this.productDTOList = productDTOList;
	}
	public int getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
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
