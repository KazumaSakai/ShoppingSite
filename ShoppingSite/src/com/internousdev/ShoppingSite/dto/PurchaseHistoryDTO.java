package com.internousdev.ShoppingSite.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseHistoryDTO
{
	private int id;
	private int productId;
	private int productQuantity;
	private int userId;
	private int destinationId;
	private int shipmentState;
	private Date purchasedDate;
	private Date requestDeliveryDate;

	public PurchaseHistoryDTO() {}
	public PurchaseHistoryDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setProductId(resultSet.getInt("productId"));
		this.setProductQuantity(resultSet.getInt("productQuantity"));
		this.setUserId(resultSet.getInt("userId"));
		this.setDestinationId(resultSet.getInt("destinationId"));
		this.setShipmentState(resultSet.getInt("shipmentState"));
		this.setPurchasedDate(resultSet.getDate("purchasedDate"));
		this.setRequestDeliveryDate(resultSet.getDate("requestDeliveryDate"));
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	public int getProductQuantity()
	{
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity)
	{
		this.productQuantity = productQuantity;
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
	public int getShipmentState()
	{
		return shipmentState;
	}
	public void setShipmentState(int shipmentState)
	{
		this.shipmentState = shipmentState;
	}
	public Date getPurchasedDate()
	{
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate)
	{
		this.purchasedDate = purchasedDate;
	}
	public Date getRequestDeliveryDate()
	{
		return requestDeliveryDate;
	}
	public void setRequestDeliveryDate(Date requestDeliveryDate)
	{
		this.requestDeliveryDate = requestDeliveryDate;
	}
}
