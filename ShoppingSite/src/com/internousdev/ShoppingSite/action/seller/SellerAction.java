package com.internousdev.ShoppingSite.action.seller;

import com.internousdev.ShoppingSite.dao.SellerDAO;
import com.internousdev.ShoppingSite.dto.SellerDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SellerAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	//	Receive
	private int id;
	
	//	Send
	private SellerDTO sellerDTO;

	//	Execute
	public String execute()
	{
		sellerDTO = SellerDAO.GetSeller(id);

		return SUCCESS;
	}

	//	Getter Setter
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public SellerDTO getSellerDTO()
	{
		return sellerDTO;
	}
	public void setSellerDTO(SellerDTO sellerDTO)
	{
		this.sellerDTO = sellerDTO;
	}


}
