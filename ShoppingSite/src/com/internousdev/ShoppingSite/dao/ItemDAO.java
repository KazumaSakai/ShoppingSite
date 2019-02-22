package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ItemDAO extends DAO
{
	public boolean updateItem(int id, String item_name, int item_price, int item_quantity, String description, int seller, int image_num)
	{
		return UpdateItem(connection, id, item_name, item_price, item_quantity, description, seller, image_num);
	}
	public static boolean UpdateItem(int id, String item_name, int item_price, int item_quantity, String description, int seller, int image_num)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = UpdateItem(connection, id, item_name, item_price, item_quantity, description, seller, image_num);

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
	public static boolean UpdateItem(Connection connection, int id, String item_name, int item_price, int item_quantity, String description, int seller, int image_num)
	{
		String sql = "UPDATE items SET item_name=?, item_price=?, item_count=item_count + ?, description=?, seller=?, image_num=? WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setInt(2, item_price);
			preparedStatement.setInt(3, item_quantity);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, seller);
			preparedStatement.setInt(6, image_num);
			preparedStatement.setInt(7, id);

			int line = preparedStatement.executeUpdate();
			if(line > 0)
			{
				return true;
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

		return false;
	}

	public boolean addItem(int quantity, int price, String name, String description, int seller, int image_num)
	{
		return AddItem(connection, quantity, price, name, description, seller, image_num);
	}
	public static boolean AddItem(int quantity, int price, String name, String description, int seller, int image_num)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = AddItem(connection, quantity, price, name, description, seller, image_num);

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
	public static boolean AddItem(Connection connection, int quantity, int price, String name, String description, int seller, int image_num)
	{
		String sql = "INSERT INTO items(item_name, item_price, item_count, description, seller, image_num) VALUES(?, ?, ?, ?, ?, ?)";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, price);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, seller);
			preparedStatement.setInt(6, image_num);

			int line = preparedStatement.executeUpdate();
			if(line > 0)
			{
				return true;
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

		return false;
	}

	public boolean addItemQuantity(int id, int quantity)
	{
		return AddItemQuantity(connection, id, quantity);
	}
	public static boolean AddItemQuantity(int id, int quantity)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = AddItemQuantity(connection, id, quantity);

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
	public static boolean AddItemQuantity(Connection connection, int id, int quantity)
	{
		String sql = "UPDATE items SET item_count = item_count + ? WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, id);

			int line = preparedStatement.executeUpdate();
			if(line > 0)
			{
				return true;
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

		return false;
	}

	public boolean deleteItem(int id)
	{
		return DeleteItem(connection, id);
	}
	public static boolean DeleteItem(int id)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = DeleteItem(connection, id);

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
	public static boolean DeleteItem(Connection connection, int id)
	{
		String sql = "DELETE FROM items WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int line = preparedStatement.executeUpdate();

			if(line > 0)
			{
				return true;
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

		return false;
	}

	public ItemDTO getItem(int item_id)
	{
		return GetItem(connection, item_id);
	}
	public static ItemDTO GetItem(int item_id)
	{
		Connection connection = DBConnector.getConnection();
		ItemDTO result = GetItem(connection, item_id);

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
	public static ItemDTO GetItem(Connection connection, int item_id)
	{
		String sql = "SELECT * FROM items WHERE id = ?";
		ItemDTO itemDTO = new ItemDTO();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				itemDTO.setItem_id(item_id);
				itemDTO.setItem_name(resultSet.getString("item_name"));
				itemDTO.setItem_price(resultSet.getInt("item_price"));
				itemDTO.setItem_count(resultSet.getInt("item_count"));
				itemDTO.setDescription(resultSet.getString("description"));
				itemDTO.setSeller(SellerDAO.GetSeller(resultSet.getInt("seller")));
				itemDTO.setImage_num(resultSet.getInt("image_num"));
				itemDTO.setInsert_date(resultSet.getString("insert_date"));
				itemDTO.setLast_add_date(resultSet.getString("last_add_date"));
				itemDTO.setLast_sell_date(resultSet.getString("last_sell_date"));
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

		return itemDTO;
	}

	public List<ItemDTO> getItemList(List<String> searchWordList, boolean ANDSearch)
	{
		return GetItemList(connection, searchWordList, ANDSearch);
	}
	public static List<ItemDTO> GetItemList(List<String> searchWordList, boolean ANDSearch)
	{
		Connection connection = DBConnector.getConnection();
		List<ItemDTO> result = GetItemList(connection, searchWordList, ANDSearch);

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
	public static List<ItemDTO> GetItemList(Connection connection, List<String> searchWordList, boolean ANDSearch)
	{
		String sql = "SELECT * FROM items WHERE ";
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();

		try
		{
			StringBuilder sb = new StringBuilder();

			boolean isFirst = true;

			for(String str : searchWordList)
			{
				if(isFirst)
				{
					isFirst = false;
					sb.append("(item_name LIKE '%").append(str).append("%')");
				}
				else
				{
					sb.append(ANDSearch ? " AND (item_name LIKE '%" : " OR (item_name LIKE '%").append(str).append("%')");
				}
			}

			sql += sb.toString();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			SellerDAO sellerDAO = new SellerDAO();
			while (resultSet.next())
			{
				ItemDTO itemDTO = new ItemDTO();

				itemDTO.setItem_id(resultSet.getInt("id"));
				itemDTO.setItem_name(resultSet.getString("item_name"));
				itemDTO.setItem_price(resultSet.getInt("item_price"));
				itemDTO.setItem_count(resultSet.getInt("item_count"));
				itemDTO.setDescription(resultSet.getString("description"));
				itemDTO.setSeller(sellerDAO.getSeller(resultSet.getInt("seller")));
				itemDTO.setImage_num(resultSet.getInt("image_num"));
				itemDTO.setInsert_date(resultSet.getString("insert_date"));
				itemDTO.setLast_add_date(resultSet.getString("last_add_date"));
				itemDTO.setLast_sell_date(resultSet.getString("last_sell_date"));

				itemList.add(itemDTO);
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

		return itemList;
	}

	public List<ItemDTO> getItemList()
	{
		return GetItemList(connection);
	}
	public static List<ItemDTO> GetItemList()
	{
		Connection connection = DBConnector.getConnection();
		List<ItemDTO> result = GetItemList(connection);

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
	public static List<ItemDTO> GetItemList(Connection connection)
	{
		String sql = "SELECT * FROM items ";
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			SellerDAO sellerDAO = new SellerDAO();
			while (resultSet.next())
			{
				ItemDTO itemDTO = new ItemDTO();

				itemDTO.setItem_id(resultSet.getInt("id"));
				itemDTO.setItem_name(resultSet.getString("item_name"));
				itemDTO.setItem_price(resultSet.getInt("item_price"));
				itemDTO.setItem_count(resultSet.getInt("item_count"));
				itemDTO.setDescription(resultSet.getString("description"));
				itemDTO.setSeller(sellerDAO.getSeller(resultSet.getInt("seller")));
				itemDTO.setImage_num(resultSet.getInt("image_num"));
				itemDTO.setInsert_date(resultSet.getString("insert_date"));
				itemDTO.setLast_add_date(resultSet.getString("last_add_date"));
				itemDTO.setLast_sell_date(resultSet.getString("last_sell_date"));

				itemList.add(itemDTO);
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

		return itemList;
	}

}
