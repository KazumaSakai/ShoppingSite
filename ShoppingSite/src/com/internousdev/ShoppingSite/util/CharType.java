package com.internousdev.ShoppingSite.util;

import java.util.HashMap;

public enum CharType
{
	Alphabet,
	Number,
	Symbol,
	Hiragana,
	Katakana,
	Kanji,
	HalfWidth_Space,
	FullWidth_Space;

	public static final CharType[] IgnoreSymbol = new CharType[] { Alphabet, Number, Hiragana, Katakana, Kanji, HalfWidth_Space, FullWidth_Space };

    public static final HashMap<CharType, String> NameMap = new HashMap<CharType, String>()
	{
		private static final long serialVersionUID = 1L;

		{
            put(CharType.Alphabet, "半角英数字");
            put(CharType.Number, "半角数字");
            put(CharType.Symbol, "半角記号");
            put(CharType.Hiragana, "ひらがな");
            put(CharType.Katakana, "カタカナ");
            put(CharType.Kanji, "漢字");
            put(CharType.HalfWidth_Space, "半角スペース");
            put(CharType.FullWidth_Space, "全角スペース");
    	}

	};

    public static final HashMap<CharType, String> RegularExpressionMap = new HashMap<CharType, String>()
	{
		private static final long serialVersionUID = 1L;

		{
            put(CharType.Alphabet, "a-zA-Z");
            put(CharType.Number, "0-9-");
            put(CharType.Symbol, "@.,;:!#$%&'*+/=?^_`{|}~");
            put(CharType.Hiragana, "ぁ-んー");
            put(CharType.Katakana, "ァ-ヺ");
            put(CharType.Kanji, "一-龠々");
            put(CharType.HalfWidth_Space, " ");
            put(CharType.FullWidth_Space, "　");
    	}
	};

	public static String GetName(CharType... charTypes)
	{
		StringBuilder sBuilder = new StringBuilder();

		boolean isFirst = true;
		for(CharType charType : charTypes)
		{
			if(isFirst) isFirst = false;
			else sBuilder.append("、");

			sBuilder.append(CharType.NameMap.get(charType));
		}

		return sBuilder.toString();
	}

	public static String GetRegularExpression(CharType... charTypes)
	{
		StringBuilder sBuilder = new StringBuilder();

		sBuilder.append("[");
		for(CharType charType : charTypes)
		{
			sBuilder.append(CharType.RegularExpressionMap.get(charType));
		}
		sBuilder.append("]");

		return sBuilder.toString();
	}
}