package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class DeleteItemDAO
{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public boolean deleteCartItem(int item_id, int user_id, int newCount)
	{
		try
		{
			if(newCount <= 0)
			{
				String delete = "DELETE FROM carts WHERE item_id = ? AND user_id = ?";

				PreparedStatement p_delete = connection.prepareStatement(delete);
				p_delete.setInt(1, item_id);
				p_delete.setInt(2, user_id);
				p_delete.executeUpdate();
			}
			else
			{
				String update = "UPDATE carts SET item_count = ? WHERE user_id = ? AND item_id = ?";

				PreparedStatement p_update = connection.prepareStatement(update);
				p_update.setInt(1, newCount);
				p_update.setInt(2, user_id);
				p_update.setInt(3, item_id);
				p_update.executeUpdate();
			}
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}
}
