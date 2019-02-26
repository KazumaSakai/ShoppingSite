package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.DestinationDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class DestinationDAO
{
	public static boolean Insert(DestinationDTO destinationDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO DestinationTable(userId, familyName, firstName, gender, postalCode, address, email, phoneNumber) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, destinationDTO.getUserId());
			preparedStatement.setString(2, destinationDTO.getFamilyName());
			preparedStatement.setString(3, destinationDTO.getFirstName());
			preparedStatement.setInt(4, destinationDTO.getGender());
			preparedStatement.setString(5, destinationDTO.getPostalCode());
			preparedStatement.setString(6, destinationDTO.getAddress());
			preparedStatement.setString(7, destinationDTO.getEmail());
			preparedStatement.setString(8, destinationDTO.getPhoneNumber());

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

	public static DestinationDTO Select(int id)
	{
		DestinationDTO destinationDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM DestinationTable WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				destinationDTO = new DestinationDTO(resultSet);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return destinationDTO;
	}

	public static boolean Update(DestinationDTO destinationDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE DestinationTable SET familyName = ?, firstName = ?, gender = ?, postalCode = ?, address = ?, email = ?, phoneNumber = ? WHERE id = ? AND userId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, destinationDTO.getFamilyName());
			preparedStatement.setString(2, destinationDTO.getFirstName());
			preparedStatement.setInt(3, destinationDTO.getGender());
			preparedStatement.setString(4, destinationDTO.getPostalCode());
			preparedStatement.setString(5, destinationDTO.getAddress());
			preparedStatement.setString(6, destinationDTO.getEmail());
			preparedStatement.setString(7, destinationDTO.getPhoneNumber());
			preparedStatement.setInt(8, destinationDTO.getId());
			preparedStatement.setInt(9, destinationDTO.getUserId());

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
			String sql = MessageFormat.format("DELETE FROM DestinationTable WHERE {0}", where);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

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
		return Delete(MessageFormat.format("id = ''{0}''", id));
	}

	public static boolean DeleteByUserId(int userId)
	{
		return Delete(MessageFormat.format("userId = ''{0}''", userId));
	}

	public static boolean DeleteByIdAndUserId(int id, int userId)
	{
		return Delete(MessageFormat.format("id = ''{0}'' AND userId = ''{1}''", id, userId));
	}

	public static List<DestinationDTO> SelectList(int begin, int length, String where)
	{
		List<DestinationDTO> destinationDTOList = new ArrayList<DestinationDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = MessageFormat.format("SELECT * FROM DestinationTable WHERE {0} LIMIT {1}, {2}", where, begin, length);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				destinationDTOList.add(new DestinationDTO(resultSet));
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

		return destinationDTOList;
	}

	public static List<DestinationDTO> SelectList(int begin, int length)
	{
		return DestinationDAO.SelectList(begin, length, "1");
	}

	public static List<DestinationDTO> SelectListByUserId(int begin, int length, int userId)
	{
		return DestinationDAO.SelectList(begin, length, MessageFormat.format("userId = ''{0}''", userId));
	}
}
