package com.internousdev.ShoppingSite.util;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class DateConverter
{
	public static LocalDateTime toLocalDateTime(String date)
	{
		if(date == null || !(date.contains("T") || date.contains(" "))) return null;

		String[] dates = date.contains("T") ? date.split("T") : date.split(" ");
		if(dates.length != 2) return null;

		String[] ymd_s = dates[0].split("-");
		String[] hms_s = dates[1].substring(0, 8).split(":");

		if(ymd_s.length != 3 || hms_s.length != 3) return null;

		int[] ymd = Stream.of(ymd_s).mapToInt(i -> Integer.parseInt(i)).toArray();
		int[] hms = Stream.of(hms_s).mapToInt(i -> Integer.valueOf(i)).toArray();

		return LocalDateTime.of(ymd[0], ymd[1], ymd[2], hms[0], hms[1], hms[2]);
	}

	public static String toString(LocalDateTime localDateTime)
	{
		if(localDateTime == null) return null;

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(localDateTime.getYear()).append("-");
		stringBuilder.append(String.format("%02d", localDateTime.getMonthValue())).append("-");
		stringBuilder.append(String.format("%02d", localDateTime.getDayOfMonth())).append(" ");
		stringBuilder.append(String.format("%02d", localDateTime.getHour())).append(":");
		stringBuilder.append(String.format("%02d", localDateTime.getMinute())).append(":");
		stringBuilder.append(String.format("%02d", localDateTime.getSecond()));

		return stringBuilder.toString();
	}

	public static String toFormat(LocalDateTime localDateTime)
	{
		if(localDateTime == null) return null;

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(localDateTime.getYear()).append("年");
		stringBuilder.append(String.format("%02d", localDateTime.getMonthValue())).append("月");
		stringBuilder.append(String.format("%02d", localDateTime.getDayOfMonth())).append("日　");
		stringBuilder.append(String.format("%02d", localDateTime.getHour())).append("時");
		stringBuilder.append(String.format("%02d", localDateTime.getMinute())).append("分");

		return stringBuilder.toString();
	}
}
