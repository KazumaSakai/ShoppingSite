package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ItemSalesDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class ItemSalesDAO {
	public static boolean AddSalesData(int item_id, int quantity, int price) {
		String select_sql = "SELECT COUNT(*) FROM sales WHERE item_id = ? AND year = ? AND month = ? FOR UPDATE";
		String insert_sql = "INSERT INTO sales(item_id, year, month, quantity, price) VALUES(?, ?, ?, ?, ?)";
		String update_sql = "UPDATE sales SET quantity = quantity + ?, price = price + ? WHERE item_id = ? AND year = ? AND month = ?";
		String commit = "COMMIT";

		int year = LocalDateTime.now().getYear();
		int month = LocalDateTime.now().getMonth().getValue();

		try {
			PreparedStatement p_select = DBConnector.connection().prepareStatement(select_sql);
			p_select.setInt(1, item_id);
			p_select.setInt(2, year);
			p_select.setInt(3, month);
			ResultSet resultSet = p_select.executeQuery();

			PreparedStatement p_update = DBConnector.connection().prepareStatement(update_sql);
			p_update.setInt(1, quantity);
			p_update.setInt(2, price);
			p_update.setInt(3, item_id);
			p_update.setInt(4, year);
			p_update.setInt(5, month);

			PreparedStatement p_insert = DBConnector.connection().prepareStatement(insert_sql);
			p_insert.setInt(1, item_id);
			p_insert.setInt(2, year);
			p_insert.setInt(3, month);
			p_insert.setInt(4, quantity);
			p_insert.setInt(5, price);

			PreparedStatement p_commit = DBConnector.connection().prepareStatement(commit);

			if (resultSet.next()) {
				int i = resultSet.getInt(1);

				if (i > 0) {
					p_update.executeUpdate();
				} else {
					p_insert.executeUpdate();
				}
				p_commit.executeUpdate();
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<ItemSalesDTO> GetItemSales(int item_id) {
		List<ItemSalesDTO> list = new ArrayList<ItemSalesDTO>();

		String sql = "SELECT * FROM sales WHERE item_id = ? ORDER BY year DESC, month DESC LIMIT 0, 12";

		try {
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, item_id);

			int price = ItemDAO.GetItem(item_id).getItem_price();

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ItemSalesDTO dto = new ItemSalesDTO();
				dto.setItem_id(resultSet.getInt("item_id"));
				dto.setYear(resultSet.getInt("year"));
				dto.setMonth(resultSet.getInt("month"));
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setPrice(resultSet.getInt("price"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static ItemSalesDTO GetItemSales(int item_id, int year, int month) {
		ItemSalesDTO dto = new ItemSalesDTO();

		String sql = "SELECT quantity FROM sales WHERE item_id = ? AND year = ? AND month = ?";

		try {
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, item_id);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, month);

			int price = ItemDAO.GetItem(item_id).getItem_price();

			ResultSet resultSet = preparedStatement.executeQuery();

			dto.setItem_id(item_id);
			dto.setYear(year);
			dto.setMonth(month);
			if (resultSet.next()) {
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setPrice(resultSet.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
}