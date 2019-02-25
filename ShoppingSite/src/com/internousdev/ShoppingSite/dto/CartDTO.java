package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CartDTO
{
	private int userId;
	private int productId;
	private int productQuantity;

	public CartDTO() {}
	public CartDTO(ResultSet resultSet) throws SQLException
	{
		this.setUserId(resultSet.getInt("userId"));
		this.setProductId(resultSet.getInt("productId"));
		this.setProductQuantity(resultSet.getInt("productQuantity"));
	}

	public PurchaseHistoryDTO toPurchaseHistoryDTO(int destinationId, int shipmentState, LocalDateTime requestDeliveryDate)
	{
		PurchaseHistoryDTO purchaseHistoryDTO = new PurchaseHistoryDTO();

		purchaseHistoryDTO.setProductId(productId);
		purchaseHistoryDTO.setProductQuantity(productQuantity);
		purchaseHistoryDTO.setUserId(userId);
		purchaseHistoryDTO.setDestinationId(destinationId);
		purchaseHistoryDTO.setShipmentState(shipmentState);
		purchaseHistoryDTO.setRequestDeliveryDate(requestDeliveryDate);

		return purchaseHistoryDTO;
	}

	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
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
}
