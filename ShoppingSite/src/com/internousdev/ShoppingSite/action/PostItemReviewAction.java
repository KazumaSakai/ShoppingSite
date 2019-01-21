package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemReviewDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class PostItemReviewAction extends ActionSupport implements SessionAware
{
	private int item_id;
	private int point;
	private String comment;
	private String title;

	private Map<String, Object>session;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session)) return "needLogin";

		int user_id = (int)session.get("user_id");

		boolean result = ItemReviewDAO.InsertReview(item_id, user_id, title, point, comment);

		return (result) ? SUCCESS : ERROR;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}