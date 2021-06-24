/**
 * 
 */
package com.myproject.java8;

import java.util.ArrayList;

/**
 * @author JK
 *
 */
public class LambdaExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		arrL.add(9);
		arrL.add(2);
		arrL.add(3);
		arrL.add(-1);

		//arrL.forEach(n -> System.out.println(n));
		//Integer h = 0;
		arrL.forEach(n -> {
			Integer h = 0;
			if (n>h)
				h=n;
			System.out.println(h);
		});
	}

}
