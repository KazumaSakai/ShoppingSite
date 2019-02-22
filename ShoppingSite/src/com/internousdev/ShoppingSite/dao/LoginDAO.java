package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;
import com.mysql.jdbc.Connection;

public class LoginDAO extends DAO
{
	public UserDTO loginAtEmail(String email, String login_pass)
	{
		return LoginAtEmail(connection, email, login_pass);
	}
	public static UserDTO LoginAtEmail(String email, String login_pass)
	{
		Connection connection = DBConnector.getConnection();
		UserDTO result = LoginAtEmail(connection, email, login_pass);

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
	public static UserDTO LoginAtEmail(Connection connection, String email, String login_pass)
	{
		String sql = "SELECT * FROM users WHERE email = ?";
	 	UserDTO userDTO = new UserDTO();

	 	try
	 	{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				 int get_id = resultSet.getInt("id");
				 String get_login_id = resultSet.getString("login_id");
				 String get_login_pass = resultSet.getString("login_pass");
				 String get_user_name = resultSet.getString("user_name");
				 String get_insert_date = resultSet.getString("insert_date");
				 boolean get_isAdmin = resultSet.getBoolean("admin");

				 String pass = Passworder.getSafetyPassword(login_pass, get_login_id);

				 if(pass.equals(get_login_pass))
				 {
					 userDTO.setAdmin(get_isAdmin);
					 userDTO.setId(get_id);
					 userDTO.setLogin_pass(get_login_pass);
					 userDTO.setLogin_id(get_login_id);
					 userDTO.setUser_name(get_user_name);
					 userDTO.setUser_name(get_user_name);
					 userDTO.setInsert_date(get_insert_date);

					 userDTO.setLoginFlg(true);
				 }
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

		 return userDTO;
	}

	public UserDTO loginAtUserId(String login_id, String login_pass)
	{
		return LoginAtUserId(connection, login_id, login_pass);
	}
	public static UserDTO LoginAtUserId(String login_id, String login_pass)
	{
		Connection connection = DBConnector.getConnection();
		UserDTO result = LoginAtUserId(connection, login_id, login_pass);

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
	public static UserDTO LoginAtUserId(Connection connection, String login_id, String login_pass)
	{
		String sql = "SELECT * FROM users WHERE login_id = ?";
		UserDTO userDTO = new UserDTO();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				int get_id = resultSet.getInt("id");
				String get_login_id = resultSet.getString("login_id");
				String get_login_pass = resultSet.getString("login_pass");
				String get_user_name = resultSet.getString("user_name");
				String get_insert_date = resultSet.getString("insert_date");
				boolean get_isAdmin = resultSet.getBoolean("admin");

				String pass = Passworder.getSafetyPassword(login_pass, login_id);

				if(pass.equals(get_login_pass))
				{
					userDTO.setAdmin(get_isAdmin);
					userDTO.setId(get_id);
					userDTO.setLogin_id(get_login_id);
					userDTO.setLogin_pass(get_login_pass);
					userDTO.setUser_name(get_user_name);
					userDTO.setUser_name(get_user_name);
					userDTO.setInsert_date(get_insert_date);

					userDTO.setLoginFlg(true);
				}
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

		return userDTO;
	}
}
