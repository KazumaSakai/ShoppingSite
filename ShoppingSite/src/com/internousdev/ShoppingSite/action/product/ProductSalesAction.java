package com.internousdev.ShoppingSite.action.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.struts2.interceptor.SessionAware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internousdev.ShoppingSite.dao.ProductSalesDAO;
import com.internousdev.ShoppingSite.dto.ProductSalesDTO;
import com.internousdev.ShoppingSite.util.CheckAdmin;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class ProductSalesAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private int productId;

	//	Send
	private String resultData;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "ProductSalesAction");
			return "needLogin";
		}
		//	管理者チェック
		if(!CheckAdmin.IsAdmin(session))
		{
			return "notAdmin";
		}

		ObjectMapper mapper = new ObjectMapper();
		try
		{
			LocalDateTime time = LocalDateTime.now();
			List<ProductSalesDTO> fillProductSalesDTOList = new ArrayList<ProductSalesDTO>();

			//	直近12ヶ月間のデータを取得。DBに無い場合は空のものを作成
			List<ProductSalesDTO> productSalesDTOList = ProductSalesDAO.SelectListByProductId(0, 12, productId);
			for(int i = 0; i < 12; i++)
			{
				int year = time.getYear();
				int month = time.getMonthValue();

				Optional<ProductSalesDTO> optional = productSalesDTOList.stream().filter(j -> (j.getSalesMonth() == month && j.getSalesYear() == year)).findFirst();
				ProductSalesDTO productSalesDTO = (optional.isPresent()) ? optional.get() : new ProductSalesDTO(year, month);

				fillProductSalesDTOList.add(productSalesDTO);
				time = time.minusMonths(1);
			}

			//	反転させる
			Collections.reverse(fillProductSalesDTOList);

			//	JSONに変換
			this.resultData = mapper.writeValueAsString(fillProductSalesDTOList);
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getResultData()
	{
		return resultData;
	}

	public void setResultData(String resultData)
	{
		this.resultData = resultData;
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
