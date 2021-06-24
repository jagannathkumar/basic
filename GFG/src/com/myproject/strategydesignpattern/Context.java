/**
 * 
 */
package com.myproject.strategydesignpattern;

/**
 * @author JK
 *
 */
public class Context {
	
	private DoOperation dopt;
	
	public Context(DoOperation dopt) {
		this.dopt=dopt;
	}
	public int executeStrategy(int num1, int num2){
	      return dopt.operation(num1, num2);
	 }
}
