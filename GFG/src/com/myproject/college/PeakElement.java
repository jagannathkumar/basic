/**
 * 
 */
package com.myproject.college;

/**
 * @author JK
 *
 */
//number greater than all of its neighbour
public class PeakElement {

	public static void main(String[] args) {
		int a[] = { 1,2,3,1 };
		for (int i = 0; i < a.length; i++) {
			if(a[i]<a[i+1] && a[i+1]>a[i+2]) {
				System.out.println(a[i+1]);
			}
		}
	}

}
