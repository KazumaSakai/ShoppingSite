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
	public boolean exist(String email, String loginId)
	{
		return Exist(connection, email, loginId);
	}
	public static boolean Exist(String email, String loginId)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = Exist(connection, email, loginId);

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
	public static boolean Exist(Connection connection, String email, String loginId)
	{
		String sql = "SELECT COUNT(*) FROM `users` WHERE email = ? OR login_id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				int i = resultSet.getInt(1);
				return (i > 0) ? true : false;
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

		return true;
	}

	public boolean changeUserPassword(int id, String login_id, String newPassword)
	{
		return ChangeUserPassword(connection, id, login_id, newPassword);
	}
	public static boolean ChangeUserPassword(int id, String login_id, String newPassword)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = ChangeUserPassword(connection, id, login_id, newPassword);

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
	public static boolean ChangeUserPassword(Connection connection, int id, String login_id, String newPassword)
	{
		newPassword = Passworder.getSafetyPassword(newPassword, login_id);

		String sql = "UPDATE users SET login_pass = ? WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			int line = preparedStatement.executeUpdate();

			if(line > 0)
			{
				return true;
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

		return false;
	}

	public boolean changeUserName(int id, String newName)
	{
		return ChangeUserName(connection, id, newName);
	}
	public static boolean ChangeUserName(int id, String newName)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = ChangeUserName(connection, id, newName);

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
	public static boolean ChangeUserName(Connection connection, int id, String newName)
	{
		String sql = "UPDATE users SET user_name = ? WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);

			int line = preparedStatement.executeUpdate();
			if(line > 0)
			{
				return true;
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

		return false;
	}

	public List<UserDTO> getUserList()
	{
		return GetUserList(connection);
	}
	public static List<UserDTO> GetUserList()
	{
		Connection connection = DBConnector.getConnection();
		List<UserDTO> result = GetUserList(connection);

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
	public static List<UserDTO> GetUserList(Connection connection)
	{
		String sql = "SELECT id, admin, user_name, insert_date FROM users";

		List<UserDTO> userList = new ArrayList<UserDTO>();
		try
		{
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

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return userList;
	}

	public boolean deleteUser(int id)
	{
		return DeleteUser(connection, id);
	}
	public static boolean DeleteUser(int id)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = DeleteUser(connection, id);

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
	public static boolean DeleteUser(Connection connection, int id)
	{
		String sql ="DELETE FROM users WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int line = preparedStatement.executeUpdate();

			if(line > 0)
			{
				return true;
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
		return false;
	}

	public String getUserName(int user_id)
	{
		return GetUserName(connection, user_id);
	}
	public static String GetUserName(int user_id)
	{
		Connection connection = DBConnector.getConnection();
		String result = GetUserName(connection, user_id);

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
	public static String GetUserName(Connection connection, int user_id)
	{
		 String sql = "SELECT user_name FROM users WHERE id = ?";

		 try
		 {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, user_id);

			 ResultSet resultSet = preparedStatement.executeQuery();

			 if(resultSet.next())
			 {
				 return resultSet.getString("user_name");
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

		 return "";
	}
}
