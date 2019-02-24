package com.internousdev.ShoppingSite.dao;

import java.sql.SQLException;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class DAO
{
	protected Connection connection;

	public DAO()
	{
		this.connection = DBConnector.createConnection();
	}

	public void close()
	{
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
