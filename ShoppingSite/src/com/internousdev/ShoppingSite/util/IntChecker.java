package com.internousdev.ShoppingSite.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class IntChecker
{
	public static List<String> Check(int value, String columnName, String unit, int minValue, int maxValue)
	{
		List<String> errorMsgList = new ArrayList<String>();
		
		if(!IntChecker.InRange(value, minValue, maxValue))
		{
			errorMsgList.add(MessageFormat.format("{0}は、{2}{1}以上、{2}{3}以下でなければなりません。", columnName, unit, minValue, maxValue));
		}
		
		return errorMsgList;
	}
	
	public static boolean InRange(int value, int minValue, int maxValue)
	{
		return (minValue <= value && value <= maxValue);
	}
}
