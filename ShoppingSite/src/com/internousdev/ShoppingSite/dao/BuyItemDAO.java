package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class BuyItemDAO
{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public boolean buyItem(int item_id, int user_id, int request_quantity)
	{
		String select = "SELECT item_count FROM items WHERE id = ? FOR UPDATE";
		String update = "UPDATE items SET item_count = item_count - ? WHERE id = ?";
		String commit = "COMMIT";

		try
		{
			PreparedStatement p_select = connection.prepareStatement(select);
			p_select.setInt(1, item_id);

			ResultSet resultSet = p_select.executeQuery();
			if(resultSet.next())
			{
				int item_quantity = resultSet.getInt("item_count");
				if(item_quantity < request_quantity)
				{
					request_quantity = item_quantity;
				}

				//	UPDATE
				PreparedStatement p_update = connection.prepareStatement(update);
				p_update.setInt(1, request_quantity);
				p_update.setInt(2, item_id);
				p_update.executeUpdate();

				//	COMMIT
				PreparedStatement p_commit = connection.prepareStatement(commit);
				p_commit.executeUpdate();

				DeleteItemDAO deleteItemDAO = new DeleteItemDAO();
				deleteItemDAO.deleteCartItem(item_id, user_id, 0);

				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}
}
