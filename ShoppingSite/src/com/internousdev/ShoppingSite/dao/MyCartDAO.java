package com.internousdev.ShoppingSite.dao;

import com.internousdev.ShoppingSite.dto.MyCartDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class MyCartDAO
{
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private MyCartDTO myCartDTO = new MyCartDTO();

	private MyCartDTO getMyCart(int user_id)
	{


		return myCartDTO;
	}
}
