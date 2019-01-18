package com.internousdev.ShoppingSite.util;

import java.util.Map;

public class CheckAdmin
{
	public static boolean IsAdmin(Map<String, Object> session)
	{
		if(!CheckLogin.IsLogin(session)) return false;

		return (boolean)session.get("isAdmin");
	}
}
