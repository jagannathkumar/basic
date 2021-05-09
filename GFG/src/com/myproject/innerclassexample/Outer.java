package com.myproject.innerclassexample;

/**
 * @author JK
 *
 */
public class Outer {
	void outerMethod() {
		int x = 98;
		System.out.println("inside outerMethod");
		class Inner {
			void innerMethod() {
				System.out.println("x= " + x);
			}
		}
		Inner y = new Inner();
		y.innerMethod();
	}
	class Inner1{
		void inner1method() {
			System.out.println("Inner1 class");
		}
	}
	public static void main(String[] args) {
		Outer out = new Outer();
		out.outerMethod();
		Outer.Inner1 in= new Outer().new Inner1();
		in.inner1method();
	}

}
