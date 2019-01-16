package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.Crypto;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class LoginDAO
{
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private UserDTO userDTO = new UserDTO();

	public UserDTO getLoginUserInfo(String login_id, String login_pass)
	{
		 String sql = "SELECT * FROM users "
		 		+ "WHERE login_id = ?";

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

				 String pass = Crypto.decrypto(get_login_pass);

				 if(pass == login_pass)
				 {
					 userDTO.setId(get_id);
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