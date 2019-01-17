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

	public boolean addItemToCart(int item_id, int user_id, int request_quantity)
	{
		String select = "SELECT item_count FROM items WHERE id = ? FOR UPDATE";
		String update = "UPDATE items SET item_count = item_count - ? WHERE id = ?";
		String commit = "COMMIT";

		try
		{
			//	SELECT
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

				System.out.println("COMMIT");

				//	UPDATE OR INSERT carts
				String c_select = "SELECT COUNT(*) FROM carts WHERE user_id = ? AND item_id = ?";
				PreparedStatement pc_select = connection.prepareStatement(c_select);
				pc_select.setInt(1, user_id);
				pc_select.setInt(2, item_id);

				ResultSet pc_result = pc_select.executeQuery();
				if(!pc_result.next() || pc_result.getInt("COUNT(*)") == 0)
				{
					String c_insert = "INSERT INTO carts(user_id, item_id, item_count) VALUES(?, ?, ?)";
					PreparedStatement pc_insert = connection.prepareStatement(c_insert);
					pc_insert.setInt(1, user_id);
					pc_insert.setInt(2, item_id);
					pc_insert.setInt(3, request_quantity);
					pc_insert.executeUpdate();

					System.out.println("INSERT carts");
				}
				else
				{
					String c_update = "UPDATE carts SET item_count = item_count + ? WHERE user_id = ? AND item_id = ?";
					PreparedStatement pc_update = connection.prepareStatement(c_update);
					pc_update.setInt(1, request_quantity);
					pc_update.setInt(2, user_id);
					pc_update.setInt(3, item_id);
					pc_update.executeUpdate();

					System.out.println("UPDATE carts");
				}

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
