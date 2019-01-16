package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.dto.ItemListDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class MyCartDAO
{
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private ItemListDTO myCartDTO = new ItemListDTO();

	public ItemListDTO getMyCart(int user_id)
	{
		String sql = "SELECT * FROM carts WHERE user_id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int item_id = resultSet.getInt("item_id");
				ItemDAO itemDAO = new ItemDAO();
				ItemDTO itemDTO = itemDAO.getItem(item_id);
				itemDAO = null;

				myCartDTO.getCartItemList().add(itemDTO);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return myCartDTO;
	}
}
