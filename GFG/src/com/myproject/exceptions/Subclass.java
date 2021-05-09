package com.myproject.exceptions;

import java.io.IOException;

/**
 * @author JK
 *
 */
/**
 * 
 *If superclass is throwing any checked exception(compile time i.e IOException) then either subclass should not throw any exception or it can throw child exception of superclass exception or unchecked exception
 *Subclass can throw Unchecked exception at any point of time even if superclass is not throwing any exception
 *If superclass is throwing any unchecked exception , in that case  subclass can only throw same exception or child of that exception
 *
 */
class Superclass{
	public void show() {
		System.out.println("Superclass");
	}
}
public class Subclass extends Superclass{
	public void show() throws RuntimeException {
		System.out.println("Subclass");
	}

	public static void main(String[] args) {
		Superclass a = new Superclass();
		Subclass b = new Subclass();
		Superclass s;
		s = b;
		try {
			s.show();
		}
		catch(Exception i) {
			
		}
		
	}

}
