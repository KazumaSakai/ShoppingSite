package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemReviewDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ItemReviewDAO
{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private List<ItemReviewDTO> itemReviewDTOList = new ArrayList<ItemReviewDTO>();

	public List<ItemReviewDTO> getItem(int item_id)
	{
		 String sql = "SELECT * FROM item_review WHERE item_id = ?";

		 try
		 {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, item_id);

			 ResultSet resultSet = preparedStatement.executeQuery();

			 while (resultSet.next())
			 {
				 ItemReviewDTO itemReviewDTO = new ItemReviewDTO();

				 itemReviewDTO.setItem_id(resultSet.getInt("item_id"));
				 itemReviewDTO.setUser_id(resultSet.getInt("user_id"));
				 itemReviewDTO.setPoint(resultSet.getInt("point"));
				 itemReviewDTO.setComment(resultSet.getString("comment"));
				 itemReviewDTO.setTitle(resultSet.getString("title"));
				 itemReviewDTO.setInsert_date(resultSet.getString("insert_date"));
				 itemReviewDTO.setUsername(UserNameDAO.getUserName(itemReviewDTO.getUser_id()));

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
