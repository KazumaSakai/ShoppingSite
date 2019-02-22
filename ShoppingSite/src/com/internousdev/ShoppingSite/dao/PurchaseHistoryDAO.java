package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class PurchaseHistoryDAO extends DAO
{
	public boolean deletePurchaseHistory(int id, int user_id)
	{
		return DeletePurchaseHistory(connection, id, user_id);
	}
	public static boolean DeletePurchaseHistory(int id, int user_id)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = DeletePurchaseHistory(connection, id, user_id);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static boolean DeletePurchaseHistory(Connection connection, int id, int user_id)
	{
		String sql = "DELETE FROM purchasehistorys WHERE id = ? AND user_id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, user_id);

			int line = preparedStatement.executeUpdate();
			if(line > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return false;
	}

	public boolean deletePurchaseHistory(int id)
	{
		return DeletePurchaseHistory(connection, id);
	}
	public static boolean DeletePurchaseHistory(int id)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = DeletePurchaseHistory(connection, id);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static boolean DeletePurchaseHistory(Connection connection,int id)
	{
		String sql = "DELETE FROM purchasehistorys WHERE id = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			int line = preparedStatement.executeUpdate();
			if(line > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return false;
	}

	public List<PurchaseHistoryDTO> getAllPurchaseHistory(int begin, int length)
	{
		return GetAllPurchaseHistory(connection, begin, length);
	}
	public static List<PurchaseHistoryDTO> GetAllPurchaseHistory(int begin, int length)
	{
		Connection connection = DBConnector.getConnection();
		List<PurchaseHistoryDTO> result = GetAllPurchaseHistory(connection, begin, length);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static List<PurchaseHistoryDTO> GetAllPurchaseHistory(Connection connection,int begin, int length)
	{
		String sql = "SELECT  PH.*, I.item_name, I.item_price FROM purchasehistorys AS PH LEFT JOIN items AS I ON PH.item_id = I.id ORDER BY insert_date DESC LIMIT ?, ? ";
		List<PurchaseHistoryDTO> list = new ArrayList<PurchaseHistoryDTO>();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, length);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItem_id(resultSet.getInt("item_id"));
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setUser_id(resultSet.getInt("user_id"));
				dto.setAddress(resultSet.getInt("address"));
				dto.setPhoneNumber(resultSet.getString("phoneNumber"));
				dto.setShipmentState(resultSet.getInt("shipmentState"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setRequest_date(resultSet.getString("request_date"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));

				list.add(dto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return list;
	}

	public List<PurchaseHistoryDTO> getMyPurchaseHistory(int user_id)
	{
		return GetMyPurchaseHistory(connection, user_id);
	}
	public static List<PurchaseHistoryDTO> GetMyPurchaseHistory(int user_id)
	{
		Connection connection = DBConnector.getConnection();
		List<PurchaseHistoryDTO> result = GetMyPurchaseHistory(connection, user_id);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static List<PurchaseHistoryDTO> GetMyPurchaseHistory(Connection connection, int user_id)
	{
		String sql = "SELECT  PH.*, I.item_name, I.item_price FROM purchasehistorys AS PH LEFT JOIN items AS I ON PH.item_id = I.id WHERE PH.user_id = ? ORDER BY insert_date DESC";
		List<PurchaseHistoryDTO> list = new ArrayList<PurchaseHistoryDTO>();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItem_id(resultSet.getInt("item_id"));
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setUser_id(resultSet.getInt("user_id"));
				dto.setAddress(resultSet.getInt("address"));
				dto.setPhoneNumber(resultSet.getString("phoneNumber"));
				dto.setShipmentState(resultSet.getInt("shipmentState"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setRequest_date(resultSet.getString("request_date"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));

				list.add(dto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return list;
	}

	public boolean addPurchaseHistory(PurchaseHistoryDTO purchasehistoryDTO)
	{
		return AddPurchaseHistory(connection, purchasehistoryDTO);
	}
	public static boolean AddPurchaseHistory(PurchaseHistoryDTO purchasehistoryDTO)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = AddPurchaseHistory(connection, purchasehistoryDTO);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static boolean AddPurchaseHistory(Connection connection, PurchaseHistoryDTO purchasehistoryDTO)
	{
		boolean exists = ExistsPurchaseHistory(purchasehistoryDTO);

		if(exists)
		{
			String sql = "UPDATE purchasehistorys SET quantity = quantity + ? WHERE item_id = ? AND user_id = ? AND shipmentState = 0";

			try
			{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, purchasehistoryDTO.getQuantity());
				preparedStatement.setInt(2, purchasehistoryDTO.getItem_id());
				preparedStatement.setInt(3, purchasehistoryDTO.getUser_id());
				int line = preparedStatement.executeUpdate();

				if(line == 0)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			String sql = "INSERT INTO purchasehistorys(item_id, user_id, quantity, shipmentstate, request_date, address, phoneNumber) VALUES(?, ?, ?, ?, ?, ?, ?)";

			try
			{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, purchasehistoryDTO.getItem_id());
				preparedStatement.setInt(2, purchasehistoryDTO.getUser_id());
				preparedStatement.setInt(3, purchasehistoryDTO.getQuantity());
				preparedStatement.setInt(4, purchasehistoryDTO.getShipmentState());
				preparedStatement.setString(5, purchasehistoryDTO.getRequest_date());
				preparedStatement.setInt(6, purchasehistoryDTO.getAddress());
				preparedStatement.setString(7, purchasehistoryDTO.getPhoneNumber());


				int line = preparedStatement.executeUpdate();
				if(line == 0)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();

				try
				{
					connection.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean existsPurchaseHistory(PurchaseHistoryDTO preparedForShipmentDTO)
	{
		return ExistsPurchaseHistory(connection, preparedForShipmentDTO);
	}
	public static boolean ExistsPurchaseHistory(PurchaseHistoryDTO preparedForShipmentDTO)
	{
		Connection connection = DBConnector.getConnection();
		boolean result = ExistsPurchaseHistory(connection, preparedForShipmentDTO);

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	public static boolean ExistsPurchaseHistory(Connection connection, PurchaseHistoryDTO preparedForShipmentDTO)
	{
		String sql = "SELECT COUNT(*) FROM purchasehistorys WHERE item_id = ? AND user_id = ? AND address = ? AND shipmentState = 0";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, preparedForShipmentDTO.getItem_id());
			preparedStatement.setInt(2, preparedForShipmentDTO.getUser_id());
			preparedStatement.setInt(3, preparedForShipmentDTO.getAddress());

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				int count = resultSet.getInt(1);
				if(count > 0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			try
			{
				connection.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		return true;
	}
}
