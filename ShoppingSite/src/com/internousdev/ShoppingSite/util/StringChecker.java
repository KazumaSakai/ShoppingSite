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
		
		int length = str.length();
		return (minLength <= length && length <= maxLength);
	}
	
	/**
	 * 文字列が指定のバイト数であるか判定する
	 * @param str
	 * 	対象の文字列
	 * @param minByte
	 * 	最小バイト
	 * @param maxByte
	 * 	最大バイト
	 * @return
	 * 	<b>boolean</b><br/>
	 * 	 - true : 指定の長さである<br/>
	 *   - false : 指定の長さでない
	 */
	public static boolean CheckStringByte(String str, int minByte, int maxByte)
	{
		if(str == null) return false;
		
		try
		{
			int byteLength = str.getBytes("UTF-8").length;
			return (minByte <= byteLength && byteLength <= maxByte);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
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
	
	/**
	 * 対象の文字列がメールアドレスかどうか検証し、エラーメッセージを返す
	 * @param str
	 * 	対象の文字列
	 * @param columnName
	 * 	カラム名
	 * @return
	 * 	エラーメッセージ
	 */
	public static List<String> CheckEmail(String str, String columnName)
	{
		List<String> errorMsgList = new ArrayList<String>();
		
		//	バイト数の長さ
		if (!CheckStringByte(str, 3, 100))
		{
			errorMsgList.add(MessageFormat.format("{0}のバイト数は、{1}文字以上、{2}文字以下でなければなりません。", columnName, 3, 100));
		}
		
		//	メールアドレスチェック
		if(!IsMailAddress(str))
		{
			errorMsgList.add(MessageFormat.format("{0}はメールアドレスではありません。", columnName));
		}
		
		return errorMsgList;
	}
	
	/**
	 * Nullも許容し、文字列の内容が同じが検証します
	 * @param str
	 * 	対象の文字列
	 * @param str2
	 * 	対象の文字列
	 * @return
	 * 	<b>boolean</b><br/>
	 * 	 - true : 同じ<br/>
	 *   - false : 同じでない
	 */
	public static boolean IsEqual(String str, String str2)
	{
		if(str == null || str2 == null)
		{
			if(str == null && str2 == null) return true;
			return false;
		}
		
		return str.equals(str2);
	}
	
	/**
	 * 	文字列の内容が同じが検証し、エラーメッセージを返します
	 * @param str
	 * 	対象の文字列
	 * @param str2
	 * 	対象の文字列
	 * @param columnName
	 * 	カラム名
	 * @param columnName2
	 * 	カラム名
	 * @return
	 * 	エラーメッセージ
	 */
	public static List<String> CheckEqual(String str, String str2, String columnName, String columnName2)
	{
		List<String> errorMsgList = new ArrayList<String>();
		
		if(!IsEqual(str, str2))
		{
			errorMsgList.add(MessageFormat.format("{0}と{1}が一致しません。", columnName, columnName2));
		}
		
		return errorMsgList;
	}
}
