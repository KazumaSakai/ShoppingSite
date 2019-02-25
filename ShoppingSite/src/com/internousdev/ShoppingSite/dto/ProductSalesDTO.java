package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSalesDTO
{
	private int productId;
	private int salesQuantity;
	private int totalSales;
	private int totalRevenue;
	private int salesYear;
	private int salesMonth;

	public ProductSalesDTO() {}
	public ProductSalesDTO(int year, int month)
	{
		this.setSalesYear(year);
		this.setSalesMonth(month);
	}
	public ProductSalesDTO(ResultSet resultSet) throws SQLException
	{
		this.setProductId(resultSet.getInt("productId"));
		this.setSalesQuantity(resultSet.getInt("salesQuantity"));
		this.setTotalSales(resultSet.getInt("totalSales"));
		this.setTotalRevenue(resultSet.getInt("totalRevenue"));
		this.setSalesYear(resultSet.getInt("salesYear"));
		this.setSalesMonth(resultSet.getInt("salesMonth"));
	}

	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	public int getSalesQuantity()
	{
		return salesQuantity;
	}
	public void setSalesQuantity(int salesQuantity)
	{
		this.salesQuantity = salesQuantity;
	}
	public int getTotalSales()
	{
		return totalSales;
	}
	public void setTotalSales(int totalSales)
	{
		this.totalSales = totalSales;
	}
	public int getTotalRevenue()
	{
		return totalRevenue;
	}
	public void setTotalRevenue(int totalRevenue)
	{
		this.totalRevenue = totalRevenue;
	}
	public int getSalesYear()
	{
		return salesYear;
	}
	public void setSalesYear(int salesYear)
	{
		this.salesYear = salesYear;
	}
	public int getSalesMonth()
	{
		return salesMonth;
	}
	public void setSalesMonth(int salesMonth)
	{
		this.salesMonth = salesMonth;
	}
}
