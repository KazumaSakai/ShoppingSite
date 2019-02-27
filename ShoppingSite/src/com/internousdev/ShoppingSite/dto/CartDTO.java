package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dao.UserDAO;

public class CartDTO
{
	private int userId;
	private UserDTO userDTO;
	private int productId;
	private ProductDTO productDTO;
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
	public UserDTO getUserDTO()
	{
		if(userDTO == null || userDTO.getId() != this.userId)
		{
			userDTO = UserDAO.SelectById(this.userId);
		}
		return userDTO;
	}
	public ProductDTO getProductDTO()
	{
		if(productDTO == null || productDTO.getId() != this.productId)
		{
			productDTO = ProductDAO.Select(this.productId);
		}
		return productDTO;
	}
}
