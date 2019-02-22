package com.internousdev.ShoppingSite.action.go;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction  extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	//	Receive + Send
	private String errorMsg;
	
	//	Execute
	public String execute()
	{
		return SUCCESS;
	}

	//	Getter Setter
	public String getErrorMsg()
	{
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}
}
