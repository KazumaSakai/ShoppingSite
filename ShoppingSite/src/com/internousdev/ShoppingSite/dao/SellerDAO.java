package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.SellerDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class SellerDAO extends DAO
{
	public SellerDTO getSeller(int id)
	{
		return GetSeller(connection, id);
	}
	public static SellerDTO GetSeller(int id)
	{
		Connection connection = DBConnector.getConnection();
		SellerDTO result = GetSeller(connection, id);

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
	public static SellerDTO GetSeller(Connection connection, int id)
	{
		SellerDTO sellerDTO = new SellerDTO();

		try
		{
			String sql = "SELECT * FROM sellers WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				sellerDTO.setName(resultSet.getString("name"));
				sellerDTO.setId(resultSet.getInt("id"));
				sellerDTO.setAddress(resultSet.getString("address"));
				sellerDTO.setDescription(resultSet.getString("description"));
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

		return sellerDTO;
	}
}