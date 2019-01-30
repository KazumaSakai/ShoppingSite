package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;

public class UserDAO
{
	public static boolean Exist(String email, String loginId)
	{
		String sql = "SELECT COUNT(*) FROM `users` WHERE email = ? OR login_id = ?";
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				int i = resultSet.getInt(1);
				return (i > 0) ? true : false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void ChangeUserPassword(int id, String login_id, String newPassword)
	{
		newPassword = Passworder.getSafetyPassword(newPassword, login_id);
		
		String sql = "UPDATE users SET login_pass = ? WHERE id = ?";
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void ChangeUserName(int id, String newName)
	{
		String sql = "UPDATE users SET user_name = ? WHERE id = ?";
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);

			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static List<UserDTO> GetUserList()
	{
		String sql = "SELECT id, admin, user_name, insert_date FROM users";

		List<UserDTO> userList = new ArrayList<UserDTO>();
		try
		{
			PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);;

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

	public static void DeleteUser(int id)
	{
		String sql ="DELETE FROM users WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static String GetUserName(int user_id)
	{
		 String sql = "SELECT user_name FROM users WHERE id = ?";

		 try
		 {
			 PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
			 preparedStatement.setInt(1, user_id);

			 ResultSet resultSet = preparedStatement.executeQuery();

			 if(resultSet.next())
			 {
				 return resultSet.getString("user_name");
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

		 return "";
	}
}
