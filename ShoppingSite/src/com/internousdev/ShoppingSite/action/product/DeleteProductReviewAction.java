package com.internousdev.ShoppingSite.action.product;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductReviewDAO;
import com.internousdev.ShoppingSite.dto.ProductReviewDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductReviewAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int productReviewId;

	//	Send
	private int productId;
	private ProductReviewDTO productReviewDTO;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		productReviewDTO = ProductReviewDAO.Select(productReviewId);
		if(productReviewDTO == null)
		{
			return ERROR;
		}

		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ProductPageAction");
			return "needLogin";
		}

		int userId = SessionSafeGetter.getInt(session, "userId");
		this.productId = productReviewDTO.getProductId();
		boolean isMineReview = (productReviewDTO.getUserId() == userId);

		if(isMineReview || CheckAdmin.IsAdmin(session))
		{
			return (ProductReviewDAO.Delete(productReviewId)) ? SUCCESS : ERROR;
		}

		return ERROR;
	}

	public int getProductReviewId()
	{
		return productReviewId;
	}

	public void setProductReviewId(int productReviewId)
	{
		this.productReviewId = productReviewId;
	}

	public ProductReviewDTO getProductReviewDTO()
	{
		return productReviewDTO;
	}

	public void setProductReviewDTO(ProductReviewDTO productReviewDTO)
	{
		this.productReviewDTO = productReviewDTO;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
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
