package com.internousdev.ShoppingSite.action.seller;

import com.internousdev.ShoppingSite.dao.SellerDAO;
import com.internousdev.ShoppingSite.dto.SellerDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SellerAction extends ActionSupport
{
	private int id;
	private SellerDTO sellerDTO;

	public String execute()
	{
		sellerDTO = SellerDAO.GetSeller(id);

		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SellerDTO getSellerDTO() {
		return sellerDTO;
	}

	public void setSellerDTO(SellerDTO sellerDTO) {
		this.sellerDTO = sellerDTO;
	}


}
