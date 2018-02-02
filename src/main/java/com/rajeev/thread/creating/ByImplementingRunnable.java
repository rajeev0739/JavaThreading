package com.rajeev.thread.creating;


class Runner implements Runnable{
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
}

public class ByImplementingRunnable{

	public static void main(String ars[]) {
		
		Thread t1=new Thread(new Runner());
		Thread t2=new Thread(new Runner());
		
		t1.start();
		t2.start();
		
	}

}
