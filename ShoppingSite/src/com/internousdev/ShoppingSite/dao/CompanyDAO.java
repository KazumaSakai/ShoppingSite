package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.CompanyDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.mysql.jdbc.Connection;

public class CompanyDAO
{
	public static boolean Insert(CompanyDTO companyDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO ComapyTable(userId, destinationId, companyName, companyDescription) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, companyDTO.getUserId());
			preparedStatement.setInt(2, companyDTO.getDestinationId());
			preparedStatement.setString(3, companyDTO.getCompanyName());
			preparedStatement.setString(4, companyDTO.getCompanyDescription());

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

	public static CompanyDTO Select(int id)
	{
		CompanyDTO companyDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM CompanyTable WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				companyDTO = new CompanyDTO(resultSet);
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

		return companyDTO;
	}

	public static boolean Update(CompanyDTO companyDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE ComapyTable SET userId = ?, destinationId = ?, companyName = ?, companyDescription = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, companyDTO.getUserId());
			preparedStatement.setInt(2, companyDTO.getDestinationId());
			preparedStatement.setString(3, companyDTO.getCompanyName());
			preparedStatement.setString(4, companyDTO.getCompanyDescription());
			preparedStatement.setInt(5, companyDTO.getId());

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
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "DELETE FROM CompanyTable WHERE id = ?";
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

	public static List<CompanyDTO> SelectList(int begin, int length, String where)
	{
		List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = MessageFormat.format("SELECT * FROM CompanyTable WHERE {0}", where);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				companyDTOList.add(new CompanyDTO(resultSet));
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

		return companyDTOList;
	}

	public static List<CompanyDTO> SelectList(int begin, int length)
	{
		return CompanyDAO.SelectList(begin, length, "1");
	}

	public static List<CompanyDTO> SelectListByCompanyName(int begin, int length, String companyName)
	{
		StringBuilder where = new StringBuilder();
		where.append("companyName LIKE '%").append(companyName).append("%'");
		return CompanyDAO.SelectList(begin, length, where.toString());
	}
}
