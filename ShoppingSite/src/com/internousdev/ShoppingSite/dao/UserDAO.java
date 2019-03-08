package com.internousdev.ShoppingSite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
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
			String sql = MessageFormat.format("SELECT * FROM UserTable WHERE {0}", where);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

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
		return UserDAO.Select(MessageFormat.format("id = ''{0}''", id));
	}

	public static UserDTO SelectByLoginId(String loginId)
	{
		return UserDAO.Select(MessageFormat.format("loginId = ''{0}''", loginId));
	}

	public static UserDTO SelectByEmail(String email)
	{
		return UserDAO.Select(MessageFormat.format("email = ''{0}''", email));
	}

	public static boolean Update(UserDTO userDTO)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "UPDATE UserTable SET isAdmin = ?, isOauthUser = ?, loginPass = ?, userName = ?, lastEditDate = now() WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBoolean(1, userDTO.isAdmin());
			preparedStatement.setBoolean(2, userDTO.isOauthUser());
			preparedStatement.setString(3, userDTO.getLoginPass());
			preparedStatement.setString(4, userDTO.getUserName());
			preparedStatement.setInt(5, userDTO.getId());

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
			String sql = MessageFormat.format("SELECT * FROM UserTable WHERE {0} LIMIT {1}, {2}", where, begin, length);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

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
			String sql = MessageFormat.format("SELECT COUNT(*) FROM UserTable WHERE {0}", where);
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
	
	public static int Count()
	{
		return Count("1");
	}

	public static boolean ExistLoginId(String loginId)
	{
		return (UserDAO.Count(MessageFormat.format("loginId = ''{0}''", loginId)) > 0);
	}

	public static UserDTO Login(String loginId, String planeLoginPass)
	{
		UserDTO userDTO = UserDAO.SelectByLoginId(loginId);

		if (userDTO == null) return null;

		String dbSafePassword = userDTO.getLoginPass();
		String safePassword = Passworder.getSafetyPassword(planeLoginPass, loginId);

		return dbSafePassword.equals(safePassword) ? userDTO : null;
	}

	public static UserDTO LoginByEmail(String email, String planeLoginPass)
	{
		UserDTO userDTO = UserDAO.SelectByEmail(email);

		if (userDTO == null) return null;

		String DBSafePassword = userDTO.getLoginPass();
		String safePassword = Passworder.getSafetyPassword(planeLoginPass, email);

		return DBSafePassword.equals(safePassword) ? userDTO : null;
	}

	public static UserDTO LoginByOAuthUser(String email)
	{
		UserDTO userDTO = UserDAO.SelectByEmail(email);

		if (userDTO == null) return null;

		return userDTO.isOauthUser() ? userDTO : null;
	}

	public static boolean LoginCheck(String loginId, String planeLoginPass)
	{
		return (UserDAO.Login(loginId, planeLoginPass) != null);
	}

	public static boolean DeleteById(int id)
	{
		boolean success = false;

		Connection connection = DBConnector.createConnection();

		try
		{
			String sql = "DELETE FROM UserTable WHERE id = ?";
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

}
