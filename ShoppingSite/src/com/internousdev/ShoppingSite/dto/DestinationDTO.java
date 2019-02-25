package com.internousdev.ShoppingSite.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DestinationDTO
{
	private int id;
	private int userId;
	private String familyName;
	private String firstName;
	private int gender;
	private String postalCode;
	private String address;
	private String email;
	private String phoneNumber;
	private Date registeredDate;

	public DestinationDTO() {}
	public DestinationDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setUserId(resultSet.getInt("userId"));
		this.setFamilyName(resultSet.getString("familyName"));
		this.setFirstName(resultSet.getString("firstName"));
		this.setGender(resultSet.getInt("gender"));
		this.setPostalCode(resultSet.getString("postalCode"));
		this.setAddress(resultSet.getString("address"));
		this.setEmail(resultSet.getString("email"));
		this.setPhoneNumber(resultSet.getString("phoneNumber"));
		this.setRegisteredDate(resultSet.getDate("registeredDate"));
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

	public String getFamilyName()
	{
		return familyName;
	}
	public void setFamilyName(String familyName)
	{
		this.familyName = familyName;
	}

	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public int getGender()
	{
		return gender;
	}
	public void setGender(int gender)
	{
		this.gender = gender;
	}

	public String getPostalCode()
	{
		return postalCode;
	}
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public Date getRegisteredDate()
	{
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate)
	{
		this.registeredDate = registeredDate;
	}
}
