package com.internousdev.ShoppingSite.action.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.DestinationDAO;
import com.internousdev.ShoppingSite.dto.DestinationDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.Pager;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class DestinationListAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 10;

	//	Receive
	private int page;

	//	Send
	private int[] pager;
	private List<DestinationDTO> destinationDTOList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		this.page = Math.max(1, page) - 1;
		
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "DestinationListAction");
			return "needLogin";
		}

		int userId = SessionSafeGetter.getInt(session, "userId");

		this.destinationDTOList = DestinationDAO.SelectListByUserId(page * pageLength, pageLength, userId);
		this.pager = Pager.CreatePager(page, Pager.PageCount(DestinationDAO.Count(userId), pageLength), 7);	

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

	public int[] getPager()
	{
		return pager;
	}

	public void setPager(int[] pager)
	{
		this.pager = pager;
	}
	
	public List<DestinationDTO> getDestinationDTOList()
	{
		return destinationDTOList;
	}

	public void setDestinationDTOList(List<DestinationDTO> destinationDTOList)
	{
		this.destinationDTOList = destinationDTOList;
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
