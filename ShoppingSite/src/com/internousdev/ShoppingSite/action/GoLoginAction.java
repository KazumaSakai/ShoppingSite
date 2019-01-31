package com.internousdev.ShoppingSite.action;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction  extends ActionSupport
{
	private String errorMsg;
	
	public String execute()
	{
		return SUCCESS;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
