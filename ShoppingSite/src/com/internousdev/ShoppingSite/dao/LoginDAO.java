package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;

public class LoginDAO
{
	public static UserDTO LoginAtEmail(String email, String login_pass)
	{
		String sql = "SELECT * FROM users WHERE email = ?";
	 	UserDTO userDTO = new UserDTO();

	 	try
	 	{
			PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
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
					 userDTO.setLogin_id(get_login_id);
					 userDTO.setUser_name(get_user_name);
					 userDTO.setUser_name(get_user_name);
					 userDTO.setInsert_date(get_insert_date);

					 userDTO.setLoginFlg(true);
				 }
			}
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 
		 return userDTO;
	}
	
	public static UserDTO LoginAtUserId(String login_id, String login_pass)
	{
		 String sql = "SELECT * FROM users WHERE login_id = ?";
		 UserDTO userDTO = new UserDTO();
		 try
		 {
			 PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
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
					 userDTO.setUser_name(get_user_name);
					 userDTO.setUser_name(get_user_name);
					 userDTO.setInsert_date(get_insert_date);

					 userDTO.setLoginFlg(true);
				 }
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

		 return userDTO;
	}
}
