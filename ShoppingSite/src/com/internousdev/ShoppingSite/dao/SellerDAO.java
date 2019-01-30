package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ShoppingSite.dto.SellerDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class SellerDAO
{
	private Connection connection;
	public SellerDAO()
	{
		this.connection = DBConnector.getConnection();
	}
	
	public SellerDTO getSeller(int id)
	{
		return GetSeller(connection, id);
	}
	public static SellerDTO GetSeller(int id)
	{
		return GetSeller(DBConnector.getConnection(), id);
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
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return sellerDTO;
	}
}