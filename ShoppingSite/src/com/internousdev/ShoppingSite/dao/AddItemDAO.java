package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class AddItemDAO
{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public boolean addItemToCart(int item_id, int user_id, int request_count)
	{
		String sql = "SELECT * FROM carts WHERE item_id = ? AND user_id = ?";
		String u_sql = "UPDATE items SET item_count = item_count - "
				+ "CASE WHEN item_count IS NULL OR item_count < ? THEN 0 "
				+ "ELSE ? END "
				+ "WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_id);
			preparedStatement.setInt(2, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) return false;
			int nowCount = resultSet.getInt("item_count");

			if(request_count > nowCount)
			{
				if(nowCount == 0) return false;
				request_count = nowCount;
			}

			PreparedStatement preparedStatement2 = connection.prepareStatement(u_sql);
			preparedStatement2.setInt(1, request_count);
			preparedStatement2.setInt(2, request_count);
			preparedStatement2.setInt(3, item_id);

			ResultSet resultSet2 = preparedStatement2.executeUpdate();
			if(resultSet2.next())
			{
				System.out.println("update");
				String sql2 = "UPDATE carts SET item_count = item_count + ? "
						+ "WHERE item_id = ? AND user_id = ?";
				PreparedStatement preparedStatement3 = connection.prepareStatement(sql2);
				preparedStatement3.setInt(1, request_count);
				preparedStatement3.setInt(2, item_id);
				preparedStatement3.setInt(3, user_id);
				preparedStatement3.executeUpdate();
			}
			else
			{
				System.out.println("insert");
				String sql2 = "INSERT INTO carts(user_id, item_id, item_count) "
						+ "VALUES(?, ?, ?)";
				PreparedStatement preparedStatement3 = connection.prepareStatement(sql2);
				preparedStatement3.setInt(1, user_id);
				preparedStatement3.setInt(2, item_id);
				preparedStatement3.setInt(3, request_count);
				preparedStatement3.executeUpdate();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}
}
