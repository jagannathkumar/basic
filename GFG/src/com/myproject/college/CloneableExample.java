/**
 * 
 */
package com.myproject.college;

/**
 * @author JK
 *
 */
public class CloneableExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A();
		a.setA("TestA");
		a.setB("TestB");
		
		A b = (A)a.clone();
		System.out.println(b.getA()+" "+b.getB());
		b.setA("Atest");
		b.setB("bTest");
		
		System.out.println(a.getA()+" "+a.getB());
	}

}
class A implements Cloneable{
	private String a;
	private String b;
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
}