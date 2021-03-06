package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.CartDTO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class CartDAO
{
	/**
	 * 	カート情報を取得する
	 * @param userId
	 * 	ユーザーID
	 * @param productId
	 * 	商品ID
	 * @return
	 * 	カート情報
	 */
	public static CartDTO Select(int userId, int productId)
	{
		CartDTO cartDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM CartTable WHERE (userId = ? AND productId = ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, productId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				cartDTO = new CartDTO(resultSet);
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

		return cartDTO;
	}

	/**
	 * 	カート情報を削除する
	 * @param userId
	 * 	ユーザーID
	 * @param productId
	 * 	商品ID
	 * @return
	 * 	カート情報
	 */
	public static boolean Delete(int userId, int productId)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "DELETE FROM CartTable WHERE (userId = ? AND productId = ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, productId);

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

	/**
	 * 	カート情報の商品数を増加させる
	 * @param userId
	 * 	ユーザーID
	 * @param productId
	 * 	商品ID
	 * @param productQuantity
	 * 	増加させる商品数
	 * @return
	 * 	結果
	 */
	public static boolean IncrementProductQuantity(int userId, int productId, int productQuantity)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO CartTable (userId, productId, productQuantity) VALUES (?, ?, ?) "
						+ "ON DUPLICATE KEY UPDATE productQuantity = productQuantity + ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, productQuantity);
			preparedStatement.setInt(4, productQuantity);

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
	/**
	 * 	カート情報の商品数を増加させる
	 * @param userId
	 * 	ユーザーID
	 * @param productId
	 * 	商品ID
	 * @param productQuantity
	 * 	増加させる商品数
	 * @return
	 * 	結果
	 */
	public static boolean DecrementProductQuantity(int userId, int productId, int productQuantity)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE CartTable SET productQuantity = productQuantity - " +
					"CASE WHEN productQuantity <= ? THEN 0 ELSE ? END " +
					"WHERE (userId = ? AND productId = ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productQuantity);
			preparedStatement.setInt(2, productQuantity);
			preparedStatement.setInt(3, userId);
			preparedStatement.setInt(4, productId);

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
	/**
	 * 	カート情報のリストを取得する
	 * @param userId
	 * 	ユーザーID
	 * @return
	 * 	カート情報のリスト
	 */
	public static List<CartDTO> SelectList(int begin, int length, String where)
	{
		List<CartDTO> cartDTOList = new ArrayList<CartDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = MessageFormat.format("SELECT * FROM CartTable WHERE {0} LIMIT {1}, {2}", where, begin, length);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				cartDTOList.add(new CartDTO(resultSet));
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

		return cartDTOList;
	}

	public static List<CartDTO> SelectListByUserId(int begin, int length)
	{
		return CartDAO.SelectList(begin, length, "1");
	}

	public static List<CartDTO> SelectListByUserId(int begin, int length, int userId)
	{
		return CartDAO.SelectList(begin, length, MessageFormat.format("userId = ''{0}''", userId));
	}

	/**
	 * 	カートに入っている商品のリストを取得する
	 * @param userId
	 * 	ユーザーID
	 * @return
	 * 	商品情報リスﾄ
	 */
	public static List<ProductDTO> SelectProductListByUserId(int begin, int length, int userId)
	{
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			//	ProductTable.*
			//	 - ProductTable.productQuantity => CartTable.productQuantity
			String sql = "SELECT PT.id, PT.productName, PT.productPrice, CT.productQuantity, PT.productDescription, PT.salesCompanyId, PT.productionCompanyId, PT.imageQuantity, PT.releasedDate, PT.lastEditDate, PT.lastReplenishmentDate, PT.lastSalesDate "
						+ "FROM CartTable AS CT "
						+ "LEFT JOIN ProductTable AS PT ON PT.id = CT.productId "
						+ "WHERE userId = ? "
						+ "LIMIT ?, ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, length);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				productDTOList.add(new ProductDTO(resultSet));
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

		return productDTOList;
	}

	public static int SumPrice(int userId)
	{
		int totalPrice = 0;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT SUM(PT.productPrice * CT.productQuantity) AS TotalPrice "
						+ "FROM CartTable AS CT "
						+ "LEFT JOIN ProductTable AS PT ON PT.id = CT.productId "
						+ "WHERE userId = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				totalPrice = resultSet.getInt("TotalPrice");
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

		return totalPrice;
	}
}
