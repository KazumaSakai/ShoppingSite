package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class BuyItemDAO
{
	private Connection connection;
	public BuyItemDAO()
	{
		this.connection = DBConnector.getConnection();
	}
	
	public boolean buyItem(ItemDTO item, int user_id)
	{
		return BuyItemDAO.BuyItem(connection, item, user_id);
	}
	public static boolean BuyItem(ItemDTO item, int user_id)
	{
		return BuyItemDAO.BuyItem(DBConnector.getConnection(), item, user_id);
	}
	public static boolean BuyItem(Connection connection, ItemDTO item, int user_id)
	{
		return BuyItemDAO.BuyItem(connection, item.getItem_id(), user_id, item.getItem_count());
	}
	
	public boolean buyItem(int item_id, int user_id, int request_quantity)
	{
		return BuyItem(connection, item_id, user_id, request_quantity);
	}
	public static boolean BuyItem(int item_id, int user_id, int request_quantity)
	{
		return BuyItem(DBConnector.getConnection(), item_id, user_id, request_quantity);
	}
	public static boolean BuyItem(Connection connection, int item_id, int user_id, int request_quantity)
	{
		String select = "SELECT item_count FROM items WHERE id = ? FOR UPDATE";
		String update = "UPDATE items SET item_count = item_count - ? WHERE id = ?";
		String commit = "COMMIT";

		try
		{
			PreparedStatement p_select = connection.prepareStatement(select);
			p_select.setInt(1, item_id);

			ResultSet resultSet = p_select.executeQuery();
			if (resultSet.next())
			{
				int item_quantity = resultSet.getInt("item_count");
				request_quantity = Math.min(item_quantity, request_quantity);

				// UPDATE
				PreparedStatement p_update = connection.prepareStatement(update);
				p_update.setInt(1, request_quantity);
				p_update.setInt(2, item_id);
				p_update.executeUpdate();

				// COMMIT
				PreparedStatement p_commit = connection.prepareStatement(commit);
				p_commit.executeUpdate();

				MyCartDAO.ChangeCartItemQuantity(item_id, user_id, 0);

				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}
}
