package com.rajeev.thread.creation.ways;

public class ByUsingAnonymousInnerClass {
	
	public static void main(String[] args) {
		
		System.out.println("Thread by By Using AnonymousInnerClass of  Runnable Interface !");
		
		Thread t1=new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+" i="+i);
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+" i="+i);
				}
			}
		});
	
		
		
		
		t1.start();
		t2.start();
	}
	

}

