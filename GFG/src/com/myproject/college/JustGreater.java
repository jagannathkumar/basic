/**
 * 
 */
package com.myproject.college;

import java.util.Arrays;

/**
 * @author JK
 *
 */
//Find just greater number than the given number using given digits
public class JustGreater {
	
	public static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
	
	public static void findJustGreater(char ch[]) {
		int j=0,justGreaterDigitIndex=0;
		for(int i=ch.length-1;i>=0;i--) {
			if(ch[i-1]<ch[i]) {
				j = i-1;
				break;
			}
		}
		justGreaterDigitIndex = j;
		int flag = 0;
		for(int z=ch.length-1;z>j;z--) {
			if(flag==1 && ch[justGreaterDigitIndex]>ch[z]) {
				justGreaterDigitIndex = z;
			}
			if(flag==0 && ch[justGreaterDigitIndex]<ch[z]) {
				justGreaterDigitIndex = z;
				flag=1;
			}
		}
		swap(ch,j,justGreaterDigitIndex);
		Arrays.sort(ch,j+1,justGreaterDigitIndex+1);
		System.out.println(ch);
	}
	public static void main(String[] args) {
		char ch[] = { '5', '3', '4', '9', '7', '6' };
		boolean ascFlag = true;
		boolean descFlag = true;
		for (int i = 1; i < ch.length; i++) {
			if (ch[i - 1] < ch[i]) {
				descFlag = false;
			} else if (ch[i - 1] > ch[i]) {
				ascFlag = false;
			} else if (descFlag == false && ascFlag == false)
				break;
		}
		if (ch.length == 1)
			System.exit(0);

		if (ascFlag) {
			swap(ch, ch.length - 1, ch.length - 2);
			System.out.println(ch);
		} else if (descFlag)
			System.out.println("Not possible");
		else if (descFlag == false && ascFlag == false) {
			findJustGreater(ch);
		}
	}
}
