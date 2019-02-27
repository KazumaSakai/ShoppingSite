package com.internousdev.ShoppingSite.action.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductReviewDAO;
import com.internousdev.ShoppingSite.dto.ProductReviewDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.IntChecker;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class PostProductReviewAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int productId;
	private String reviewTitle;
	private int reviewPoint;
	private String reviewComment;

	//	Send
	private ProductReviewDTO productReviewDTO;
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ProductListAction");
			return "needLogin";
		}

		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(reviewTitle, "レビュータイトル", 4, 60, CharType.IgnoreSymbol));
		errorMsgList.addAll(IntChecker.Check(reviewPoint, "レビューポイント", "点", 0, 5));
		errorMsgList.addAll(StringChecker.Check(reviewComment, "レビューコメント", 6, 2000, CharType.IgnoreSymbol));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		int userId = SessionSafeGetter.getInt(session, "userId");
		productReviewDTO = new ProductReviewDTO();
		productReviewDTO.setProductId(productId);
		productReviewDTO.setUserId(userId);
		productReviewDTO.setReviewTitle(reviewTitle);
		productReviewDTO.setReviewPoint(reviewPoint);
		productReviewDTO.setReviewComment(reviewComment);

		if(ProductReviewDAO.Insert(productReviewDTO))
		{
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("レビューの投稿に失敗しました。再度送信してください。");
			return ERROR;
		}
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getReviewTitle()
	{
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle)
	{
		this.reviewTitle = reviewTitle;
	}

	public int getReviewPoint()
	{
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint)
	{
		this.reviewPoint = reviewPoint;
	}

	public String getReviewComment()
	{
		return reviewComment;
	}

	public void setReviewComment(String reviewComment)
	{
		this.reviewComment = reviewComment;
	}

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}

	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}

	public ProductReviewDTO getProductReviewDTO()
	{
		return productReviewDTO;
	}

	public void setProductReviewDTO(ProductReviewDTO productReviewDTO)
	{
		this.productReviewDTO = productReviewDTO;
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
