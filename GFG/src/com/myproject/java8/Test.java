/**
 * 
 */
package com.myproject.java8;

/**
 * @author JK
 *
 */
public class Test implements Interface1,Interface2 {

	public static void main(String[] args) {
		Interface1 it = new Test();
		it.show();
		Interface2 it2 = new Test();
		it2.show();
	}

	@Override
	public void show() {
		Interface2.super.show();
	}
}
