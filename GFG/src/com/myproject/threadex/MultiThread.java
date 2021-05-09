package com.myproject.threadex;

/**
 * @author JK
 *
 */
class MultiThreadingDemo implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getId()+" is running");
	}
}
public class MultiThread {

	public static void main(String[] args) {
		Thread th = new Thread(new MultiThreadingDemo());
		th.start();
		th.start();
	}

}
