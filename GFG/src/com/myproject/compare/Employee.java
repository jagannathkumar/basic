/**
 * 
 */
package com.myproject.compare;

/**
 * @author JK
 *
 */
public class Employee {
	private int empId;
	private String empName;
	public Employee() {}
	public Employee(int empId,String empName) {
		this.empId=empId;
		this.empName=empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int hashcode() {
		return this.empId;
	}
	
	public boolean equals(Object obj) {
		Employee e =(Employee)obj;
		if(this==e)
			return true;
		else if(this.getClass()!=obj.getClass())
			return false;
		else if(this.getEmpId()==e.getEmpId() && this.getEmpName().equals(e.getEmpName()))
			return true;
		else
			return false;
	}
}
