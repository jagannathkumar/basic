package com.myproject.java1;

import java.util.EnumMap;
import java.util.Map;

enum Color {
	RED, GREEN, BLUE;
}

enum Days {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Enumexample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Color.RED);// Directly accessible using class name , so enum is always public static final
		EnumMap<Days, String> map = new EnumMap<Days, String>(Days.class);
		map.put(Days.SUNDAY, "1");
		map.put(Days.MONDAY, "2");
		map.put(Days.TUESDAY, "3");
		map.put(Days.WEDNESDAY, "4");
		map.put(Days.THURSDAY, "5");
		map.put(Days.FRIDAY, "6");
		map.put(Days.SATURDAY, "7");
		for (Map.Entry<Days, String> m : map.entrySet())
			System.out.println(m.getKey() + " " + m.getValue());
		int i = 12;
		modify(i);
		System.out.println(i);
		
	}
	
	private static void modify(int i) {
		i= i+1;
	}

}