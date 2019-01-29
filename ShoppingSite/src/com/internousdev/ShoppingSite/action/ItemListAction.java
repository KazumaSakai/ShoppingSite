package com.internousdev.ShoppingSite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware
{
	private String searchWords;
	private Map<String, Object> session;
	private List<ItemDTO> itemList;

	public String execute()
	{
		String result = SUCCESS;

		
		//	検索指定がある場合
		if(searchWords != null && !searchWords.equals(""))
		{
			//	検索指定の文字列をリストにして、DAOからデータを得る
			List<String> seachList = new ArrayList<String>();
			searchWords = searchWords.replaceAll("　", " ");
			for (String string : searchWords.split(" "))
			{
				seachList.add(string);
			}
			itemList = ItemDAO.GetItemList(seachList, true);
		}
		//	検索指定がなければ、条件を指定しない
		else
		{
			itemList = ItemDAO.GetItemList();
		}

		//	ログインしているならば、カートに入っている量も得る
		if(CheckLogin.IsLogin(session))
		{
			int user_id = (int)session.get("user_id");
			for (ItemDTO itemDTO : itemList)
			{
				itemDTO.setMyCart_quantity(MyCartDAO.MyCartItemQuantity(user_id, itemDTO.getItem_id()));
			}
		}
		
		return result;
	}

	public List<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}
}
