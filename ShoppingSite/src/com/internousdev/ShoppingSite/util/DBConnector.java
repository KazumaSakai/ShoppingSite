package com.internousdev.ShoppingSite.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnector
{
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/ShoppingSite";

	private static final String user = "root";
	private static final String password = "mysql";

	public static Connection createConnection()
	{
		Connection connection= null;

		try
		{
			Class.forName(driverName);
			connection = (Connection) DriverManager.getConnection(url, user, password);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return connection;
	}
}
