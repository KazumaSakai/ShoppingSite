package com.internousdev.ShoppingSite.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTTP
{
	public static String GET(String urlString)
	{
		String xml = "";
		try
		{
			URL url = new URL(urlString);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.connect();

			// サーバーからのレスポンスを標準出力へ出す
			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				xml += line;
			}
			reader.close();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return xml;
	}

	public static String POST(String urlString)
	{
		String line = "";
		try
		{
			URL url = new URL(urlString);
			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);// POST可能にする

			uc.setRequestProperty("User-Agent", "@IT java-tips URLConnection");// ヘッダを設定
			uc.setRequestProperty("Accept-Language", "ja");// ヘッダを設定
			OutputStream os = uc.getOutputStream();// POST用のOutputStreamを取得

			String postStr = "foo1=bar1&foo2=bar2";// POSTするデータ
			PrintStream ps = new PrintStream(os);
			ps.print(postStr);// データをPOSTする
			ps.close();

			InputStream is = uc.getInputStream();// POSTした結果を取得
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String s;
			while ((s = reader.readLine()) != null)
			{
				line += s;
			}
			reader.close();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return line;
	}
}
