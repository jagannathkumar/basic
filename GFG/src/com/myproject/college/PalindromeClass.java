/**
 * 
 */
package com.myproject.college;

import java.util.Scanner;

/**
 * @author JK
 *
 */
public class PalindromeClass {
	
	public static boolean checkPalindrome(String st) {
		int i=st.length()-1,j=0;
		while(j<=st.length()/2) {
			if(st.charAt(i)!=st.charAt(j))
				return false;
			i--;
			j++;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			String s= sc.next();
			System.out.printf(checkPalindrome(s)?"Palindrome":"Not a Palindrome");
		}while(true);
		
	}
	
}
