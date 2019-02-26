package com.internousdev.ShoppingSite.action.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.DestinationDAO;
import com.internousdev.ShoppingSite.dto.DestinationDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class DestinationListAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 50;

	//	Receive
	private int destinationPage;

	//	Send
	private List<DestinationDTO> destinationDTOList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoUserPageAction");
			return "needLogin";
		}

		int userId = SessionSafeGetter.getInt(session, "userId");

		this.destinationDTOList = DestinationDAO.SelectListByUserId(destinationPage * pageLength, pageLength, userId);

		return SUCCESS;
	}

	//	Getter Setter
	public int getDestinationPage()
	{
		return destinationPage;
	}

	public void setDestinationPage(int destinationPage)
	{
		this.destinationPage = destinationPage;
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
