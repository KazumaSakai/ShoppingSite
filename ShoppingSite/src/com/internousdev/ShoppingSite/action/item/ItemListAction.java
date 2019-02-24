package com.internousdev.ShoppingSite.action.item;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemDAO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private boolean andSearch;
	private String searchWords;
	
	//	Send
	private List<ItemDTO> itemList;
	private List<String> errorMsgList;
	
	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	検索指定がある場合
		if(searchWords == null || searchWords.isEmpty())
		{
			itemList = ItemDAO.GetItemList();
			return SUCCESS;
		}
		
		//	検索ワードに記号が含まれていないかチェック
		errorMsgList = StringChecker.Check(searchWords, "検索ワード", 0, 100, CharType.IgnoreSymbol);
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}
		
		//	検索指定の文字列をリストにして、DBからデータを得る
		List<String> seachList = Arrays.asList(searchWords.replaceAll("　", " ").split(" "));
		itemList = ItemDAO.SearchItemList(seachList, andSearch);

		return SUCCESS;
	}

	//	Getter Setter
	public List<ItemDTO> getItemList()
	{
		return itemList;
	}
	public void setItemList(List<ItemDTO> itemList)
	{
		this.itemList = itemList;
	}

	public String getSearchWords()
	{
		return searchWords;
	}
	public void setSearchWords(String searchWords)
	{
		this.searchWords = searchWords;
	}

	public boolean getAndSearch()
	{
		return andSearch;
	}
	public void setAndSearch(boolean andSearch)
	{
		this.andSearch = andSearch;
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
