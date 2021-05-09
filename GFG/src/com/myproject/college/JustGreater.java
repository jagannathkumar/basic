/**
 * 
 */
package com.myproject.college;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JK
 *
 */
//Find just greater number than the given number using given digits
public class JustGreater {
	public static void main(String[] args) {
		int num = 123;
		Set<Integer> set = new HashSet<>();
		set.add(num);
		String str = String.valueOf(num);
		int n[] = new int[str.length()];
		int count = 0;
		while (num != 0) {
			n[count++] = num % 10;
			num = num / 10;
		}

		for (int i = 0; i < n.length; i++) {
			String st = String.valueOf(n[i]);
			// System.out.println(st);
			for (int j = 0; j < n.length; j++) {
				if (j != i)
					st = st + String.valueOf(n[j]);
			}
			// System.out.println(st);
			set.add(Integer.valueOf(st));
			//st = "";
		}
		System.out.println(set);
	}
}
