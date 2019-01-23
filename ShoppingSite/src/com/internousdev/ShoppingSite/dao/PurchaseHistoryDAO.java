package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.DBConnector;

public class PurchaseHistoryDAO
{
	public static List<PurchaseHistoryDTO> GetAllPurchaseHistory(int begin, int length)
	{
		String sql = "SELECT  PH.*, I.item_name, I.item_price FROM purchasehistorys AS PH LEFT JOIN items AS I ON PH.item_id = I.id ORDER BY insert_date DESC LIMIT ?, ? ";
		List<PurchaseHistoryDTO> list = new ArrayList<PurchaseHistoryDTO>();
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, length);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				int get_id = resultSet.getInt("id");
				int get_item_id = resultSet.getInt("item_id");
				int get_quantity = resultSet.getInt("quantity");
				int get_user_id = resultSet.getInt("user_id");
				int get_shipmentState = resultSet.getInt("shipmentState");
				String get_addres = resultSet.getString("address");
				String get_phoneNumber = resultSet.getString("phoneNumber");
				String get_insert_date = resultSet.getString("insert_date");
				String get_request_date = resultSet.getString("request_date");
				
				String get_item_name = resultSet.getString("item_name");
				int get_item_price = resultSet.getInt("item_price");

				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
				
				dto.setId(get_id);
				dto.setItem_id(get_item_id);
				dto.setQuantity(get_quantity);
				dto.setUser_id(get_user_id);
				dto.setAddress(get_addres);
				dto.setPhoneNumber(get_phoneNumber);
				dto.setShipmentState(get_shipmentState);
				dto.setInsert_date(get_insert_date);
				dto.setRequest_date(get_request_date);
				
				dto.setItem_name(get_item_name);
				dto.setItem_price(get_item_price);
				
				list.add(dto);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<PurchaseHistoryDTO>  GetMyPurchaseHistory(int user_id)
	{
		String sql = "SELECT  PH.*, I.item_name, I.item_price FROM purchasehistorys AS PH LEFT JOIN items AS I ON PH.item_id = I.id WHERE PH.user_id = ? ORDER BY insert_date DESC";
		List<PurchaseHistoryDTO> list = new ArrayList<PurchaseHistoryDTO>();
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				int get_id = resultSet.getInt("id");
				int get_item_id = resultSet.getInt("item_id");
				int get_quantity = resultSet.getInt("quantity");
				int get_user_id = resultSet.getInt("user_id");
				int get_shipmentState = resultSet.getInt("shipmentState");
				String get_addres = resultSet.getString("address");
				String get_phoneNumber = resultSet.getString("phoneNumber");
				String get_insert_date = resultSet.getString("insert_date");
				String get_request_date = resultSet.getString("request_date");
				
				String get_item_name = resultSet.getString("item_name");
				int get_item_price = resultSet.getInt("item_price");

				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
				
				dto.setId(get_id);
				dto.setItem_id(get_item_id);
				dto.setQuantity(get_quantity);
				dto.setUser_id(get_user_id);
				dto.setAddress(get_addres);
				dto.setPhoneNumber(get_phoneNumber);
				dto.setShipmentState(get_shipmentState);
				dto.setInsert_date(get_insert_date);
				dto.setRequest_date(get_request_date);
				
				dto.setItem_name(get_item_name);
				dto.setItem_price(get_item_price);
				
				list.add(dto);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static boolean AddPurchaseHistory(PurchaseHistoryDTO preparedForShipmentDTO)
	{
		boolean exists = ExistsPurchaseHistory(preparedForShipmentDTO);
		
		if(exists)
		{
			String sql = "UPDATE purchasehistorys SET quantity = quantity + ? WHERE item_id = ? AND user_id = ? shipmentState = 0";
			
			try
			{
				PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
				preparedStatement.setInt(1, preparedForShipmentDTO.getQuantity());
				preparedStatement.setInt(2, preparedForShipmentDTO.getItem_id());
				preparedStatement.setInt(3, preparedForShipmentDTO.getUser_id());
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
				PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
				preparedStatement.setInt(1, preparedForShipmentDTO.getItem_id());
				preparedStatement.setInt(2, preparedForShipmentDTO.getUser_id());
				preparedStatement.setInt(3, preparedForShipmentDTO.getQuantity());
				preparedStatement.setInt(4, preparedForShipmentDTO.getShipmentState());
				preparedStatement.setString(5, preparedForShipmentDTO.getRequest_date());
				preparedStatement.setString(6, preparedForShipmentDTO.getAddress());
				preparedStatement.setString(7, preparedForShipmentDTO.getPhoneNumber());
				
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
		return false;
	}
	
	public static boolean ExistsPurchaseHistory(PurchaseHistoryDTO preparedForShipmentDTO)
	{
		String sql = "SELECT COUNT(*) FROM purchasehistorys WHERE item_id = ? AND user_id = ? AND address = ?";
		
		try
		{
			PreparedStatement preparedStatement = DBConnector.connection().prepareStatement(sql);
			preparedStatement.setInt(1, preparedForShipmentDTO.getItem_id());
			preparedStatement.setInt(2, preparedForShipmentDTO.getUser_id());
			preparedStatement.setString(3, preparedForShipmentDTO.getAddress());
			
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
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
}
