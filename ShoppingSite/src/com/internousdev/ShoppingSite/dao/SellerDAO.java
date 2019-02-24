package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.SellerDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class SellerDAO extends DAO
{
	public static SellerDTO GetSeller(int id)
	{
		SellerDTO sellerDTO = null;
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "SELECT * FROM sellers WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				sellerDTO = new SellerDTO();
				sellerDTO.setName(resultSet.getString("name"));
				sellerDTO.setId(resultSet.getInt("id"));
				sellerDTO.setAddress(resultSet.getString("address"));
				sellerDTO.setDescription(resultSet.getString("description"));
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

		return sellerDTO;
	}
}