/**
 * 
 */
package com.myproject.abstractionexample;

/**
 * @author JK
 *
 */
public class ClassB extends Abclass{

	@Override
	public void show() {
		System.out.println("in subclass");
	}
	public static void main(String args[]) {
		ClassB c=new ClassB();
		c.show();
		c.show1();
		
		//ClassC c1= new ClassC(); we cannot have object of abstract class
	}

}
