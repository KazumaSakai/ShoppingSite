package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;

public class SignUpDAO
{
	public static boolean SignUp(String login_id, String email, String login_pass, String user_name, boolean oauthUser)
	{
		 if(UserDAO.Exist(login_id, email))
		 {
			 return false;
		 }
		 
		 String sql = "INSERT INTO users(login_id, email, login_pass, user_name, oauthUser) VALUES(?, ?, ?, ?, ?)";

		 try
		 {
			 
			 PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql);
			 preparedStatement.setString(1, login_id);
			 preparedStatement.setString(2, email);
			 preparedStatement.setString(3, Passworder.getSafetyPassword(login_pass, login_id));
			 preparedStatement.setString(4, user_name);
			 preparedStatement.setBoolean(5, oauthUser);

			 int line =preparedStatement.executeUpdate();

			 return (line > 0);
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }

		 return false;
	}
}
