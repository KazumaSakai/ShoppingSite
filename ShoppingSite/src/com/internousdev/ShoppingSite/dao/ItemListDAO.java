package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.dto.ItemListDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ItemListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private ItemListDTO itemListDTO = new ItemListDTO();

	public ItemListDTO getItemList()
	{
		 String sql = "SELECT * FROM items ";

		 try
		 {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);

			 ResultSet resultSet = preparedStatement.executeQuery();

			 while (resultSet.next()) {
				 int item_id = resultSet.getInt("id");
				 String get_item_name = resultSet.getString("item_name");
				 int get_item_price = resultSet.getInt("item_price");
				 int get_item_count = resultSet.getInt("item_count");
				 String get_insert_date = resultSet.getString("insert_date");
				 String get_last_add_date = resultSet.getString("last_add_date");
				 String get_last_sell_date = resultSet.getString("last_sell_date");

				 ItemDTO itemDTO = new ItemDTO();

				 itemDTO.setItem_id(item_id);
				 itemDTO.setItem_name(get_item_name);
				 itemDTO.setItem_price(get_item_price);
				 itemDTO.setItem_count(get_item_count);
				 itemDTO.setInsert_date(get_insert_date);
				 itemDTO.setLast_add_date(get_last_add_date);
				 itemDTO.setLast_sell_date(get_last_sell_date);

				 itemListDTO.getCartItemList().add(itemDTO);
			}
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

		 return itemListDTO;
	}
}
