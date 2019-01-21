package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemReviewDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class ItemReviewDAO
{
	public static boolean DeleteReviwe(int review_id)
	{
		String sql = "DELETE FROM item_review WHERE id = ?";

		int returnLine = 0;

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, review_id);

			returnLine = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return (returnLine == 1);
	}
	public static int GetUserId(int review_id)
	{
		String sql = "SELECT user_id FROM item_review WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, review_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return resultSet.getInt("user_id");
			}
			return 0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return 0;
	}
	public static boolean InsertReview(int item_id, int user_id, String title, int point, String comment)
	{
		String sql = "INSERT INTO item_review(item_id, user_id, title, point, comment) "
				+ "VALUES(?, ?, ?, ?, ?)";

		int returnLine = 0;

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, item_id);
			preparedStatement.setInt(2, user_id);
			preparedStatement.setString(3, title);
			preparedStatement.setInt(4, point);
			preparedStatement.setString(5, comment);

			returnLine = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return (returnLine == 1);
	}

	public List<ItemReviewDTO> getItem(int item_id)
	{
		 String sql = "SELECT * FROM item_review WHERE item_id = ?";
		 List<ItemReviewDTO> itemReviewDTOList = new ArrayList<ItemReviewDTO>();

		 try
		 {
			 PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			 preparedStatement.setInt(1, item_id);

			 ResultSet resultSet = preparedStatement.executeQuery();

			 while (resultSet.next())
			 {
				 ItemReviewDTO itemReviewDTO = new ItemReviewDTO();

				 itemReviewDTO.setId(resultSet.getInt("id"));
				 itemReviewDTO.setItem_id(resultSet.getInt("item_id"));
				 itemReviewDTO.setUser_id(resultSet.getInt("user_id"));
				 itemReviewDTO.setPoint(resultSet.getInt("point"));
				 itemReviewDTO.setComment(resultSet.getString("comment"));
				 itemReviewDTO.setTitle(resultSet.getString("title"));
				 itemReviewDTO.setInsert_date(resultSet.getString("insert_date"));
				 itemReviewDTO.setUsername(UserDAO.GetUserName(itemReviewDTO.getUser_id()));

				 itemReviewDTOList.add(itemReviewDTO);
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

		 return itemReviewDTOList;
	}
}