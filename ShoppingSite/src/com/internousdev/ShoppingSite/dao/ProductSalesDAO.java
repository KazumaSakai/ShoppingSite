package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ProductSalesDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ProductSalesDAO
{
	public static ProductSalesDTO Select(int productId, int salesYear, int salesMonth)
	{
		ProductSalesDTO productSalesDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM ProductSalesTable WHERE productId = ? AND salesYear = ? AND salesMonth = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			preparedStatement.setInt(2, salesYear);
			preparedStatement.setInt(3, salesMonth);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				productSalesDTO = new ProductSalesDTO(resultSet);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return productSalesDTO;
	}

	public static boolean Update(ProductSalesDTO productSalesDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE ProductSalesTabl SET salesQuantity = ?, totalSales = ?, totalRevenue = ? WHERE productId = ? AND salesYear = ? AND salesMonth = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productSalesDTO.getSalesQuantity());
			preparedStatement.setInt(2, productSalesDTO.getTotalSales());
			preparedStatement.setInt(3, productSalesDTO.getTotalRevenue());
			preparedStatement.setInt(4, productSalesDTO.getProductId());
			preparedStatement.setInt(5, productSalesDTO.getSalesYear());
			preparedStatement.setInt(6, productSalesDTO.getSalesMonth());

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

	public static boolean Increment(ProductSalesDTO productSalesDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO ProductSalesTable(productId, salesQuantity, totalSales, totalRevenue, salesYear, salesMonth) VALUE(?, ?, ?, ?, ?, ?) "
						+ "ON DUPLICATE KEY UPDATE "
							+ "salesQuantity = salesQuantity + ? "
							+ "totalSales = totalSales + ? "
							+ "totalRevenue = totalRevenue + ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productSalesDTO.getProductId());
			preparedStatement.setInt(2, productSalesDTO.getSalesQuantity());
			preparedStatement.setInt(3, productSalesDTO.getTotalSales());
			preparedStatement.setInt(4, productSalesDTO.getTotalRevenue());
			preparedStatement.setInt(5, productSalesDTO.getSalesYear());
			preparedStatement.setInt(6, productSalesDTO.getSalesMonth());
			preparedStatement.setInt(7, productSalesDTO.getSalesQuantity());
			preparedStatement.setInt(8, productSalesDTO.getTotalSales());
			preparedStatement.setInt(9, productSalesDTO.getTotalRevenue());

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

	public static List<ProductSalesDTO> SelectList(int begin, int length, String where)
	{
		List<ProductSalesDTO> productSalesDTOList = new ArrayList<ProductSalesDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			StringBuilder sql = new StringBuilder("SELECT * FROM ProductSalesTable WHERE ").append(where).append(" ORDER BY salesYear DESC, salesMonth DESC LIMIT ?, ?");
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, length);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				productSalesDTOList.add(new ProductSalesDTO(resultSet));
			}
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

		return productSalesDTOList;
	}

	public static List<ProductSalesDTO> SelectListByProductId(int begin, int length, int productId)
	{
		return ProductSalesDAO.SelectList(begin, length, "productId = " + productId);
	}
}
