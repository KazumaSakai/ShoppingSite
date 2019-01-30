package com.internousdev.ShoppingSite.util;

import java.util.Map;

public class CheckLogin
{
	public static boolean IsLogin(Map<String, Object> session)
	{
		return SessionSafeGetter.getBoolean(session, "isLogin");
	}
}
