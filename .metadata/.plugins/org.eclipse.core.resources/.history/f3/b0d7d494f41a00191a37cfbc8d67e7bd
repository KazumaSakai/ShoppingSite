package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class UserNameDAO
{
	private static DBConnector dbConnector = new DBConnector();
	private static Connection connection = dbConnector.getConnection();

	public static String getUserName(int user_id)
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
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

		 return "";
	}
}
