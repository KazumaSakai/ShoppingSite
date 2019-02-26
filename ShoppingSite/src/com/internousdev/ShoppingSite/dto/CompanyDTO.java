package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ShoppingSite.dao.DestinationDAO;
import com.internousdev.ShoppingSite.dao.UserDAO;

public class CompanyDTO
{
	private int id;
	private int userId;
	private UserDTO userDTO;
	private int destinationId;
	private DestinationDTO destinationDTO;
	private String companyName;
	private String companyDescription;

	public CompanyDTO() {}
	public CompanyDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setUserId(resultSet.getInt("userId"));
		this.setDestinationId(resultSet.getInt("destinationId"));
		this.setCompanyName(resultSet.getString("companyName"));
		this.setCompanyDescription(resultSet.getString("companyDescription"));
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getDestinationId()
	{
		return destinationId;
	}
	public void setDestinationId(int destinationId)
	{
		this.destinationId = destinationId;
	}
	public String getCompanyName()
	{
		return companyName;
	}
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	public String getCompanyDescription()
	{
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription)
	{
		this.companyDescription = companyDescription;
	}
	public UserDTO getUserDTO()
	{
		if(userDTO == null || userDTO.getId() != userId)
		{
			userDTO = UserDAO.SelectById(userId);
		}
		return userDTO;
	}
	public DestinationDTO getDestinationDTO()
	{
		if(destinationDTO == null || destinationDTO.getId() != destinationId)
		{
			destinationDTO = DestinationDAO.Select(destinationId);
		}
		return destinationDTO;
	}
}
