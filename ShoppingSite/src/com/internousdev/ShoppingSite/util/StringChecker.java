package com.internousdev.ShoppingSite.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChecker
{
	public static boolean IsOnlyAlphabet_Number(String str)
	{
		Pattern p = Pattern.compile("^[\\p{Alnum}]+$");
		Matcher m = p.matcher(str);
		
		return m.find();
	}
	
	public static boolean IsSafeString(String str)
	{
		if(str.contains("<")) return false;
		if(str.contains(">")) return false;
		if(str.contains("&")) return false;
		if(str.contains("%")) return false;
		if(str.contains("$")) return false;
		if(str.contains("{")) return false;
		if(str.contains("}")) return false;
		if(str.contains("#")) return false;
		if(str.contains("?")) return false;
		if(str.contains("'")) return false;
		if(str.contains("\"")) return false;
		if(str.contains("\\")) return false;
		
		return true;
	}
	
	public static boolean IsMailAddress(String str)
	{
        Pattern p = Pattern.compile(
                "^(([0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*)|(\"[^\"]*\"))"
                        + "@[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+"
                        + "(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*$");

		Matcher m = p.matcher(str);
		
		return m.find();
	}
}