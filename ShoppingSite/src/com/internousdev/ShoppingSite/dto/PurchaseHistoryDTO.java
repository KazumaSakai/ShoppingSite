package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.internousdev.ShoppingSite.util.DateConverter;

public class PurchaseHistoryDTO
{
	private int id;
	private int productId;
	private int productQuantity;
	private int userId;
	private int destinationId;
	private int shipmentState;
	private LocalDateTime purchasedDate;
	private LocalDateTime requestDeliveryDate;

	public PurchaseHistoryDTO() {}
	public PurchaseHistoryDTO(ResultSet resultSet) throws SQLException
	{
		this.setId(resultSet.getInt("id"));
		this.setProductId(resultSet.getInt("productId"));
		this.setProductQuantity(resultSet.getInt("productQuantity"));
		this.setUserId(resultSet.getInt("userId"));
		this.setDestinationId(resultSet.getInt("destinationId"));
		this.setShipmentState(resultSet.getInt("shipmentState"));
		this.setPurchasedDate(resultSet.getString("purchasedDate"));
		this.setRequestDeliveryDate(resultSet.getString("requestDeliveryDate"));
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
	public LocalDateTime getPurchasedDate()
	{
		return purchasedDate;
	}
	public void setPurchasedDate(LocalDateTime purchasedDate)
	{
		this.purchasedDate = purchasedDate;
	}
	public void setPurchasedDate(String purchasedDate)
	{
		this.purchasedDate = DateConverter.toLocalDateTime(purchasedDate);
	}
	public LocalDateTime getRequestDeliveryDate()
	{
		return requestDeliveryDate;
	}
	public void setRequestDeliveryDate(LocalDateTime requestDeliveryDate)
	{
		this.requestDeliveryDate = requestDeliveryDate;
	}
	public void setRequestDeliveryDate(String requestDeliveryDate)
	{
		this.requestDeliveryDate = DateConverter.toLocalDateTime(requestDeliveryDate);
	}
}
