package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;

public class AdminAddItemDAO
{
	public static void addItem(String name, int quantity, int price, int seller, int image_num, String description)
	{
		String sql = "INSERT INTO items(item_name, item_price, item_count, seller, image_num, description) VALUES(?, ?, ?, ?, ?, ?)";

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, price);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setInt(4, seller);
			preparedStatement.setInt(5, image_num);
			preparedStatement.setString(6, description);

			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
