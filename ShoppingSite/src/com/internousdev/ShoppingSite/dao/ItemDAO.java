package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ItemDAO
{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private ItemDTO itemDTO = new ItemDTO();

	public static void AddItem(int quantity, int price, String name, String description, int seller, int image_num)
	{
		String sql = "INSERT INTO items(item_name, item_price, item_count, description, seller, image_num) VALUES(?, ?, ?, ?, ?, ?)";

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, price);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, seller);
			preparedStatement.setInt(6, image_num);

			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void AddItemQuantity(int id, int quantity)
	{
		String sql = "UPDATE items SET item_count = item_count + ? WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, id);

			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void DeleteItem(int id)
	{
		String sql = "DELETE FROM items WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public ItemDTO getItem(int item_id)
	{
		 String sql = "SELECT * FROM items WHERE id = ?";

		 try
		 {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, item_id);

			 ResultSet resultSet = preparedStatement.executeQuery();

			 if(resultSet.next())
			 {
				 String get_item_name = resultSet.getString("item_name");
				 int get_item_price = resultSet.getInt("item_price");
				 int get_item_count = resultSet.getInt("item_count");
				 String get_insert_date = resultSet.getString("insert_date");
				 String get_last_add_date = resultSet.getString("last_add_date");
				 String get_last_sell_date = resultSet.getString("last_sell_date");

				 itemDTO.setItem_id(item_id);
				 itemDTO.setItem_name(get_item_name);
				 itemDTO.setItem_price(get_item_price);
				 itemDTO.setItem_count(get_item_count);
				 itemDTO.setDescription(resultSet.getString("description"));
				 itemDTO.setSeller(SellerDAO.GetSeller(resultSet.getInt("seller")));
				 itemDTO.setImage_num(resultSet.getInt("image_num"));
				 itemDTO.setInsert_date(get_insert_date);
				 itemDTO.setLast_add_date(get_last_add_date);
				 itemDTO.setLast_sell_date(get_last_sell_date);
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

		 return itemDTO;
	}
}
