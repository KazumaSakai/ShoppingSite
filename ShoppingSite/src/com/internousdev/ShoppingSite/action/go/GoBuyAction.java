package com.internousdev.ShoppingSite.action.go;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.AddressDAO;
import com.internousdev.ShoppingSite.dao.MyCartDAO;
import com.internousdev.ShoppingSite.dto.AddressDTO;
import com.internousdev.ShoppingSite.dto.ItemDTO;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	//	Send
	private List<AddressDTO> addressList;
	private List<ItemDTO> myCartItemList;
	private int totalPrice;
	private String max;
	private String min;

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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        min = simpleDateFormat.format(calendar.getTime()) + "T08:00";
        calendar.add(Calendar.DAY_OF_MONTH, 15);
        max = simpleDateFormat.format(calendar.getTime()) + "T22:00";

		int user_id = (int)session.get("user_id");
		addressList = AddressDAO.GetUserAddressList(user_id);
		
		myCartItemList = MyCartDAO.GetMyCart(user_id);
		totalPrice = myCartItemList.stream().mapToInt(i -> i.getItem_price() * i.getItem_count()).sum();
		
		return SUCCESS;
	}

	//	Getter Setter
	public List<AddressDTO> getAddressList()
	{
		return addressList;
	}
	public void setAddressList(List<AddressDTO> addressList)
	{
		this.addressList = addressList;
	}

	public List<ItemDTO> getMyCartItemList()
	{
		return myCartItemList;
	}
	public void setMyCartItemList(List<ItemDTO> myCartItemList)
	{
		this.myCartItemList = myCartItemList;
	}

	public String getMax()
	{
		return max;
	}
	public void setMax(String max)
	{
		this.max = max;
	}

	public String getMin()
	{
		return min;
	}
	public void setMin(String min)
	{
		this.min = min;
	}

	public int getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
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
