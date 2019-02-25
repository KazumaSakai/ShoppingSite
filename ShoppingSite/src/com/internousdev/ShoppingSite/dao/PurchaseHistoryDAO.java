package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.DateConverter;
import com.mysql.jdbc.Connection;

public class PurchaseHistoryDAO
{
	public static boolean Insert(PurchaseHistoryDTO purchaseHistoryDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO PurchaseHistoryTable(productId, productQuantity, userId, destinationId, shipmentState, requestDeliveryDate) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, purchaseHistoryDTO.getProductId());
			preparedStatement.setInt(2, purchaseHistoryDTO.getProductQuantity());
			preparedStatement.setInt(3, purchaseHistoryDTO.getUserId());
			preparedStatement.setInt(4, purchaseHistoryDTO.getDestinationId());
			preparedStatement.setInt(5, purchaseHistoryDTO.getShipmentState());
			preparedStatement.setString(6, DateConverter.toString(purchaseHistoryDTO.getRequestDeliveryDate()));

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

	public static PurchaseHistoryDTO Select(String where)
	{
		PurchaseHistoryDTO purchaseHistoryDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM PurchaseHistoryTable WHERE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, where);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				purchaseHistoryDTO = new PurchaseHistoryDTO(resultSet);
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

		return purchaseHistoryDTO;
	}

	public static PurchaseHistoryDTO SelectById(int id)
	{
		return PurchaseHistoryDAO.Select("id = " + id);
	}

	public static PurchaseHistoryDTO SelectByIdAndUserId(int id, int userId)
	{
		StringBuilder where = new StringBuilder();
		where.append("id = ").append(id);
		where.append("AND userId = ").append(userId);
		return PurchaseHistoryDAO.Select(where.toString());
	}

	public static boolean Update(PurchaseHistoryDTO purchaseHistoryDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE PurchaseHistoryTable SET destinationId = ?, shipmentState = ?, requestDeliveryDate = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, purchaseHistoryDTO.getDestinationId());
			preparedStatement.setInt(2, purchaseHistoryDTO.getShipmentState());
			preparedStatement.setString(3, DateConverter.toString(purchaseHistoryDTO.getRequestDeliveryDate()));

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

	public static boolean IncrementProductQuantity(int id, int userId, int productQuantity)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE PurchaseHistoryTable SET productQuantity = productQuantity + ? WHERE id = ? AND userId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productQuantity);
			preparedStatement.setInt(2, id);
			preparedStatement.setInt(3, userId);

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

	public static boolean Delete(String where)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM PurchaseHistoryTable WHERE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, where);

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

	public static boolean DeleteById(int id)
	{
		return Delete("id = " + id);
	}

	public static boolean DeleteByUserId(int userId)
	{
		return Delete("userId = " + userId);
	}

	public static boolean DeleteByIdAndUserId(int id, int userId)
	{
		StringBuilder where = new StringBuilder();
		where.append("id = ").append(id);
		where.append(" AND userId = ").append(userId);
		return Delete(where.toString());
	}

	public static List<PurchaseHistoryDTO> SelectList(int begin, int length, String where)
	{
		List<PurchaseHistoryDTO> purchaseHistoryDTOList = new ArrayList<PurchaseHistoryDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM PurchaseHistoryTable WHERE ? LIMIT ?, ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, where);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, length);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				purchaseHistoryDTOList.add(new PurchaseHistoryDTO(resultSet));
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

		return purchaseHistoryDTOList;
	}

	public static List<PurchaseHistoryDTO> SelectList(int begin, int length)
	{
		return PurchaseHistoryDAO.SelectList(begin, length, "1");
	}

	public static List<PurchaseHistoryDTO> SelectListByUserId(int begin, int length, int userId)
	{
		return PurchaseHistoryDAO.SelectList(begin, length, "userId = " + userId);
	}

	public static List<PurchaseHistoryDTO> SelectListByProductId(int begin, int length, int productId)
	{
		return PurchaseHistoryDAO.SelectList(begin, length, "productId = " + productId);
	}
}
