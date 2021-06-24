/**
 * 
 */
package com.myproject.college;

/**
 * @author JK
 *
 */
public class StringtoInteger {

	public static void main(String[] args) {
		String s = "123660";
		char ch[] = s.toCharArray();
		int temp = 0;
		for (int i = 0; i < ch.length; i++) {
			temp = (temp * 10)+(ch[i] - 48);
		}
		System.out.println(temp);
	}

}
