package com.internousdev.ShoppingSite.action.go;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.CartDAO;
import com.internousdev.ShoppingSite.dao.DestinationDAO;
import com.internousdev.ShoppingSite.dto.DestinationDTO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private static final int pageLength = 50;

	//	Receive
	private int destinationPage;
	private int productPage;

	//	Send
	private List<DestinationDTO> destinationDTOList;
	private List<ProductDTO> productDTOList;
	private int totalPrice;
	private String maxDate;
	private String minDate;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoBuyAction");
			return "needLogin";
		}

		//	現在の日付を取得
		LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
		//	分、秒、ミリ秒を0に
		localDateTime = localDateTime.minusMinutes(localDateTime.getMinute()).minusSeconds(localDateTime.getSecond()).minusNanos(localDateTime.getNano());
		this.minDate = localDateTime.toLocalDate().toString();
		this.maxDate = localDateTime.plusDays(30).toLocalDate().toString();

		int userId = SessionSafeGetter.getInt(session, "userId");

		this.destinationDTOList = DestinationDAO.SelectListByUserId(destinationPage * pageLength, pageLength, userId);
		this.productDTOList = CartDAO.SelectProductListByUserId(productPage * pageLength, pageLength, userId);
		this.totalPrice = productDTOList.stream().mapToInt(i -> i.getProductPrice() * i.getProductQuantity()).sum();

		return SUCCESS;
	}

	//	Getter Setter
	public int getDestinationPage()
	{
		return destinationPage;
	}

	public void setDestinationPage(int destinationPage)
	{
		this.destinationPage = destinationPage;
	}

	public int getProductPage()
	{
		return productPage;
	}

	public void setProductPage(int productPage)
	{
		this.productPage = productPage;
	}

	public List<DestinationDTO> getDestinationDTOList()
	{
		return destinationDTOList;
	}

	public void setDestinationDTOList(List<DestinationDTO> destinationDTOList)
	{
		this.destinationDTOList = destinationDTOList;
	}

	public List<ProductDTO> getProductDTOList()
	{
		return productDTOList;
	}

	public void setProductDTOList(List<ProductDTO> productDTOList)
	{
		this.productDTOList = productDTOList;
	}

	public int getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public String getMaxDate()
	{
		return maxDate;
	}

	public void setMaxDate(String maxDate)
	{
		this.maxDate = maxDate;
	}

	public String getMinDate()
	{
		return minDate;
	}

	public void setMinDate(String minDate)
	{
		this.minDate = minDate;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
