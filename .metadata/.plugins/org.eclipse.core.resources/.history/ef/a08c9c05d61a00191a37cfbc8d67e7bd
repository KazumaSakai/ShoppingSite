package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.ItemDescriptionDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ItemDescriptionDAO
{
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO();

	public ItemDescriptionDTO getItem(int item_id)
	{
		 String sql = "SELECT * FROM description WHERE id = ?";

		 try
		 {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, item_id);

			 ResultSet resultSet = preparedStatement.executeQuery();

			 if(resultSet.next())
			 {
				 itemDescriptionDTO.setId(resultSet.getInt("id"));
				 itemDescriptionDTO.setDescription(resultSet.getString("description"));
				 itemDescriptionDTO.setSeller(resultSet.getInt("seller"));
				 itemDescriptionDTO.setImage_num(resultSet.getInt("image_num"));
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

		 return itemDescriptionDTO;
	}
}
