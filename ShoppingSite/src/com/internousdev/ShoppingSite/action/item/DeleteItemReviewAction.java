package com.internousdev.ShoppingSite.action.item;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemReviewDAO;
import com.internousdev.ShoppingSite.dto.ItemReviewDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteItemReviewAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private int id;
	
	//	Send
	private ItemReviewDTO review;

	//	Session
	private Map<String, Object>session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemPageAction?id=" + review.getItem_id());
			return "needLogin";
		}

		review = ItemReviewDAO.GetReview(id);

		int user_id = SessionSafeGetter.getInt(session, "user_id");
		boolean isMineReview = (review.getUser_id() == user_id);
		
		if(isMineReview || CheckAdmin.IsAdmin(session))
		{
			return (ItemReviewDAO.DeleteReviwe(id)) ? SUCCESS : ERROR;
		}
		
		return ERROR;
	}

	//	Getter Setter
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public ItemReviewDTO getReview()
	{
		return review;
	}
	public void setReview(ItemReviewDTO review)
	{
		this.review = review;
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
