package com.internousdev.ShoppingSite.action.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.IntChecker;
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

	//	Sned
	private List<String> successMsgList;
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "AdminProductInfoAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(IntChecker.Check(productId, "商品ID", "", 1, Integer.MAX_VALUE));
		errorMsgList.addAll(IntChecker.Check(productPrice, "商品価格", "", 10, 1000000));
		errorMsgList.addAll(IntChecker.Check(salesCompanyId, "販売会社", "", 1, Integer.MAX_VALUE));
		errorMsgList.addAll(IntChecker.Check(productionCompanyId, "製造会社ID", "", 1, Integer.MAX_VALUE));
		errorMsgList.addAll(IntChecker.Check(imageQuantity, "商品画像数", "毎", 1, 10));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productId);
		productDTO.setProductName(productName);
		productDTO.setProductPrice(productPrice);
		productDTO.setProductDescription(productDescription);
		productDTO.setSalesCompanyId(salesCompanyId);
		productDTO.setProductionCompanyId(productionCompanyId);
		productDTO.setImageQuantity(imageQuantity);

		if(ProductDAO.Update(productDTO))
		{
			successMsgList = new ArrayList<String>();
			successMsgList.add("商品情報を更新しました。");
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("商品情報を更新することに失敗しました。");
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
	public List<String> getSuccessMsgList()
	{
		return successMsgList;
	}
	public void setSuccessMsgList(List<String> successMsgList)
	{
		this.successMsgList = successMsgList;
	}
	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}
	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
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
