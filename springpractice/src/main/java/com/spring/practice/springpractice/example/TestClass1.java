/**
 * 
 */
package com.spring.practice.springpractice.example;

import org.springframework.stereotype.Component;

/**
 * @author JK
 *
 */
@Component("test1")
public class TestClass1 implements TestInterface {

	@Override
	public void show() {
		System.out.println("In testclass1");
	}
	
}
