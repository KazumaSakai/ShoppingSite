package com.internousdev.ShoppingSite.action.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemReviewDAO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.IntChecker;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class PostItemReviewAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private int id;
	private int point;
	private String comment;
	private String title;

	//	Send
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object>session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemPageAction?id=" + id);
			return "needLogin";
		}

		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(IntChecker.Check(point, "レビューポイント", "点", 0, 5));
		errorMsgList.addAll(StringChecker.Check(comment, "レビューコメント", 6, 2000, CharType.IgnoreSymbol));
		errorMsgList.addAll(StringChecker.Check(title, "レビュータイトル", 4, 60, CharType.IgnoreSymbol));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		int user_id = SessionSafeGetter.getInt(session, "user_id");
		if(ItemReviewDAO.InsertReview(id, user_id, title, point, comment))
		{
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("レビューの投稿に失敗しました。再度送信してください。");
			return ERROR;
		}
	}

	//	Getter Setter
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getPoint()
	{
		return point;
	}
	public void setPoint(int point)
	{
		this.point = point;
	}

	public String getComment()
	{
		return comment;
	}
	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
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
