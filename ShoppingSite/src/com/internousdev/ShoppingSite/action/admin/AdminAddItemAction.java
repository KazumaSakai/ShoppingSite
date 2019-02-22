package com.internousdev.ShoppingSite.action.admin;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.IntChecker;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAddItemAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private String name;
	private String description;
	private int price;
	private int quantity;
	private int seller;
	private int image_num;

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
			session.put("LoginedRedirectAction", "ItemListAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		//	文字種チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(name, "商品名", 3, 60, CharType.IgnoreSymbol));
		errorMsgList.addAll(StringChecker.Check(name, "商品詳細", 10, 3000, CharType.IgnoreSymbol));
		errorMsgList.addAll(IntChecker.Check(price, "商品価格", "円", 10, 1000000));
		errorMsgList.addAll(IntChecker.Check(quantity, "商品数", "個", 0, Integer.MAX_VALUE));
		errorMsgList.addAll(IntChecker.Check(seller, "販売会社ID", "", 0, Integer.MAX_VALUE));
		errorMsgList.addAll(IntChecker.Check(quantity, "商品画像数", "枚", 1, 10));

		//	エラーメッセージが存在するならリターン
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		//	商品を追加
		if(ItemDAO.AddItem(quantity, price, name, description, seller, image_num))
		{
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("商品の登録に失敗しました");
			return ERROR;
		}
	}

	//	 Getter + Setter
	public int getSeller()
	{
		return seller;
	}
	public void setSeller(int seller)
	{
		this.seller = seller;
	}
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public int getImage_num()
	{
		return image_num;
	}
	public void setImage_num(int image_num)
	{
		this.image_num = image_num;
	}
	
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
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
