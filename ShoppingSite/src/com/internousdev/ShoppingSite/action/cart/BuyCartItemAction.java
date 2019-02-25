package com.internousdev.ShoppingSite.action.cart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.CartDAO;
import com.internousdev.ShoppingSite.dao.ProductDAO;
import com.internousdev.ShoppingSite.dao.PurchaseHistoryDAO;
import com.internousdev.ShoppingSite.dto.CartDTO;
import com.internousdev.ShoppingSite.dto.ProductDTO;
import com.internousdev.ShoppingSite.dto.PurchaseHistoryDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.DateConverter;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.opensymphony.xwork2.ActionSupport;

public class BuyCartItemAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int destinationId;
	private String requestDeliveryDate;

	//	Send
	private int totalPrice;
	private List<ProductDTO> purchasedProductList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "MyCartAction");
			return "needLogin";
		}

		//	TODO : 入力値チェック

		int userId = SessionSafeGetter.getInt(session, "user_id");
		int shipmentState = 0;
		LocalDateTime requestDeliveryDate = DateConverter.toLocalDateTime(this.requestDeliveryDate);

		//	現在のカート情報を取得
		List<CartDTO> cartDTOList = CartDAO.SelectListByUserId(0, Integer.MAX_VALUE, userId);
		List<PurchaseHistoryDTO> purchaseHistoryDTOList = new ArrayList<PurchaseHistoryDTO>();
		for (CartDTO cartDTO : cartDTOList)
		{
			//	在庫を差し引く
			if(ProductDAO.DecrementProductQuantity(cartDTO.getProductId(), cartDTO.getProductQuantity()))
			{
				PurchaseHistoryDTO purchaseHistoryDTO = cartDTO.toPurchaseHistoryDTO(destinationId, shipmentState, requestDeliveryDate);
				PurchaseHistoryDAO.Insert(purchaseHistoryDTO);
				purchaseHistoryDTOList.add(purchaseHistoryDTO);

				CartDAO.Delete(cartDTO.getUserId(), cartDTO.getProductId());
			}
		}

		//	購入した商品の詳細情報を取得する
		purchasedProductList = new ArrayList<ProductDTO>();
		for (PurchaseHistoryDTO purchaseHistoryDTO : purchaseHistoryDTOList)
		{
			ProductDTO productDTO = ProductDAO.Select(purchaseHistoryDTO.getProductId());
			productDTO.setProductQuantity(purchaseHistoryDTO.getProductQuantity());
			purchasedProductList.add(productDTO);
		}

		//	合計金額
		this.totalPrice = purchasedProductList.stream().mapToInt(i -> i.getProductPrice() * i.getProductQuantity()).sum();

		return SUCCESS;
	}

	//	Getter Setter
	public int getDestinationId()
	{
		return destinationId;
	}
	public void setDestinationId(int destinationId)
	{
		this.destinationId = destinationId;
	}
	public String getRequestDeliveryDate()
	{
		return requestDeliveryDate;
	}
	public void setRequestDeliveryDate(String requestDeliveryDate)
	{
		this.requestDeliveryDate = requestDeliveryDate;
	}
	public int getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	public List<ProductDTO> getPurchasedProductList()
	{
		return purchasedProductList;
	}
	public void setPurchasedProductList(List<ProductDTO> purchasedProductList)
	{
		this.purchasedProductList = purchasedProductList;
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
