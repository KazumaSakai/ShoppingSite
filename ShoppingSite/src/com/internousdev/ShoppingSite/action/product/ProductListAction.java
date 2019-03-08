package com.internousdev.ShoppingSite.action.product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.Pager;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 20;

	//	Receive
	private boolean andSearch;
	private String searchWords;
	private int page;

	//	Send
	private List<ProductDTO> productDTOList;
	private List<String> errorMsgList;
	private int[] pager;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		page = Math.max(1, page) - 1;
		
		//	検索指定がない場合
		if(searchWords == null || searchWords.isEmpty())
		{
			this.productDTOList = ProductDAO.SelectList(page * pageLength, pageLength);
			this.pager = Pager.CreatePager(page, Pager.PageCount(ProductDAO.Count(), pageLength), 7);
			
			return SUCCESS;
		}

		//	検索ワードに記号が含まれていないかチェック
		this.errorMsgList = StringChecker.Check(searchWords, "検索ワード", 0, 100, CharType.IgnoreSymbol);
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		//	検索指定の文字列をリストにして、DBからデータを得る
		List<String> seachList = Arrays.asList(searchWords.replaceAll("　", " ").split(" "));
		this.productDTOList = ProductDAO.SearchListByProductName(page * pageLength, pageLength, seachList, andSearch);
		this.pager = Pager.CreatePager(page, Pager.PageCount(ProductDAO.Count(seachList, andSearch), pageLength), 7);

		return SUCCESS;
	}

	//	Getter Setter
	public boolean isAndSearch()
	{
		return andSearch;
	}

	public void setAndSearch(boolean andSearch)
	{
		this.andSearch = andSearch;
	}

	public String getSearchWords()
	{
		return searchWords;
	}

	public void setSearchWords(String searchWords)
	{
		this.searchWords = searchWords;
	}

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

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}

	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}

	public int[] getPager()
	{
		return pager;
	}
	public void setPager(int[] pager)
	{
		this.pager = pager;
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
