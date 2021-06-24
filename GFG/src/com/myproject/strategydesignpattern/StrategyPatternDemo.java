/**
 * 
 */
package com.myproject.strategydesignpattern;

/**
 * @author JK
 *
 */
public class StrategyPatternDemo {

	public static void main(String[] args) {
		Context context = new Context(new Addition());
		System.out.println(context.executeStrategy(4, 5));
		context = new Context(new Subtraction());
		System.out.println(context.executeStrategy(8, 10));
	}

}
