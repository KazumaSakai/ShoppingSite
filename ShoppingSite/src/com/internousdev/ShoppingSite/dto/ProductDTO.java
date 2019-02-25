package com.internousdev.ShoppingSite.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.internousdev.ShoppingSite.util.DateConverter;

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
	private LocalDateTime releasedDate;
	private LocalDateTime lastEditDate;
	private LocalDateTime lastReplenishmentDate;
	private LocalDateTime lastSalesDate;

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
		this.setReleasedDate(resultSet.getString("releasedDate"));
		this.setLastEditDate(resultSet.getString("lastEditDate"));
		this.setLastReplenishmentDate(resultSet.getString("lastReplenishmentDate"));
		this.setLastSalesDate(resultSet.getString("lastSalesDate"));
	}

	public PurchaseHistoryDTO toPurchaseHistoryDTO(int userId, int destinationId, int shipmentState, LocalDateTime requestDeliveryDate)
	{
		PurchaseHistoryDTO purchaseHistoryDTO = new PurchaseHistoryDTO();

		purchaseHistoryDTO.setProductId(id);
		purchaseHistoryDTO.setProductQuantity(productQuantity);
		purchaseHistoryDTO.setUserId(userId);
		purchaseHistoryDTO.setDestinationId(destinationId);
		purchaseHistoryDTO.setShipmentState(shipmentState);
		purchaseHistoryDTO.setRequestDeliveryDate(requestDeliveryDate);

		return purchaseHistoryDTO;
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
	public LocalDateTime getReleasedDate()
	{
		return releasedDate;
	}
	public void setReleasedDate(LocalDateTime releasedDate)
	{
		this.releasedDate = releasedDate;
	}
	public void setReleasedDate(String releasedDate)
	{
		this.releasedDate = DateConverter.toLocalDateTime(releasedDate);
	}
	public LocalDateTime getLastEditDate()
	{
		return lastEditDate;
	}
	public void setLastEditDate(LocalDateTime lastEditDate)
	{
		this.lastEditDate = lastEditDate;
	}
	public void setLastEditDate(String lastEditDate)
	{
		this.lastEditDate = DateConverter.toLocalDateTime(lastEditDate);
	}
	public LocalDateTime getLastReplenishmentDate()
	{
		return lastReplenishmentDate;
	}
	public void setLastReplenishmentDate(LocalDateTime lastReplenishmentDate)
	{
		this.lastReplenishmentDate = lastReplenishmentDate;
	}
	public void setLastReplenishmentDate(String lastReplenishmentDate)
	{
		this.lastReplenishmentDate = DateConverter.toLocalDateTime(lastReplenishmentDate);
	}
	public LocalDateTime getLastSalesDate()
	{
		return lastSalesDate;
	}
	public void setLastSalesDate(LocalDateTime lastSalesDate)
	{
		this.lastSalesDate = lastSalesDate;
	}
	public void setLastSalesDate(String lastSalesDate)
	{
		this.lastSalesDate = DateConverter.toLocalDateTime(lastSalesDate);
	}
}
