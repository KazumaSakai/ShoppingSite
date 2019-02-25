package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.DBConnector;
import com.internousdev.ShoppingSite.util.Passworder;
import com.mysql.jdbc.Connection;

public class UserDAO
{
	public static boolean Insert(UserDTO userDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "INSERT INTO UserTable(isAdmin, isOauthUser, loginId, loginPass, email, userName, destinationId) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBoolean(1, userDTO.isAdmin());
			preparedStatement.setBoolean(2, userDTO.isOauthUser());
			preparedStatement.setString(3, userDTO.getLoginId());
			preparedStatement.setString(4, userDTO.getLoginPass());
			preparedStatement.setString(5, userDTO.getEmail());
			preparedStatement.setString(6, userDTO.getUserName());
			preparedStatement.setInt(7, userDTO.getDestinationId());
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

	public static UserDTO Select(String where)
	{
		UserDTO userDTO = null;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM UserTable WHERE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, where);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				userDTO = new UserDTO(resultSet);
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

		return userDTO;
	}

	public static UserDTO SelectById(int id)
	{
		return UserDAO.Select("id = " + id);
	}

	public static UserDTO SelectByLoginId(String loginId)
	{
		return UserDAO.Select("loginId = " + loginId);
	}

	public static boolean Update(UserDTO userDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE UserTable SET isAdmin = ?, isOauthUser = ?, loginId = ?, loginPass = ?, email = ?, userName = ?, destinationId = ?, lastEditDate = now()) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBoolean(1, userDTO.isAdmin());
			preparedStatement.setBoolean(2, userDTO.isOauthUser());
			preparedStatement.setString(3, userDTO.getLoginId());
			preparedStatement.setString(4, userDTO.getLoginPass());
			preparedStatement.setString(5, userDTO.getEmail());
			preparedStatement.setString(6, userDTO.getUserName());
			preparedStatement.setInt(7, userDTO.getDestinationId());

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

	public static List<UserDTO> SelectList(int begin, int length)
	{
		return SelectList(begin, length, "1");
	}

	public static List<UserDTO> SelectList(int begin, int length, String where)
	{
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT * FROM UserTable WHERE ? LIMIT ?, ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, where);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, length);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				userDTOList.add(new UserDTO(resultSet));
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

		return userDTOList;
	}

	public static int Count(String where)
	{
		int count = 0;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "SELECT COUNT(*) FROM UserTable WHERE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, where);

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

	public static boolean ExistLoginId(String loginId)
	{
		return (UserDAO.Count("loginId = " + loginId) > 0);
	}

	public static UserDTO Login(String loginId, String planeLoginPass)
	{
		UserDTO userDTO = UserDAO.SelectByLoginId(loginId);

		if (userDTO == null) return null;

		String DBSafePassword = userDTO.getLoginPass();
		String safePassword = Passworder.getSafetyPassword(planeLoginPass, loginId);

		return DBSafePassword.equals(safePassword) ? userDTO : null;
	}

	public static boolean LoginCheck(String loginId, String planeLoginPass)
	{
		return (UserDAO.Login(loginId, planeLoginPass) != null);
	}
}
