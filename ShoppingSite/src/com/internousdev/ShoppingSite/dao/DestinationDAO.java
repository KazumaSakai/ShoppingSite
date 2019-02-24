package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.DestinationDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class DestinationDAO extends DAO
{
	/**
	 * 	住所をIDから取得する
	 * @param id
	 * 	住所ID
	 * @return
	 * 	住所
	 */
	public static DestinationDTO GetDestinationById(int id)
	{
		DestinationDTO destinationDTO = null;
		
		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM DestinationTable WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next())
			{
				destinationDTO = new DestinationDTO();
				destinationDTO.setId(resultSet.getInt("id"));
				destinationDTO.setUserId(resultSet.getInt("userId"));
				destinationDTO.setFamilyName(resultSet.getString("familyName"));
				destinationDTO.setFamilyName(resultSet.getString("firstName"));
				destinationDTO.setGender(resultSet.getInt("gender"));
				destinationDTO.setPostalCode(resultSet.getString("postalCode"));
				destinationDTO.setAddress(resultSet.getString("address"));
				destinationDTO.setEmail(resultSet.getString("email"));
				destinationDTO.setPhoneNumber(resultSet.getString("phoneNumber"));
				destinationDTO.setRegisteredDate(resultSet.getDate("registeredDate"));
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
				if(connection != null) connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return destinationDTO;
	}

	/**
	 * 	住所を登録する
	 * @param user_id
	 * 	ユーザーID
	 * @param address
	 * 	住所
	 * @return
	 * 	結果
	 */
	public static boolean AddAddress(int userId, String familyName, String firstName, int gender, String postalCode, String address, String email, String phoneNumber)
	{
		boolean success = false;
		
		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "INSERT INTO DestinationTable(userId, familyName, firstName, gender, postalCode, address, email, phoneNumber) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, familyName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setInt(4, gender);
			preparedStatement.setString(5, postalCode);
			preparedStatement.setString(6, address);
			preparedStatement.setString(7, email);
			preparedStatement.setString(8, phoneNumber);

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
				if(connection != null) connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return success;
	}

	/**
	 * 住所のリストをユーザーIDから取得する
	 * @param userId
	 * 	対象のユーザーID
	 * @return
	 * 	住所のリスト
	 */
	public static List<DestinationDTO> GetAddressListByUserId(int userId)
	{
		List<DestinationDTO> destinationDTOList = new ArrayList<DestinationDTO>();

		Connection connection = DBConnector.createConnection();
		
		try
		{
			String sql = "SELECT * FROM DestinationTable WHERE user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				DestinationDTO destinationDTO = new DestinationDTO();
				destinationDTO = new DestinationDTO();
				destinationDTO.setId(resultSet.getInt("id"));
				destinationDTO.setUserId(resultSet.getInt("userId"));
				destinationDTO.setFamilyName(resultSet.getString("familyName"));
				destinationDTO.setFamilyName(resultSet.getString("firstName"));
				destinationDTO.setGender(resultSet.getInt("gender"));
				destinationDTO.setPostalCode(resultSet.getString("postalCode"));
				destinationDTO.setAddress(resultSet.getString("address"));
				destinationDTO.setEmail(resultSet.getString("email"));
				destinationDTO.setPhoneNumber(resultSet.getString("phoneNumber"));
				destinationDTO.setRegisteredDate(resultSet.getDate("registeredDate"));
				destinationDTOList.add(destinationDTO);
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
				if(connection != null) connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return destinationDTOList;
	}
}
