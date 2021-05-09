/**
 * 
 */
package com.myproject.compare;

/**
 * @author JK
 *
 */
public class StringCompareExample {

	public static void main(String[] args) {
		String s="Test";
		String s1="Test";
		String s2 = new String("Test");
		System.out.println((s==s1)+" "+s.equals(s1)+" "+(s==s2)+" "+s.equals(s2));
		
		Employee e = new Employee(1,"Abc");
		Employee e1 = e;
		Employee e2 = new Employee();
		e2.setEmpId(e.getEmpId());
		e2.setEmpName(e.getEmpName());
		System.out.println((e==e1)+" "+(e==e2)+" "+e.equals(e2));//output before overriding equals method - true false false
	}

}
