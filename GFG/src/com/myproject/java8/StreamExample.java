/**
 * 
 */
package com.myproject.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JK
 *
 */
public class StreamExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,1,12,12,42,223,32,23,53);
		
		Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(max);
	}

}
