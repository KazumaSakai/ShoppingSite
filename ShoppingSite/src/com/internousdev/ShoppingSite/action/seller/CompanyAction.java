package com.internousdev.ShoppingSite.action.seller;

import com.internousdev.ShoppingSite.dao.CompanyDAO;
import com.internousdev.ShoppingSite.dto.CompanyDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int companyId;

	//	Send
	private CompanyDTO companyDTO;

	//	Execute
	public String execute()
	{
		companyDTO = CompanyDAO.Select(companyId);

		return SUCCESS;
	}

	//	Getter Setter
	public int getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(int companyId)
	{
		this.companyId = companyId;
	}

	public CompanyDTO getCompanyDTO()
	{
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO)
	{
		this.companyDTO = companyDTO;
	}
}
