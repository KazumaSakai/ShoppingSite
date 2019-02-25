package com.internousdev.ShoppingSite.action.user.signup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.Passworder;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	//	Receive
	private String loginId;
	private String planeLoginPass;
	private String userName;
	private String email;

	//	Send
	private List<String> errorMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	入力値チェック
		errorMsgList = new ArrayList<String>();
		errorMsgList.addAll(StringChecker.Check(planeLoginPass, "パスワード", 8, 60, CharType.Alphabet, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(loginId, "ログインID", 4, 60, CharType.Alphabet, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(userName, "ユーザー名", 4, 60, CharType.IgnoreSymbol));
		errorMsgList.addAll(StringChecker.CheckEmail(email, "メールアドレス"));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		UserDTO userDTO = new UserDTO();
		userDTO.setLoginId(loginId);
		userDTO.setEmail(email);
		userDTO.setLoginPass(Passworder.getSafetyPassword(planeLoginPass, loginId));
		if(UserDAO.Insert(userDTO))
		{
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("ユーザーの登録に失敗しました。<br/>IDまたはメールアドレスが既に使用されています。");
			return ERROR;
		}
	}

	//	Getter Setter
	public String getLoginId()
	{
		return loginId;
	}

	public void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}

	public String getPlaneLoginPass()
	{
		return planeLoginPass;
	}

	public void setPlaneLoginPass(String planeLoginPass)
	{
		this.planeLoginPass = planeLoginPass;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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
