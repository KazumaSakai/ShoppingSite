package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;
import com.mysql.jdbc.Connection;

public class SignUpDAO extends DAO
{
	public static boolean SignUp(String login_id, String email, String login_pass, String user_name, boolean oauthUser)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();
				
		if(UserDAO.Exist(login_id, email))
		{
			return false;
		}

		try
		{
			String sql = "INSERT INTO users(login_id, email, login_pass, user_name, oauthUser) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login_id);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, Passworder.getSafetyPassword(login_pass, login_id));
			preparedStatement.setString(4, user_name);
			preparedStatement.setBoolean(5, oauthUser);

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
}
