package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class AdminUserListDAO
{

	public static List<UserDTO> GetUserList()
	{
		String sql = "SELECT id, admin, user_name, insert_date FROM users";

		List<UserDTO> userList = new ArrayList<UserDTO>();
		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);;

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getInt("id"));
				userDTO.setAdmin(resultSet.getBoolean("admin"));
				userDTO.setUser_name(resultSet.getString("user_name"));
				userDTO.setInsert_date(resultSet.getString("insert_date"));

				userList.add(userDTO);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return userList;
	}
}
