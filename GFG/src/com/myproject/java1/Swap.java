package com.myproject.java1;

/**
 * @author JK
 *
 */
public class Swap {
	int a;

	Swap(int a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Swap s = new Swap(10);
		Swap s1 = new Swap(20);
		swap_integer(s, s1);
		System.out.println("s " + s.a + ", s1: " + s1.a);
		swap_int(s, s1);
		System.out.println("s " + s.a + ", s1: " + s1.a);
		
		Wrapper w = new Wrapper(s);
		Wrapper w1 = new Wrapper(s1);
		swap_wrapper(w,w1);
		System.out.println("s " + w.s.a + ", s1: " + w1.s.a);

	}

	// Here we are changing the variable using reference, this we can use if member
	// variable is known to us.In case we don't know the variable we have to use
	// Wrapper class
	static void swap_integer(Swap a, Swap b) {
		int temp = a.a;
		a.a = b.a;
		b.a = temp;
	}

	static void swap_int(Swap a, Swap b) {
		Swap temp = a;
		a = b;
		b = temp;
	}
	//Swapping using wrapper class
	static void swap_wrapper(Wrapper a, Wrapper b) {
		  Swap temp = a.s; 
		  a.s = b.s; 
		  b.s = temp;
		 
	}
}

class Wrapper {
	Swap s;

	Wrapper(Swap s) {
		this.s = s;
	}
}
