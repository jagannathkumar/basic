/**
 * 
 */
package com.myproject.exceptions;

/**
 * @author JK
 *
 */
public class TestException extends Exception {

	private static final long serialVersionUID = 1L;
	TestException(String s) {
		super(s);
	}
	TestException(String s,Exception e){
		super(s,e);
	}
}
