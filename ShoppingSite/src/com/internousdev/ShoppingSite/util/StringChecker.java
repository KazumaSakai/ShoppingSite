package com.internousdev.ShoppingSite.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>StringChecker</b> : 文字列のチェックを行う
 * @author 酒井和馬
 *
 */
public class StringChecker
{
	/**
	 * 文字列が半角英数字のみか判定する
	 * 
	 * @param str
	 * 	対象の文字列
	 * 
	 * @return
	 * 	<b>boolean</b><br/>
	 * 	 - true : 半角英数字のみ<br/>
	 *   - false : 半角英数字のみでない
	 */
	public static boolean IsOnlyAlphabet_Number(String str)
	{
		Pattern p = Pattern.compile("^[\\p{Alnum}]+$");
		Matcher m = p.matcher(str);
		
		return m.find();
	}
	
	/**
	 * 文字列がメールアドレスか判定する
	 * 
	 * @param str
	 * 	対象の文字列
	 * @return
	 * 	<b>boolean</b><br/>
	 * 	 - true : メールアドレス<br/>
	 *   - false : メールアドレスではない
	 */
	public static boolean IsMailAddress(String str)
	{
        Pattern p = Pattern.compile(
                "^(([0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*)|(\"[^\"]*\"))"
                        + "@[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+"
                        + "(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*$");

		Matcher m = p.matcher(str);
		
		return m.find();
	}

	/**
	 * 文字列が指定の長さであるか判定する
	 * @param str
	 * 	対象の文字列
	 * @param minLength
	 * 	最小文字列
	 * @param maxLength
	 * 	最大文字列
	 * @return
	 * 	<b>boolean</b><br/>
	 * 	 - true : 指定の長さである<br/>
	 *   - false : 指定の長さでない
	 */
	public static boolean CheckStringLength(String str, int minLength, int maxLength)
	{
		if(str == null) return false;
		
		boolean notEmpty = !str.isEmpty();
		boolean inRange = (minLength <= str.length() && str.length() <= maxLength);
		
		return notEmpty && inRange;
	}

	/**
	 * 文字列の文字種を判定する
	 * @param str
	 * 	対象の文字列
	 * @param allowCharTypes
	 * 	許可する文字種
	 * @return
	 * 	<b>boolean</b><br/>
	 * 	 - true : 指定の文字種を使用<br/>
	 *   - false : 指定以外の文字種を使用している
	 */
	public static boolean CheckCharType(String str, CharType... allowCharTypes)
	{
		if (str == null || str.isEmpty()) return true;
		
		return Pattern.compile(CharType.GetRegularExpression(allowCharTypes)).matcher(str).find();
	}
	
	/**
	 * 対象の文字列を検証し、エラーメッセージを返します
	 * @param str
	 * 	対象の文字列
	 * @param columnName
	 * 	カラム名
	 * @param minLength
	 * 	最小文字列長
	 * @param maxLength
	 * 	最大文字列長
	 * @param allowCharTypes
	 * 	許可する文字種
	 * @return
	 * 	エラーメッセージ
	 */
	public static List<String> Check(String str, String columnName, int minLength, int maxLength, CharType... allowCharTypes)
	{
		List<String> errorMsgList = new ArrayList<String>();
		
		//	文字列の長さ
		if (!CheckStringLength(str, minLength, maxLength))
		{
			errorMsgList.add(MessageFormat.format("{0}の長さは、{1}文字以上、{2}文字以下でなければなりません。", columnName, minLength, maxLength));
		}

		//	文字種
		if(!CheckCharType(str, allowCharTypes))
		{
			errorMsgList.add(MessageFormat.format("{0}の文字種は、{1}でなければなりません。", columnName, CharType.GetName(allowCharTypes)));
		}
		
		return errorMsgList;
	}
}
