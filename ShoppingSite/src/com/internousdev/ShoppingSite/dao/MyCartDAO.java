package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class MyCartDAO extends DAO
{
	public int myCartItemQuantity(int user_id, int item_id)
	{
		return MyCartItemQuantity(connection, user_id, item_id);
	}
	public static int MyCartItemQuantity(int user_id, int item_id)
	{
		Connection connection = DBConnector.getConnection();
		int result = MyCartItemQuantity(connection, user_id, item_id);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static int MyCartItemQuantity(Connection connection, int user_id, int item_id)
	{
		String sql = "SELECT item_count FROM carts WHERE user_id = ? AND item_id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2, item_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				return resultSet.getInt("item_count");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return 0;
	}

	public boolean changeCartItemQuantity(int item_id, int user_id, int newCount)
	{
		return ChangeCartItemQuantity(connection, item_id, user_id, newCount);
	}
	public static boolean ChangeCartItemQuantity(int item_id, int user_id, int newCount)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = ChangeCartItemQuantity(connection, item_id, user_id, newCount);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static boolean ChangeCartItemQuantity(Connection connection, int item_id, int user_id, int newCount)
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
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return false;
	}

	public boolean addItemToCart(int item_id, int user_id, int request_quantity)
	{
		return AddItemToCart(connection, item_id, user_id, request_quantity);
	}
	public static boolean AddItemToCart(int item_id, int user_id, int request_quantity)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = AddItemToCart(connection, item_id, user_id, request_quantity);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static boolean AddItemToCart(Connection connection, int item_id, int user_id, int request_quantity)
	{
		try
		{
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

			}
			else
			{
				String c_update = "UPDATE carts SET item_count = item_count + ? WHERE user_id = ? AND item_id = ?";
				PreparedStatement pc_update = connection.prepareStatement(c_update);
				pc_update.setInt(1, request_quantity);
				pc_update.setInt(2, user_id);
				pc_update.setInt(3, item_id);
				pc_update.executeUpdate();

			}

			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return false;
	}

	public List<ItemDTO> getMyCart(int user_id)
	{
		return GetMyCart(connection, user_id);
	}
	public static List<ItemDTO> GetMyCart(int user_id)
	{
		Connection connection = DBConnector.getConnection();
		List<ItemDTO> result = GetMyCart(connection, user_id);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static List<ItemDTO> GetMyCart(Connection connection, int user_id)
	{
		String sql = "SELECT * FROM carts WHERE user_id = ?";
		List<ItemDTO> myCartItemList = new ArrayList<ItemDTO>();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int item_id = resultSet.getInt("item_id");
				ItemDTO itemDTO = ItemDAO.GetItem(item_id);
				itemDTO.setItem_count(resultSet.getInt("item_count"));

				myCartItemList.add(itemDTO);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return myCartItemList;
	}
}
