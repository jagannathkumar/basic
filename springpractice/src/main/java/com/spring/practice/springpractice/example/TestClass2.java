/**
 * 
 */
package com.spring.practice.springpractice.example;

import org.springframework.stereotype.Component;

/**
 * @author JK
 *
 */
@Component("test2")
public class TestClass2 implements TestInterface{

	@Override
	public void show() {
		System.out.println("In testclass2");
	}

}
