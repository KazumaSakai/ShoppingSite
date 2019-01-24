package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.AddressDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class AddressDAO
{
	public static boolean AddUserAddress(int user_id, String address)
	{
		String sql = "INSERT INTO addressList(address, user_id) VALUES(?, ?)";
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setString(1, address);
			preparedStatement.setInt(2, user_id);
			int line = preparedStatement.executeUpdate();
			if(line > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static List<AddressDTO> GetUserAddressList(int user_id)
	{
		List<AddressDTO> list = new ArrayList<AddressDTO>();
		
		String sql = "SELECT id, address FROM addresslist WHERE user_id = ?";
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				AddressDTO dto = new AddressDTO();
				dto.setAddress(resultSet.getString("address"));
				dto.setId(resultSet.getInt("id"));
				dto.setUser_id(user_id);
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
