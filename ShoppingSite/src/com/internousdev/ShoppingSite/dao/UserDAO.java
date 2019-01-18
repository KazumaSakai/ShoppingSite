package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;

public class UserDAO
{
	public static void DeleteUser(int id)
	{
		String sql ="DELETE FROM users WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
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
			 PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
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
