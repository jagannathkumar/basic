/**
 * 
 */
package com.myproject.strategydesignpattern;

/**
 * @author JK
 *
 */
public class Subtraction implements DoOperation {

	@Override
	public int operation(int a, int b) {
		return a-b;
	}

}
