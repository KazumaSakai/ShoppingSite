package com.internousdev.ShoppingSite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ItemReviewDAO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class PostItemReviewAction extends ActionSupport implements SessionAware
{
	private int id;
	private int point;
	private String comment;
	private String title;
	
	private String errorMsg;

	private Map<String, Object>session;

	public String execute()
	{
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ItemPageAction?id=" + id);
			return "needLogin";
		}
		
		int user_id = SessionSafeGetter.getInt(session, "user_id");
		
		//	入力値チェック
		errorMsg = "";
		
		//	ポイント
		if(point < 0)
		{
			errorMsg += "レビューポイントは、0以上でなければなりません。<br/>";
		}
		else if(point > 5)
		{
			errorMsg += "レビューポイントは、5以下でなければなりません。<br/>";
		}
		
		//	コメント
		if(comment.length() < 6)
		{
			errorMsg += "レビューコメントは、6文字以上でなければなりません。<br/>";
		}
		else if(comment.length() > 2000)
		{
			errorMsg += "レビューコメントは、2000文字以下でなければなりません。<br/>";
		}
		if(StringChecker.IsSafeString(comment))
		{
			errorMsg += "レビューコメントに、不正な文字列が含まれています。<br/>";
		}
		
		//	タイトル
		if(title.length() < 4)
		{
			errorMsg += "レビュータイトルは、4文字以上でなければなりません。<br/>";
		}
		else if(title.length() > 60)
		{
			errorMsg += "レビュータイトルは、60文字以下でなければなりません。<br/>";
		}
		if(StringChecker.IsSafeString(title))
		{
			errorMsg += "レビュータイトルに、不正な文字列が含まれています。<br/>";
		}
		
		//	エラーがあればリターン
		if(errorMsg.equals(""))
		{
			return ERROR;
		}
		
		
		
		boolean result = ItemReviewDAO.InsertReview(id, user_id, title, point, comment);
		
		if(result)
		{
			return SUCCESS;
		}
		else
		{
			errorMsg += "レビューの投稿に失敗しました。再度送信してください。<br/>";
			return ERROR;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
