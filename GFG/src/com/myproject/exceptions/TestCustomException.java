/**
 * 
 */
package com.myproject.exceptions;

/**
 * @author JK
 *
 */
public class TestCustomException {

	public static void main(String[] args) throws TestException {
		try {
			int a =1000/0;
		}
		catch(ArithmeticException e) {
			throw new TestException("Exception caught in main method",e);
		}
	}

}
