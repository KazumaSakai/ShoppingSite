package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ProductReviewDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ProductReviewDAO
{
	/**
	 * 	商品レビュー情報を挿入する
	 * @param productReviewDTO
	 * 	商品レビュー情報
	 * @return
	 * 	結果
	 */
	public static boolean Insert(ProductReviewDTO productReviewDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO ProductReviewTable(productId, userId, reviewTitle, reviewPoint, reviewComment) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productReviewDTO.getProductId());
			preparedStatement.setInt(2, productReviewDTO.getUserId());
			preparedStatement.setString(3, productReviewDTO.getReviewTitle());
			preparedStatement.setInt(4, productReviewDTO.getReviewPoint());
			preparedStatement.setString(5, productReviewDTO.getReviewComment());

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
	 * 	商品レビュー情報を更新する
	 * @param productReviewDTO
	 * 	商品レビュー情報
	 * @return
	 * 	結果
	 */
	public static boolean Update(ProductReviewDTO productReviewDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE ProductReviewTable SET productId = ?, userId = ?, reviewTitle = ?, reviewPoint = ?, reviewComment = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productReviewDTO.getProductId());
			preparedStatement.setInt(2, productReviewDTO.getUserId());
			preparedStatement.setString(3, productReviewDTO.getReviewTitle());
			preparedStatement.setInt(4, productReviewDTO.getReviewPoint());
			preparedStatement.setString(5, productReviewDTO.getReviewComment());
			preparedStatement.setInt(6, productReviewDTO.getId());

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
	 * 	商品レビュー情報を取得する
	 * @param id
	 * 	商品レビューID
	 * @return
	 * 	商品レビュー情報
	 */
	public static ProductReviewDTO Select(int id)
	{
		ProductReviewDTO productReviewDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM ProductReviewTable WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				productReviewDTO = new ProductReviewDTO(resultSet);
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

		return productReviewDTO;
	}

	/**
	 * 	商品レビューを削除する
	 * @param id
	 * 	商品レビューID
	 * @return
	 * 	結果
	 */
	public static boolean Delete(int id)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "DELETE FROM ProductReviewTable WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

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
	 * 	商品レビューのリストを取得する
	 * @param begin
	 * 	開始位置
	 * @param length
	 * 	最大取得数
	 * @param where
	 * 	条件
	 * @return
	 * 	商品レビューのリスト
	 */
	public static List<ProductReviewDTO> SelectList(int begin, int length, String where)
	{
		List<ProductReviewDTO> productReviewDTOList = new ArrayList<ProductReviewDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = MessageFormat.format("SELECT * FROM ProductReviewTable WHERE {0} LIMIT {1}, {2}", where, begin, length);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				productReviewDTOList.add(new ProductReviewDTO(resultSet));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return productReviewDTOList;
	}

	/**
	 * 	商品レビューのリストを取得する
	 * @param productId
	 * 	商品ID
	 * @param begin
	 * 	開始位置
	 * @param length
	 * 	最大取得数
	 * @return
	 * 	商品レビューのリスト
	 */
	public static List<ProductReviewDTO> SelectListByProductId(int begin, int length, int productId)
	{
		return SelectList(begin, length, MessageFormat.format("productId = ''{0}''", productId));
	}

	/**
	 * 	商品レビューのリストを取得する
	 * @param userId
	 * 	ユーザーID
	 * @param begin
	 * 	開始位置
	 * @param length
	 * 	最大取得数
	 * @return
	 * 	商品レビューのリスト
	 */
	public static List<ProductReviewDTO> SelectListByUserId(int begin, int length, int userId)
	{
		return SelectList(begin, length, MessageFormat.format("userId = ''{0}''", userId));
	}
}
