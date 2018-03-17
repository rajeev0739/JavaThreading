package com.rajeev.thread.creation.ways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ByUsingExecutorFrameWork {
	
	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(2);
		
		
		for (int i = 0; i < 10; i++) {
		
			executor.submit(new Task());
		
		}
		
		executor.shutdown();
	}

}


class Task implements Runnable{

	public void run() {
		

			System.out.println("Starting thread : "+Thread.currentThread().getName());
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			System.out.println("Completed thread : "+Thread.currentThread().getName());
		
		
	}
	
}
