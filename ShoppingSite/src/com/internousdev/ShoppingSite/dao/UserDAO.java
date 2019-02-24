package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;
import com.mysql.jdbc.Connection;

public class UserDAO extends DAO
{
	public static boolean Exist(String email, String loginId)
	{
		boolean exist = false;
		
		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT COUNT(*) FROM users WHERE email = ? OR login_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				exist = (resultSet.getInt(1) > 0);
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

		return exist;
	}

	public static boolean ChangeUserPassword(int id, String login_id, String newPassword)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE users SET login_pass = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, Passworder.getSafetyPassword(newPassword, login_id));
			preparedStatement.setInt(2, id);
			
			int line = preparedStatement.executeUpdate();
			success = (line > 0);
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

	public static boolean ChangeUserName(int id, String newName)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE users SET user_name = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);

			int line = preparedStatement.executeUpdate();
			success = (line > 0);
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

	public static List<UserDTO> GetUserList()
	{
		List<UserDTO> userList = new ArrayList<UserDTO>();
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "SELECT id, admin, user_name, insert_date FROM users";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
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

		return userList;
	}

	public static boolean DeleteUser(int id)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();

		try
		{
			String sql ="DELETE FROM users WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			int line = preparedStatement.executeUpdate();
			success = (line > 0);
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

	public static String GetUserName(int user_id)
	{
		String userName = "";
		
		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT user_name FROM users WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				userName = resultSet.getString("user_name");
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
		
		return userName;
	}
}
