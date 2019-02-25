package com.internousdev.ShoppingSite.action.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ShoppingSite.dao.UserDAO;
import com.internousdev.ShoppingSite.dto.UserDTO;
import com.internousdev.ShoppingSite.util.CharType;
import com.internousdev.ShoppingSite.util.CheckLogin;
import com.internousdev.ShoppingSite.util.Passworder;
import com.internousdev.ShoppingSite.util.SessionSafeGetter;
import com.internousdev.ShoppingSite.util.StringChecker;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserPasswordAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	private String planePassword;
	private String newPlanePassword;
	private String newPlanePasswordConfirm;

	//	Send
	private List<String> errorMsgList;
	private List<String> successMsgList;

	//	Session
	private Map<String, Object> session;

	//	Execute
	public String execute()
	{
		//	ログインチェック
		if(!CheckLogin.IsLogin(session))
		{
			session.put("LoginedRedirectAction", "GoUserInfoAction");
			return "needLogin";
		}

		int userId = SessionSafeGetter.getInt(session, "userId");
		String loginId = SessionSafeGetter.getString(session, "loginId");

		//	入力値チェック
		if(!UserDAO.LoginCheck(loginId, planePassword))
		{
			errorMsgList.add("パスワードが間違っています。");
		}
		errorMsgList.addAll(StringChecker.CheckEqual(newPlanePassword, newPlanePasswordConfirm, "新しいパスワード", "新しいパスワード（確認）"));
		errorMsgList.addAll(StringChecker.Check(newPlanePassword, "新しいパスワード", 8, 60, CharType.Alphabet, CharType.Number));
		errorMsgList.addAll(StringChecker.Check(newPlanePasswordConfirm, "新しいパスワード（確認）", 8, 60, CharType.Alphabet, CharType.Number));
		if(!errorMsgList.isEmpty())
		{
			return ERROR;
		}

		UserDTO userDTO = UserDAO.SelectById(userId);
		userDTO.setLoginPass(Passworder.getSafetyPassword(newPlanePassword, loginId));
		if(UserDAO.Update(userDTO))
		{
			successMsgList.add("パスワードの変更に成功しました。");
			return SUCCESS;
		}
		else
		{
			errorMsgList.add("パスワードの変更に失敗しました。");
			return ERROR;
		}
	}

	//	Getter Setter
	public String getPlanePassword()
	{
		return planePassword;
	}

	public void setPlanePassword(String planePassword)
	{
		this.planePassword = planePassword;
	}

	public String getNewPlanePassword()
	{
		return newPlanePassword;
	}

	public void setNewPlanePassword(String newPlanePassword)
	{
		this.newPlanePassword = newPlanePassword;
	}

	public String getNewPlanePasswordConfirm()
	{
		return newPlanePasswordConfirm;
	}

	public void setNewPlanePasswordConfirm(String newPlanePasswordConfirm)
	{
		this.newPlanePasswordConfirm = newPlanePasswordConfirm;
	}

	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}

	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}

	public List<String> getSuccessMsgList()
	{
		return successMsgList;
	}

	public void setSuccessMsgList(List<String> successMsgList)
	{
		this.successMsgList = successMsgList;
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
