package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDTO
{
	private int id;
	private int userId;
	private int destinationId;
	private String companyName;
	private String companyDescription;

	public CompanyDTO() {}
	public CompanyDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setId(resultSet.getInt("userId"));
		this.setId(resultSet.getInt("destinationId"));
		this.setId(resultSet.getInt("companyName"));
		this.setId(resultSet.getInt("companyDescription"));
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
}
