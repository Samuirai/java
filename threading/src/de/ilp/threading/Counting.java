package de.ilp.threading;

public class Counting implements Runnable{

	private int counter = 0;
	private String threadName;
	
	Counting(String name) {
		this.threadName = name;
	}
	
	@Override
	public void run() {
		while(true) {
			counter++;
			for(int i=0; i<100000000; ++i) {
				
			}
			System.out.println(threadName+": "+this.counter);
		}
	}

}
