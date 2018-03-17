package com.rajeev.thread.creation.ways;

public class ByImplementingRunnableInterface {
	
	public static void main(String[] args) {
		System.out.println("Thread by Implementing Runnable Interface !");
		
		Thread t1=new Thread(new APP2());
		
		
		
		
		
		Thread t2=new Thread(new APP3());
		
		APP3 t3= new APP3();
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	
}


class APP2 implements Runnable{

	public void run() {
			
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+" i="+i);
			}
	}
	

	
}


class APP3 extends Thread implements Runnable{

	public void run() {
			
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+" i="+i);
			}
	}
}	
