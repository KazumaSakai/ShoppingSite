package com.internousdev.ShoppingSite.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class IntChecker
{
	public static List<String> Check(int value, String columnName, String unit, int minLength, int maxLength)
	{
		List<String> errorMsgList = new ArrayList<String>();
		
		if(value < minLength || maxLength > value)
		{
			errorMsgList.add(MessageFormat.format("{0}は、{2}{1}以上、{2}{3}以下でなければなりません。", columnName, unit, minLength, maxLength));
		}
		
		return errorMsgList;
	}
}
