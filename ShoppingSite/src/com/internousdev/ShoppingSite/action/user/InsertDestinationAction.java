package com.internousdev.ShoppingSite.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.DestinationDAO;
import com.internousdev.ShoppingSite.dto.DestinationDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.IntChecker;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class InsertDestinationAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private boolean goBuy;

	private String familyName;
	private String firstName;
	private int gender;
	private String postalCode;
	private String address;
	private String email;
	private String phoneNumber;

	//	Send
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "InsertDestinationAction");
			return "needLogin";
		}

		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(familyName, "姓", 1, 60, CharType.IgnoreSymbol));
		errorMsgList.addAll(StringChecker.Check(firstName, "名", 1, 60, CharType.IgnoreSymbol));
		errorMsgList.addAll(IntChecker.Check(gender, "性別", "", 0, 3));
		errorMsgList.addAll(StringChecker.Check(postalCode, "郵便番号", 8, 8, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(address, "住所", 10, 100, CharType.IgnoreSymbol));
		errorMsgList.addAll(StringChecker.CheckEmail(email, "メールアドレス"));
		errorMsgList.addAll(StringChecker.Check(phoneNumber, "電話番号", 16, 16, CharType.Number));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		int userId = SessionSafeGetter.getInt(session, "userId");
		DestinationDTO destinationDTO = new DestinationDTO();
		destinationDTO.setUserId(userId);
		destinationDTO.setFamilyName(familyName);
		destinationDTO.setFirstName(firstName);
		destinationDTO.setGender(gender);
		destinationDTO.setPostalCode(postalCode);
		destinationDTO.setAddress(address);
		destinationDTO.setEmail(email);
		destinationDTO.setPhoneNumber(phoneNumber);

		if(DestinationDAO.Insert(destinationDTO))
		{
			return goBuy ? "goBuy" : SUCCESS;
		}
		else
		{
			errorMsgList.add("住所の登録に失敗しました。");
			return ERROR;
		}
	}

	//	Getter Setter
	public boolean isGoBuy()
	{
		return goBuy;
	}

	public void setGoBuy(boolean goBuy)
	{
		this.goBuy = goBuy;
	}

	public String getFamilyName()
	{
		return familyName;
	}

	public void setFamilyName(String familyName)
	{
		this.familyName = familyName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public int getGender()
	{
		return gender;
	}

	public void setGender(int gender)
	{
		this.gender = gender;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
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
