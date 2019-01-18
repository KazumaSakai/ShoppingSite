package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class MyCartDAO
{
	public static boolean ChangeCartItemQuantity(int item_id, int user_id, int newCount)
	{
		try
		{
			if(newCount <= 0)
			{
				String delete = "DELETE FROM carts WHERE item_id = ? AND user_id = ?";

				PreparedStatement p_delete = DBConnector.connection().prepareStatement(delete);
				p_delete.setInt(1, item_id);
				p_delete.setInt(2, user_id);
				p_delete.executeUpdate();
			}
			else
			{
				String update = "UPDATE carts SET item_count = ? WHERE user_id = ? AND item_id = ?";

				PreparedStatement p_update = DBConnector.connection().prepareStatement(update);
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

	public static boolean AddItemToCart(int item_id, int user_id, int request_quantity)
	{
		try
		{
			String c_select = "SELECT COUNT(*) FROM carts WHERE user_id = ? AND item_id = ?";
			PreparedStatement pc_select = DBConnector.connection().prepareStatement(c_select);
			pc_select.setInt(1, user_id);
			pc_select.setInt(2, item_id);

			ResultSet pc_result = pc_select.executeQuery();
			if(!pc_result.next() || pc_result.getInt("COUNT(*)") == 0)
			{
				String c_insert = "INSERT INTO carts(user_id, item_id, item_count) VALUES(?, ?, ?)";
				PreparedStatement pc_insert = DBConnector.connection().prepareStatement(c_insert);
				pc_insert.setInt(1, user_id);
				pc_insert.setInt(2, item_id);
				pc_insert.setInt(3, request_quantity);
				pc_insert.executeUpdate();

			}
			else
			{
				String c_update = "UPDATE carts SET item_count = item_count + ? WHERE user_id = ? AND item_id = ?";
				PreparedStatement pc_update = DBConnector.connection().prepareStatement(c_update);
				pc_update.setInt(1, request_quantity);
				pc_update.setInt(2, user_id);
				pc_update.setInt(3, item_id);
				pc_update.executeUpdate();

			}

			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}

	public static List<ItemDTO> GetMyCart(int user_id)
	{
		String sql = "SELECT * FROM carts WHERE user_id = ?";
		List<ItemDTO> myCartItemList = new ArrayList<ItemDTO>();

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int item_id = resultSet.getInt("item_id");
				ItemDTO itemDTO = ItemDAO.GetItem(item_id);
				itemDTO.setItem_count(resultSet.getInt("item_count"));

				myCartItemList.add(itemDTO);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return myCartItemList;
	}
}
