package com.internousdev.ShoppingSite.action.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.IntChecker;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminInsertProductAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private String productName;
	private int productPrice;
	private int productQuantity;
	private String productDescription;
	private int salesCompanyId;
	private int productionCompanyId;
	private int imageQuantity;

	//	Send
	private List<String> errorMsgList;

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

		//	文字種チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(productName, "商品名", 3, 60, CharType.IgnoreSymbol));
		errorMsgList.addAll(IntChecker.Check(productPrice, "商品価格", "円", 10, 1000000));
		errorMsgList.addAll(IntChecker.Check(productQuantity, "商品数", "個", 0, Integer.MAX_VALUE));
		errorMsgList.addAll(StringChecker.Check(productDescription, "商品詳細", 10, 3000, CharType.IgnoreSymbol));
		errorMsgList.addAll(IntChecker.Check(salesCompanyId, "販売会社ID", "", 0, Integer.MAX_VALUE));
		errorMsgList.addAll(IntChecker.Check(productionCompanyId, "製造会社ID", "", 0, Integer.MAX_VALUE));
		errorMsgList.addAll(IntChecker.Check(imageQuantity, "商品画像数", "枚", 1, 10));

		//	エラーメッセージが存在するならリターン
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		//	商品を追加
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(productName);
		productDTO.setProductPrice(productPrice);
		productDTO.setProductQuantity(productQuantity);
		productDTO.setProductDescription(productDescription);
		productDTO.setSalesCompanyId(salesCompanyId);
		productDTO.setProductionCompanyId(productionCompanyId);
		productDTO.setImageQuantity(imageQuantity);

		if(ProductDAO.Insert(productDTO))
		{
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("商品の登録に失敗しました");
			return ERROR;
		}
	}

	//	 Getter Setter
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

	public int getProductQuantity()
	{
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity)
	{
		this.productQuantity = productQuantity;
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
