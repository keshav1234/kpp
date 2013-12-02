package com.emts.util;

import java.util.StringTokenizer;

public class DateFormat {
	public static String generateStoryCode(String date)
	{
		String storyCode="";
		StringTokenizer st = new StringTokenizer(date,"-");
		while(st.hasMoreTokens())
		{
			storyCode=storyCode+st.nextToken();
		}
		return storyCode;	
	}

}
