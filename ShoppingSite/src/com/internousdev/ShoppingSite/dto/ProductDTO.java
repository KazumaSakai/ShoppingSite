package com.internousdev.ShoppingSite.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDTO
{
	private int id;
	private String productName;
	private int productPrice;
	private int productQuantity;
	private String productDescription;
	private int salesCompanyId;
	private int productionCompanyId;
	private int imageQuantity;
	private Date releasedDate;
	private Date lastEditDate;
	private Date lastReplenishmentDate;
	private Date lastSalesDate;

	public ProductDTO() {}
	public ProductDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setProductName(resultSet.getString("productName"));
		this.setProductPrice(resultSet.getInt("productPrice"));
		this.setProductQuantity(resultSet.getInt("productQuantity"));
		this.setProductDescription(resultSet.getString("productDescription"));
		this.setSalesCompanyId(resultSet.getInt("salesCompanyId"));
		this.setProductionCompanyId(resultSet.getInt("productionCompanyId"));
		this.setImageQuantity(resultSet.getInt("imageQuantity"));
		this.setReleasedDate(resultSet.getDate("releasedDate"));
		this.setLastReplenishmentDate(resultSet.getDate("lastReplenishmentDate"));
		this.setLastSalesDate(resultSet.getDate("lastSalesDate"));
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public int getProductPrice()
	{
		return productPrice;
	}
	public void setProductPrice(int productPrice)
	{
		this.productPrice = productPrice;
	}
	public int getProductQuantity()
	{
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity)
	{
		this.productQuantity = productQuantity;
	}
	public String getProductDescription()
	{
		return productDescription;
	}
	public void setProductDescription(String productDescription)
	{
		this.productDescription = productDescription;
	}
	public int getSalesCompanyId()
	{
		return salesCompanyId;
	}
	public void setSalesCompanyId(int salesCompanyId)
	{
		this.salesCompanyId = salesCompanyId;
	}
	public int getProductionCompanyId()
	{
		return productionCompanyId;
	}
	public void setProductionCompanyId(int productionCompanyId)
	{
		this.productionCompanyId = productionCompanyId;
	}
	public int getImageQuantity()
	{
		return imageQuantity;
	}
	public void setImageQuantity(int imageQuantity)
	{
		this.imageQuantity = imageQuantity;
	}
	public Date getReleasedDate()
	{
		return releasedDate;
	}
	public void setReleasedDate(Date releasedDate)
	{
		this.releasedDate = releasedDate;
	}
	public Date getLastEditDate()
	{
		return lastEditDate;
	}
	public void setLastEditDate(Date lastEditDate)
	{
		this.lastEditDate = lastEditDate;
	}
	public Date getLastReplenishmentDate()
	{
		return lastReplenishmentDate;
	}
	public void setLastReplenishmentDate(Date lastReplenishmentDate)
	{
		this.lastReplenishmentDate = lastReplenishmentDate;
	}
	public Date getLastSalesDate()
	{
		return lastSalesDate;
	}
	public void setLastSalesDate(Date lastSalesDate)
	{
		this.lastSalesDate = lastSalesDate;
	}
}
