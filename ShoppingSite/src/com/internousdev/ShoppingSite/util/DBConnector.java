package com.internousdev.ShoppingSite.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnector
{
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ShoppingSite";

	private static String user = "root";
	private static String password = "mysql";

	public static Connection connection()
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

	public Connection getConnection()
	{
		Connection connection = null;

		try
		{
			Class.forName(driverName);
			connection = (Connection) DriverManager.getConnection(url, user, password);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return connection;
	}
}
