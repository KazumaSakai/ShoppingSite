package com.internousdev.ShoppingSite.util;

import java.util.Map;

public class SessionSafeGetter
{
	public static String getString(Map<String, Object> session, String key)
	{
		String result = "";

		//	キーがあるかチェック
		if(session.containsKey(key))
		{
			result = (String)session.get(key);
		}

		return result;
	}

	public static boolean getBoolean(Map<String, Object> session, String key)
	{
		boolean result = false;

		//	キーがあるかチェック
		if(session.containsKey(key))
		{
			result = (boolean)session.get(key);
		}

		return result;
	}

	public static int getInt(Map<String, Object> session, String key)
	{
		int result = -1;

		//	キーがあるかチェック
		if(session.containsKey(key))
		{
			result = (int)session.get(key);
		}

		return result;
	}
}
