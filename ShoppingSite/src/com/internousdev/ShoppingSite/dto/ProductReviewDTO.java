package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.util.DateConverter;

public class ProductReviewDTO
{
	private int id;
	private int productId;
	private ProductDTO productDTO;
	private int userId;
	private UserDTO userDTO;
	private String reviewTitle;
	private int reviewPoint;
	private String reviewComment;
	private LocalDateTime postedDate;
	private LocalDateTime lastEditDate;

	public ProductReviewDTO() {}
	public ProductReviewDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setProductId(resultSet.getInt("productId"));
		this.setUserId(resultSet.getInt("userId"));
		this.setReviewTitle(resultSet.getString("reviewTitle"));
		this.setReviewPoint(resultSet.getInt("reviewPoint"));
		this.setReviewComment(resultSet.getString("reviewComment"));
		this.setPostedDate(resultSet.getString("postedDate"));
		this.setLastEditDate(resultSet.getString("lastEditDate"));
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
	public String getReviewCommentHTML()
	{
		return reviewComment.replace("\n", "<br/>");
	}

	public LocalDateTime getPostedDate()
	{
		return postedDate;
	}
	public String getPostedDateFormat()
	{
		return DateConverter.toFormat(postedDate);
	}
	public void setPostedDate(LocalDateTime postedDate)
	{
		this.postedDate = postedDate;
	}
	public void setPostedDate(String postedDate)
	{
		this.postedDate = DateConverter.toLocalDateTime(postedDate);
	}

	public LocalDateTime getLastEditDate()
	{
		return lastEditDate;
	}
	public String getLastEditDateFormat()
	{
		return DateConverter.toFormat(lastEditDate);
	}
	public void setLastEditDate(LocalDateTime lastEditDate)
	{
		this.lastEditDate = lastEditDate;
	}
	public void setLastEditDate(String lastEditDate)
	{
		this.lastEditDate = DateConverter.toLocalDateTime(lastEditDate);
	}
	public ProductDTO getProductDTO()
	{
		if(productDTO == null || productDTO.getId() == productId)
		{
			productDTO = ProductDAO.Select(productId);
		}
		return productDTO;
	}
	public UserDTO getUserDTO()
	{
		if(userDTO == null || userDTO.getId() == userId)
		{
			userDTO = UserDAO.SelectById(userId);
		}
		return userDTO;
	}
}
