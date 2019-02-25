package com.internousdev.ShoppingSite.action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUpdateProductAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int productId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int salesCompanyId;
	private int productionCompanyId;
	private int imageQuantity;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "AdminUpdateItemInfoAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		//	TODO : 入力値チェック

		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productId);
		productDTO.setProductName(productName);
		productDTO.setProductPrice(productPrice);
		productDTO.setProductDescription(productDescription);
		productDTO.setSalesCompanyId(salesCompanyId);
		productDTO.setProductionCompanyId(productionCompanyId);
		productDTO.setImageQuantity(imageQuantity);

		return ProductDAO.Update(productDTO) ? SUCCESS : ERROR;
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
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public int getProductPrice()
	{
		return productPrice;
	}
	public void setProductPrice(int productPrice)
	{
		this.productPrice = productPrice;
	}
	public String getProductDescription()
	{
		return productDescription;
	}
	public void setProductDescription(String productDescription)
	{
		this.productDescription = productDescription;
	}
	public int getSalesCompanyId()
	{
		return salesCompanyId;
	}
	public void setSalesCompanyId(int salesCompanyId)
	{
		this.salesCompanyId = salesCompanyId;
	}
	public int getProductionCompanyId()
	{
		return productionCompanyId;
	}
	public void setProductionCompanyId(int productionCompanyId)
	{
		this.productionCompanyId = productionCompanyId;
	}
	public int getImageQuantity()
	{
		return imageQuantity;
	}
	public void setImageQuantity(int imageQuantity)
	{
		this.imageQuantity = imageQuantity;
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
