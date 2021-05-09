/**
 * 
 */
package com.myproject.singletonbreakexample;

/**
 * @author JK
 *
 */
public class MyClone implements Cloneable{
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
