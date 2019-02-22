package com.internousdev.ShoppingSite.action.go;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class GoSignUpAction  extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	//	Send
	private List<String> errorMsgList;
	
	//	Execute
	public String execute()
	{
		return SUCCESS;
	}

	//	Getter Setter
	public List<String> getErrorMsgList()
	{
		return errorMsgList;
	}
	public void setErrorMsgList(List<String> errorMsgList)
	{
		this.errorMsgList = errorMsgList;
	}

}
