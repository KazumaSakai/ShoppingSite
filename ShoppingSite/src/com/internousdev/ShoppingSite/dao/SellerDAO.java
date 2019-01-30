package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ShoppingSite.dto.SellerDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class SellerDAO
{
	public static SellerDTO GetSeller(int id)
	{
		SellerDTO sellerDTO = new SellerDTO();

		try
		{
			String sql = "SELECT * FROM sellers WHERE id = ?";
			PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
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