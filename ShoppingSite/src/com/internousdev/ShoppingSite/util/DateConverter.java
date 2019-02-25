package com.internousdev.ShoppingSite.util;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class DateConverter
{
	public static LocalDateTime toLocalDateTime(String date)
	{
		String[] dates = date.split(" ");
		int[] ymd = Stream.of(dates[0].split("-")).mapToInt(i -> Integer.parseInt(i)).toArray();
		int[] hms = Stream.of(dates[0].split(":")).mapToInt(i -> Integer.parseInt(i)).toArray();

		return LocalDateTime.of(ymd[0], ymd[1], ymd[2], hms[0], hms[1], hms[2]);
	}

	public static String toString(LocalDateTime localDateTime)
	{
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(localDateTime.getYear()).append("-");
		stringBuilder.append(String.format("%02d", localDateTime.getMonthValue())).append("-");
		stringBuilder.append(String.format("%02d", localDateTime.getDayOfMonth())).append(" ");
		stringBuilder.append(String.format("%02d", localDateTime.getHour())).append(":");
		stringBuilder.append(String.format("%02d", localDateTime.getMinute())).append(":");
		stringBuilder.append(String.format("%02d", localDateTime.getSecond()));

		return stringBuilder.toString();
	}
}
