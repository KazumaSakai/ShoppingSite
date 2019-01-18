package com.internousdev.ShoppingSite.util;

import java.util.Map;

public class CheckLogin
{
	public static boolean IsLogin(Map<String, Object> session)
	{
		Object isLogin_obj = session.get("isLogin");
		if(isLogin_obj == null)
		{
			return false;
		}
		return (boolean)isLogin_obj;
	}
}
