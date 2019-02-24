package com.internousdev.ShoppingSite.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductReviewDTO
{
	private int id;
	private int productId;
	private int userId;
	private String reviewTitle;
	private int reviewPoint;
	private String reviewComment;
	private Date postedDate;
	private Date lastEditDate;
	
	public ProductReviewDTO() {}
	public ProductReviewDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setProductId(resultSet.getInt("productId"));
		this.setUserId(resultSet.getInt("userId"));
		this.setReviewTitle(resultSet.getString("reviewTitle"));
		this.setReviewPoint(resultSet.getInt("reviewPoint"));
		this.setReviewComment(resultSet.getString("reviewComment"));
		this.setPostedDate(resultSet.getDate("postedDate"));
		this.setLastEditDate(resultSet.getDate("lastEditDate"));
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
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
	public Date getPostedDate()
	{
		return postedDate;
	}
	public void setPostedDate(Date postedDate)
	{
		this.postedDate = postedDate;
	}
	public Date getLastEditDate()
	{
		return lastEditDate;
	}
	public void setLastEditDate(Date lastEditDate)
	{
		this.lastEditDate = lastEditDate;
	}
}
