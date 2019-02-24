package com.internousdev.ShoppingSite.dto;

public class PurchaseHistoryDTO
{
	private int id;
	private int item_id;
	private int quantity;
	private int user_id;
	private String insert_date;
	private String request_date;
	private int address;
	private String addressName;
	private String phoneNumber;
	private int shipmentState;
	private String item_name;
	private int item_price;

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public int getItem_id()
	{
		return item_id;
	}
	public void setItem_id(int item_id)
	{
		this.item_id = item_id;
	}

	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public int getUser_id()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getInsert_date()
	{
		return insert_date;
	}
	public void setInsert_date(String insert_date)
	{
		String[] date_seconds = insert_date.split(" ");
		String[] dates = date_seconds[0].split("-");
		String[] seconds = date_seconds[1].split(":");

		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(dates[0]).append("年").append(dates[1]).append("月").append(dates[2]).append("日 ").append(seconds[0]).append("時");

		this.insert_date = sBuilder.toString();
	}

	public String getRequest_date()
	{
		return request_date;
	}
	public void setRequest_date(String request_date)
	{
		String[] date_seconds = request_date.split(" ");
		String[] dates = date_seconds[0].split("-");
		String[] seconds = date_seconds[1].split(":");

		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(dates[0]).append("年").append(dates[1]).append("月").append(dates[2]).append("日 ").append(seconds[0]).append("時");

		this.request_date = sBuilder.toString();
	}

	public int getAddress()
	{
		return address;
	}
	public void setAddress(int address)
	{
		this.address = address;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public int getShipmentState()
	{
		return shipmentState;
	}
	public void setShipmentState(int shipmentState)
	{
		this.shipmentState = shipmentState;
	}

	public String getItem_name()
	{
		return item_name;
	}
	public void setItem_name(String item_name)
	{
		this.item_name = item_name;
	}

	public int getItem_price()
	{
		return item_price;
	}
	public void setItem_price(int item_price)
	{
		this.item_price = item_price;
	}

	public String getAddressName()
	{
		return addressName;
	}
	public void setAddressName(String addressName)
	{
		this.addressName = addressName;
	}

}
