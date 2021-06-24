/**
 * 
 */
package com.myproject.strategydesignpattern;

/**
 * @author JK
 *
 */
public class Addition implements DoOperation {

	@Override
	public int operation(int a, int b) {
		return a+b;
	}

}
