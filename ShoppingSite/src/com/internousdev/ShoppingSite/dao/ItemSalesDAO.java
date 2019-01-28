package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemSalesDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class ItemSalesDAO
{
	public static List<ItemSalesDTO> GetItemSales(int item_id)
	{
		List<ItemSalesDTO> list = new ArrayList<ItemSalesDTO>();
		
		String sql = "SELECT * FROM sales WHERE item_id = ? ORDER BY year, month";
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, item_id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				ItemSalesDTO dto = new ItemSalesDTO();
				dto.setItem_id(resultSet.getInt("item_id"));
				dto.setYear(resultSet.getInt("year"));
				dto.setMonth(resultSet.getInt("month"));
				dto.setQuantity(resultSet.getInt("quantity"));
				list.add(dto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
}
