package com.internousdev.ShoppingSite.action.go;

import com.opensymphony.xwork2.ActionSupport;

public class GoSignUpAction  extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
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
