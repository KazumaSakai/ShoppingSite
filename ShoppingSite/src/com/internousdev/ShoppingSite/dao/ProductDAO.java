package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class ProductDAO
{
	/**
	 * 	商品情報を追加する
	 * @param productDTO
	 * 	追加する商品情報
	 * @return
	 * 	結果
	 */
	public static boolean Insert(ProductDTO productDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO ProductTable(productName, productPrice, productQuantity, productDescription, salesCompanyId, productionCompanyId, imageQuantity) VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productDTO.getProductName());
			preparedStatement.setInt(2, productDTO.getProductPrice());
			preparedStatement.setInt(3, productDTO.getProductQuantity());
			preparedStatement.setString(4, productDTO.getProductDescription());
			preparedStatement.setInt(5, productDTO.getSalesCompanyId());
			preparedStatement.setInt(6, productDTO.getProductionCompanyId());
			preparedStatement.setInt(7, productDTO.getImageQuantity());

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
	 * 	商品情報を取得する
	 * @param id
	 * 	対象のID
	 * @return
	 * 	商品情報
	 */
	public static ProductDTO Select(int id)
	{
		ProductDTO productDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM ProductTable WHERE id = ?";
			PreparedStatement preparedStatement = connection.clientPrepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				productDTO = new ProductDTO(resultSet);
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

		return productDTO;
	}

	/**
	 * ProductTableの情報を更新します。（producQuantityは更新されません。）
	 * @param productDTO
	 * 	更新する商品情報
	 * @return
	 * 	boolean
	 */
	public static boolean Update(ProductDTO productDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE ProductTable SET productName = ?, productPrice = ?, productDescription = ?, salesCompanyId = ?, productionCompanyId = ?, imageQuantity = ?, lastEditDate = now() WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productDTO.getProductName());
			preparedStatement.setInt(2, productDTO.getProductPrice());
			preparedStatement.setString(3, productDTO.getProductDescription());
			preparedStatement.setInt(4, productDTO.getSalesCompanyId());
			preparedStatement.setInt(5, productDTO.getProductionCompanyId());
			preparedStatement.setInt(6, productDTO.getImageQuantity());
			preparedStatement.setInt(7, productDTO.getId());

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
	 * 	商品情報を削除する
	 * @param id
	 * 	対象のID
	 * @return
	 * 	結果
	 */
	public static boolean Delete(int id)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "DELETE FROM ProductTable WHERE id = ?";

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
	 * 	商品情報のリストを取得する
	 * @param begin
	 * 	開始位置
	 * @param length
	 * 	取得する最大数
	 * @return
	 * 	商品情報のリスト
	 */
	public static List<ProductDTO> SelectList(int begin, int length)
	{
		return ProductDAO.SelectList(begin, length, "1");
	}

	/**
	 * 	商品情報のリストを、条件を指定して取得する
	 * @param begin
	 * 	開始位置
	 * @param length
	 * 	取得する最大数
	 * @param where
	 * 	条件
	 * @return
	 * 	商品情報のリスト
	 */
	public static List<ProductDTO> SelectList(int begin, int length, String where)
	{
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = MessageFormat.format("SELECT * FROM ProductTable WHERE {0} LIMIT {1}, {2}", where, begin, length);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

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

	/**
	 * 	商品情報のリストを、商品名を指定して検索する
	 * @param begin
	 * 	開始位置
	 * @param length
	 * 	取得する最大数
	 * @param searchProductNameList
	 * 	検索する商品名のリスト
	 * @param andSearch
	 * 	AND検索するかどうか (true: AND, false: OR)
	 * @return
	 * 	商品情報のリスト
	 */
	public static List<ProductDTO> SearchListByProductName(int begin, int length, Collection<String> searchProductNameList, boolean andSearch)
	{
		return ProductDAO.SelectList(begin, length, CreateSearchWhere(searchProductNameList, andSearch));
	}
	
	/**
	 * 	検索条件のWhere文を作成する
	 * @param searchProductNameList
	 * 	商品名のリスト
	 * @param andSearch
	 * 	AND検索か
	 * @return
	 * 	Where文
	 */
	public static String CreateSearchWhere(Collection<String> searchProductNameList, boolean andSearch)
	{
		Iterable<String> iterable = searchProductNameList.stream().map(s -> MessageFormat.format("(productName LIKE ''%{0}%'')", s))::iterator;
		return String.join(andSearch ? " AND " : " OR ", iterable);
	}

	/**
	 * 	商品個数を増加させる
	 * @param id
	 * 	対象のID
	 * @param quantity
	 * 	増加数 (Integer.MIN_VALUE ~ Integer.MAX_VALUE)
	 * @return
	 * 	結果
	 */
	public static boolean IncrementProductQuantity(int id, int quantity)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE ProductTable SET productQuantity = productQuantity + ?, lastReplenishmentDate = now() WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, id);


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
	 * 	商品個数を減少させる
	 * @param productId
	 * 	商品ID
	 * @param productQuantity
	 * 	商品個数
	 * @return
	 * 	結果
	 */
	public static boolean DecrementProductQuantity(int productId, int productQuantity)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE ProductTable SET lastSalesDate = now(), productQuantity = productQuantity - " +
							"CASE WHEN productQuantity <= ? THEN 0 ELSE ? END " +
							"WHERE id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productQuantity);
			preparedStatement.setInt(2, productQuantity);
			preparedStatement.setInt(3, productId);

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
	 * 	すべての商品の数を取得する
	 * @return
	 * 	商品の数
	 */
	public static int Count()
	{
		return Count("1");
	}
	
	/**
	 *	商品名が合致する商品の数を取得する
	 * @param searchProductNameList
	 * 	商品名のリスト
	 * @param andSearch
	 * 	AND検索か
	 * @return
	 * 	商品の数
	 */
	public static int Count(Collection<String> searchProductNameList, boolean andSearch)
	{
		return Count(CreateSearchWhere(searchProductNameList, andSearch));
	}

	/**
	 *	検索条件に合致する商品の数を取得する
	 * @param where
	 * 	検索条件
	 * @return
	 * 	商品の数
	 */
	public static int Count(String where)
	{
		int count = 0;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT COUNT(*) FROM ProductTable WHERE " + where;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				count = resultSet.getInt("COUNT(*)");
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

		return count;
	}
}
