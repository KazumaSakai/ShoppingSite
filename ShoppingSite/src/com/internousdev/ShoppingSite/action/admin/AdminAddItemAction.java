package com.internousdev.ShoppingSite.action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAddItemAction extends ActionSupport implements SessionAware
{
	private String name;
	private int quantity;
	private int price;
	private int seller;
	private String description;
	private int image_num;

	private String errorMsg;

	private Map<String, Object> session;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemListAction");
			return "needLogin";
		}
		if(!CheckAdmin.IsAdmin(session)) return "notAdmin";


		//	入力値チェック
		errorMsg = "";

		//	商品名
		if(name.length() < 3)
		{
			errorMsg += "商品名は、3文字以上でなければなりません。<br/>";
		}
		else if(name.length() > 60)
		{
			errorMsg += "商品名は、60文字以下でなければなりません。<br/>";
		}
		if(!StringChecker.IsSafeString(name))
		{
			errorMsg += "商品名に、不正な文字列が含まれています。<br/>";
		}

		//	商品価格
		if(quantity < 10)
		{
			errorMsg += "商品価格は、10円以上でなければなりません。<br/>";
		}

		//	商品詳細
		if(description.length() < 10)
		{
			errorMsg += "商品詳細は、10文字以上でなければなりません。<br/>";
		}
		else if(description.length() > 3000)
		{
			errorMsg += "商品詳細は、3000文字以下でなければなりません。<br/>";
		}
		if(!StringChecker.IsSafeString(description))
		{
			errorMsg += "商品詳細に、不正な文字列が含まれています。<br />";
		}

		//	商品数
		if(quantity < 0)
		{
			quantity = 0;
		}

		//	商品画像数
		if(image_num < 0)
		{
			errorMsg += "商品画像数は、0枚以上でなければなりません。<br/>";
		}
		else if(image_num > 10)
		{
			errorMsg += "商品画像数は、10枚以下でなければなりません。<br/>";
		}

		//	エラーメッセージが存在するならリターン
		if(!errorMsg.equals(""))
		{
			return ERROR;
		}

		if(ItemDAO.AddItem(quantity, price, name, description, seller, image_num))
		{
			return SUCCESS;
		}
		else
		{
			errorMsg += "商品の登録に失敗しました<br/>";
			return ERROR;
		}
	}



	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getImage_num() {
		return image_num;
	}

	public void setImage_num(int image_num) {
		this.image_num = image_num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}