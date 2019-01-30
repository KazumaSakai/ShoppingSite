package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.AddressDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class AddressDAO
{
	private Connection connection;
	public AddressDAO()
	{
		this.connection = DBConnector.getConnection();
	}

	public String getAddress(int id)
	{
		return GetAddress(connection, id);
	}
	public static String GetAddress(int id)
	{
		return GetAddress(DBConnector.getConnection(), id);
	}
	public static String GetAddress(Connection connection, int id)
	{
		String sql = "SELECT address FROM addressList WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				return resultSet.getString("address");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return "";
	}

	public boolean addUserAddress(int user_id, String address) 
	{
		return AddUserAddress(connection, user_id, address);
	}
	public static boolean AddUserAddress(int user_id, String address) 
	{
		return AddUserAddress(DBConnector.getConnection(), user_id, address);
	}
	public static boolean AddUserAddress(Connection connection, int user_id, String address)
	{
		String sql = "INSERT INTO addressList(address, user_id) VALUES(?, ?)";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, address);
			preparedStatement.setInt(2, user_id);
			
			int line = preparedStatement.executeUpdate();
			if (line > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}

	public List<AddressDTO> getUserAddressList(int user_id)
	{
		return GetUserAddressList(connection, user_id);
	}
	public static List<AddressDTO> GetUserAddressList(int user_id)
	{
		return GetUserAddressList(DBConnector.getConnection(), user_id);
	}
	public static List<AddressDTO> GetUserAddressList(Connection connection, int user_id)
	{
		List<AddressDTO> list = new ArrayList<AddressDTO>();

		String sql = "SELECT id, address FROM addresslist WHERE user_id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
