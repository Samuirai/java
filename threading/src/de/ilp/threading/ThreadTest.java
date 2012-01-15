package de.ilp.threading;

public class ThreadTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Counting("Thread 1"));
		t1.start();
		Thread t2 = new Thread(new Counting("Thread 2"));
		t2.start();
		Thread t3 = new Thread(new Counting("Thread 3"));
		t3.start();
	}

}
