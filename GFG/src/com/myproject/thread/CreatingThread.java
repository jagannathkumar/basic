/**
 * 
 */
package com.myproject.thread;

/**
 * @author JK
 *
 */
public class CreatingThread {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Test();
		t.start();
	}

}

class Test extends Thread{
	public void run() {
		System.out.println("Thread is running");
	}
}