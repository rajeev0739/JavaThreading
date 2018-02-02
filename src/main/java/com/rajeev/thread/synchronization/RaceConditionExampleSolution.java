package com.rajeev.thread.synchronization;

public class RaceConditionExampleSolution {


	
	private int count=0;
	
/*	public void increment() {
		count++;
	}*/
	
	public synchronized void increment() {
		count++;
	}
	
	public static void main(String[] args) {
		RaceConditionExampleSolution rc=new RaceConditionExampleSolution();
		rc.doWork();
		
	}
     
	public void doWork() {
		Thread t1=new Thread(new Runnable() {
			
						public void run() {
							for(int i=0;i<10000;i++) {
								//count++;
								increment();
							}
							
						}
					});
		
		Thread t2=new Thread(new Runnable() {
			
			public void run() {
				
				for(int i=0;i<10000;i++) {
					//count++;
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		System.out.println(" count is : "+count);
	}
}
