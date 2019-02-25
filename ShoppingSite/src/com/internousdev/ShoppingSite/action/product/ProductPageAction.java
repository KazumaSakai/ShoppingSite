package com.internousdev.ShoppingSite.action.product;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dao.ProductReviewDAO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.dto.ProductReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductPageAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 50;

	//	Receive
	private int productId;
	private int page;

	//	Send
	private ProductDTO productDTO;
	private List<ProductReviewDTO> productReviewDTOList;
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		this.productDTO = ProductDAO.Select(productId);
		this.productReviewDTOList = ProductReviewDAO.SelectListByProductId(page * pageLength, pageLength, productId);

		return SUCCESS;
	}

	//	Getter Setter
	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public ProductDTO getProductDTO()
	{
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO)
	{
		this.productDTO = productDTO;
	}

	public List<ProductReviewDTO> getProductReviewDTOList()
	{
		return productReviewDTOList;
	}

	public void setProductReviewDTOList(List<ProductReviewDTO> productReviewDTOList)
	{
		this.productReviewDTOList = productReviewDTOList;
	}

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}

	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
