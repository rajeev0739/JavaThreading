package com.rajeev.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	int id;
	
	public Processor(int id) {
		this.id=id;
	}

	public void run() {
		System.out.println("Starting thread : "+Thread.currentThread().getName()+" and it's id is : "+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Completed thread : "+Thread.currentThread().getName()+" and it's id is : "+id);
	}
	
	
}
public class ExecutorExample1 {
	
	public static void main(String[] args) {
		
		ExecutorService executor=Executors.newFixedThreadPool(2);
		// Created thread-pool of size two ,each will complete their task and then take new task
		
		for(int i=0;i<10;i++) {
			
			Processor newTask=new Processor(i);
			
			executor.submit(newTask);
			
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("All Tasks Completed : ");
		
	}

}
