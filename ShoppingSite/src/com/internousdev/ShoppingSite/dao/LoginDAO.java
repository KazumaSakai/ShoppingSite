package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.mysql.jdbc.Connection;

public class LoginDAO extends DAO
{
	/**
	 * 	メールアドレスでログインする
	 * @param email
	 * 	メールアドレス
	 * @param login_pass
	 * 	ログインパスワード
	 * @return
	 * 	ユーザー情報
	 */
	public static UserDTO LoginByEmail(String email, String login_pass)
	{
	 	UserDTO userDTO = null;
	 	
	 	Connection connection = DBConnector.createConnection();

	 	try
	 	{
			String sql = "SELECT * FROM users WHERE email = ?";
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
					 userDTO = new UserDTO();
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
	 	
		return userDTO;
	}

	/**
	 * 	ユーザーIDでログインする
	 * @param login_id
	 * 	ログインID
	 * @param login_pass
	 * 	パスワード
	 * @return
	 * 	ユーザー情報
	 */
	public static UserDTO LoginByUserId(String login_id, String login_pass)
	{
		UserDTO userDTO = null;
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "SELECT * FROM users WHERE login_id = ?";
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
					userDTO = new UserDTO();
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

		return userDTO;
	}
	
	/**
	 * パスワードを確認する
	 * @param loginId
	 * 	ログインID
	 * @param password
	 * 	パスワード
	 * @return
	 * 	結果
	 */
	public static boolean CheckPassword(String loginId, String password)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "SELECT login_pass FROM users WHERE login_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				String safePassword = Passworder.getSafetyPassword(password, loginId);
				String getPassword = resultSet.getString("login_pass");
				success = StringChecker.IsEqual(safePassword, getPassword);
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

		return success;
	}
}
