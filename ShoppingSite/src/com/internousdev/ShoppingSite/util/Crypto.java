package com.internousdev.ShoppingSite.util;

import java.io.Serializable;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto implements Serializable
{
	public static Crypto crypto;
	private static void createCrypto()
	{
		byte[] iv  = "u7aTAfOMMKJvD02S".getBytes();

		// IV(暗号化時のスタートブロック用の初期値 128ビット固定長）
		byte[] key = "passhash_key".getBytes();
		// 暗号解読キー(128ビット固定長)

		try
		{
			crypto = new Crypto(key, iv);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String encrypto(String text)
	{
		if(crypto == null)
		{
			createCrypto();
		}

		String result = "";
		try
		{
			result = crypto._encrypto(text);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public static String decrypto(String str64)
	{
		if(crypto == null)
		{
			createCrypto();
		}

		String result = "";
		try
		{
			result = crypto._decrypto(str64);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private Cipher encrypter;
	private Cipher decrypter;

	/*
	 * 	 コンストラクタ（引数は暗号解読キーとIV）
	 * 	 引数はどちらもStringからbyte[]に変換したものを指定する。
	 */
	public Crypto(byte[] secretKey, byte[] ivs) throws Exception
	{
		//	暗号化時のスタートブロック用の初期値を作成
		IvParameterSpec iv = new IvParameterSpec(ivs);

		//	暗号方式 + 解読キー
		SecretKeySpec key = new SecretKeySpec(secretKey, "AES");
		//	暗号方式と生成方式を指定し、暗号器を作成
		encrypter = Cipher.getInstance("AES/CBC/PKCS5Padding");
		//	暗号器を暗号化モードにセットする
		encrypter.init(Cipher.DECRYPT_MODE , key, iv);

		//	もうひとつ、暗号器を作成しておく
		decrypter = Cipher.getInstance("AES/CBC/PKCS5Padding");
		//	暗号器を復号モードにセットする
		decrypter.init(Cipher.DECRYPT_MODE, key, iv);
	}

	//	暗号化処理
	public String _encrypto(String text) throws Exception
	{
		//	暗号化する
		byte[] crypto = encrypter.doFinal(text.getBytes());

		//	文字列の配列に変換
		byte[] str64 = java.util.Base64.getEncoder().encode(crypto);

		//	それをさらに文字列へ
		return new String(str64);
	}

	//	復号化処理
	public String _decrypto(String str64) throws Exception
	{
		//	暗号化されている文字列を配列に
		byte[] str = Base64.getDecoder().decode(str64);

		//	暗号を複合化する
		byte[] text = decrypter.doFinal(str);

		//	文字列に変換して返す
		return new String(text);
	}
}