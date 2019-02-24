package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemSalesDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ItemSalesDAO extends DAO
{
	/**
	 * 	商品の売り上げを追加する
	 * @param item_id
	 * 	商品のID
	 * @param quantity
	 * 	商品の個数
	 * @param price
	 * 	商品の値段
	 * @return
	 * 	結果
	 */
	public static boolean AddSalesData(int item_id, int quantity, int price)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();
		
		int year = LocalDateTime.now().getYear();
		int month = LocalDateTime.now().getMonth().getValue();

		try
		{
			//	SELECT
			String select_sql = "SELECT COUNT(*) FROM sales WHERE item_id = ? AND year = ? AND month = ? FOR UPDATE";
			PreparedStatement p_select = connection.prepareStatement(select_sql);
			p_select.setInt(1, item_id);
			p_select.setInt(2, year);
			p_select.setInt(3, month);

			ResultSet resultSet = p_select.executeQuery();
			
			//	UPDATE
			if (resultSet.next() && resultSet.getInt(1) > 0)
			{
				String update_sql = "UPDATE sales SET quantity = quantity + ?, price = price + ? WHERE item_id = ? AND year = ? AND month = ?";
				PreparedStatement p_update = connection.prepareStatement(update_sql);
				p_update.setInt(1, quantity);
				p_update.setInt(2, price);
				p_update.setInt(3, item_id);
				p_update.setInt(4, year);
				p_update.setInt(5, month);
				
				int line = p_update.executeUpdate();
				success = (line > 0);
			}
			//	INSERT
			else
			{
				String insert_sql = "INSERT INTO sales(item_id, year, month, quantity, price) VALUES(?, ?, ?, ?, ?)";
				PreparedStatement p_insert = connection.prepareStatement(insert_sql);
				p_insert.setInt(1, item_id);
				p_insert.setInt(2, year);
				p_insert.setInt(3, month);
				p_insert.setInt(4, quantity);
				p_insert.setInt(5, price);
				
				int line = p_insert.executeUpdate();
				success = (line > 0);
			}

			//	COMMIT
			String commit_sql = "COMMIT";
			PreparedStatement p_commit = connection.prepareStatement(commit_sql);
			p_commit.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (connection != null) connection.close();	
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return success;
	}

	/**
	 * 	十二か月分の商品の売り上げを取得する
	 * @param item_id
	 * 	商品のID
	 * @return
	 * 	売上のリスト
	 */
	public static List<ItemSalesDTO> GetItemSales(int item_id)
	{
		List<ItemSalesDTO> list = new ArrayList<ItemSalesDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM sales WHERE item_id = ? ORDER BY year DESC, month DESC LIMIT 0, 12";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				ItemSalesDTO dto = new ItemSalesDTO();
				dto.setItem_id(resultSet.getInt("item_id"));
				dto.setYear(resultSet.getInt("year"));
				dto.setMonth(resultSet.getInt("month"));
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setPrice(resultSet.getInt("price"));
				list.add(dto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (connection != null) connection.close();	
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return list;
	}
}
