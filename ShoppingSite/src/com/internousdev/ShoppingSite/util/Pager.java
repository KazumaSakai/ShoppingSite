package com.internousdev.ShoppingSite.util;

import java.util.stream.IntStream;

public class Pager
{
	public static int[] CreatePager(int nowPage, int pageCount, int pagerLimit)
	{
		int pagerStart = Math.max(1, nowPage - (pagerLimit / 2) + 1);
		int pagerEnd = Math.min(pageCount + 1, pagerStart + pagerLimit);
		
		return IntStream.range(pagerStart, pagerEnd).toArray();
	}
	
	public static int PageCount(int itemCount, int pageLength)		
	{
		return (itemCount / pageLength) + Math.min(1, itemCount % pageLength);
	}
}
