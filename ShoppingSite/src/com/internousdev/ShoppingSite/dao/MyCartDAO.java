package com.internousdev.ShoppingSite.dao;

import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class MyCartDAO
{
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
}
