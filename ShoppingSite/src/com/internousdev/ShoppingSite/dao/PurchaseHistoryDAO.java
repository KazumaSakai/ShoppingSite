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
	public static boolean DeletePurchaseHistory(int id, int user_id)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "DELETE FROM purchasehistorys WHERE id = ? AND user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, user_id);

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

	public static boolean DeletePurchaseHistory(int id)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "DELETE FROM purchasehistorys WHERE id = ?";
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

	public static List<PurchaseHistoryDTO> GetAllPurchaseHistory(int begin, int length)
	{
		List<PurchaseHistoryDTO> list = new ArrayList<PurchaseHistoryDTO>();

		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "SELECT PH.id, PH.item_id, PH.user_id, I.item_name, I.item_price, PH.quantity, PH.address AS addressId, A.address, PH.phoneNumber, PH.shipmentState, PH.insert_date, PH.request_date " + 
							"FROM purchasehistorys AS PH " + 
							"LEFT JOIN items AS I ON (PH.item_id = I.id) " + 
							"LEFT JOIN addressList AS A ON (PH.address = A.id AND PH.user_id = A.user_id) " + 
							"ORDER BY insert_date DESC " + 
							"LIMIT ?, ? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, length);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItem_id(resultSet.getInt("item_id"));
				dto.setUser_id(resultSet.getInt("user_id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setAddress(resultSet.getInt("addressId"));
				dto.setAddressName(resultSet.getString("address"));
				dto.setPhoneNumber(resultSet.getString("phoneNumber"));
				dto.setShipmentState(resultSet.getInt("shipmentState"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setRequest_date(resultSet.getString("request_date"));

				list.add(dto);
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

		return list;
	}

	public static List<PurchaseHistoryDTO> GetMyPurchaseHistory(int user_id, int begin, int length)
	{
		List<PurchaseHistoryDTO> list = new ArrayList<PurchaseHistoryDTO>();

		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = 	"SELECT PH.id, PH.item_id, PH.user_id, I.item_name, I.item_price, PH.quantity, PH.address AS addressId, A.address, PH.phoneNumber, PH.shipmentState, PH.insert_date, PH.request_date " + 
					"FROM purchasehistorys AS PH " + 
					"LEFT JOIN items AS I ON (PH.item_id = I.id) " + 
					"LEFT JOIN addressList AS A ON (PH.address = A.id AND PH.user_id = A.user_id) " + 
					"WHERE PH.user_id = ? " + 
					"ORDER BY insert_date DESC " + 
					"LIMIT ?, ? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, length);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItem_id(resultSet.getInt("item_id"));
				dto.setUser_id(resultSet.getInt("user_id"));
				dto.setItem_name(resultSet.getString("item_name"));
				dto.setItem_price(resultSet.getInt("item_price"));
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setAddress(resultSet.getInt("addressId"));
				dto.setAddressName(resultSet.getString("address"));
				dto.setPhoneNumber(resultSet.getString("phoneNumber"));
				dto.setShipmentState(resultSet.getInt("shipmentState"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setRequest_date(resultSet.getString("request_date"));

				list.add(dto);
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

		return list;
	}

	public static boolean AddPurchaseHistory(PurchaseHistoryDTO purchasehistoryDTO)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();
		
		if(ExistsPurchaseHistory(purchasehistoryDTO))
		{
			try
			{
				String sql = "UPDATE purchasehistorys SET quantity = quantity + ? WHERE item_id = ? AND user_id = ? AND shipmentState = 0";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, purchasehistoryDTO.getQuantity());
				preparedStatement.setInt(2, purchasehistoryDTO.getItem_id());
				preparedStatement.setInt(3, purchasehistoryDTO.getUser_id());
				
				int line = preparedStatement.executeUpdate();
				success = (line > 0);
			}
			catch(SQLException e)
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
		}
		else
		{
			try
			{
				String sql = "INSERT INTO purchasehistorys(item_id, user_id, quantity, shipmentstate, request_date, address, phoneNumber) VALUES(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, purchasehistoryDTO.getItem_id());
				preparedStatement.setInt(2, purchasehistoryDTO.getUser_id());
				preparedStatement.setInt(3, purchasehistoryDTO.getQuantity());
				preparedStatement.setInt(4, purchasehistoryDTO.getShipmentState());
				preparedStatement.setString(5, purchasehistoryDTO.getRequest_date());
				preparedStatement.setInt(6, purchasehistoryDTO.getAddress());
				preparedStatement.setString(7, purchasehistoryDTO.getPhoneNumber());

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
		}
		
		return success;
	}

	public static boolean ExistsPurchaseHistory(PurchaseHistoryDTO preparedForShipmentDTO)
	{
		boolean exist = false;
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "SELECT COUNT(*) FROM purchasehistorys WHERE item_id = ? AND user_id = ? AND address = ? AND shipmentState = 0";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, preparedForShipmentDTO.getItem_id());
			preparedStatement.setInt(2, preparedForShipmentDTO.getUser_id());
			preparedStatement.setInt(3, preparedForShipmentDTO.getAddress());

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				int count = resultSet.getInt(1);
				exist = (count > 0);
			}
			return true;
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

		return exist;
	}
}
