package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.internousdev.ShoppingSite.util.DateConverter;

public class UserDTO
{
	private int id;
	private boolean isAdmin;
	private boolean isOauthUser;
	private String loginId;
	private String loginPass;
	private String email;
	private String userName;
	private int destinationId;
	private LocalDateTime registeredDate;
	private LocalDateTime lastEditDate;

	public UserDTO() {}
	public UserDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setAdmin(resultSet.getBoolean("isAdmin"));
		this.setOauthUser(resultSet.getBoolean("isOauthUser"));
		this.setLoginId(resultSet.getString("loginId"));
		this.setLoginPass(resultSet.getString("loginPass"));
		this.setEmail(resultSet.getString("email"));
		this.setUserName(resultSet.getString("userName"));
		this.setDestinationId(resultSet.getInt("destinationId"));
		this.setRegisteredDate(resultSet.getString("registeredDate"));
		this.setLastEditDate(resultSet.getString("lastEditDate"));
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public boolean isAdmin()
	{
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	public boolean isOauthUser()
	{
		return isOauthUser;
	}
	public void setOauthUser(boolean isOauthUser)
	{
		this.isOauthUser = isOauthUser;
	}
	public String getLoginId()
	{
		return loginId;
	}
	public void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}
	public String getLoginPass()
	{
		return loginPass;
	}
	public void setLoginPass(String loginPass)
	{
		this.loginPass = loginPass;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getDestinationId()
	{
		return destinationId;
	}
	public void setDestinationId(int destinationId)
	{
		this.destinationId = destinationId;
	}
	public LocalDateTime getRegisteredDate()
	{
		return registeredDate;
	}
	public String getRegisteredDateFormat()
	{
		return DateConverter.toFormat(registeredDate);
	}
	public void setRegisteredDate(LocalDateTime registeredDate)
	{
		this.registeredDate = registeredDate;
	}
	public void setRegisteredDate(String registeredDate)
	{
		this.registeredDate = DateConverter.toLocalDateTime(registeredDate);
	}

	public LocalDateTime getLastEditDate()
	{
		return lastEditDate;
	}
	public String getLastEditDateFormat()
	{
		return DateConverter.toFormat(lastEditDate);
	}
	public void setLastEditDate(LocalDateTime lastEditDate)
	{
		this.lastEditDate = lastEditDate;
	}
	public void setLastEditDate(String lastEditDate)
	{
		this.lastEditDate = DateConverter.toLocalDateTime(lastEditDate);
	}
}
