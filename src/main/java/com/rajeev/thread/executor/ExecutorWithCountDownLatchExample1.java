
package com.rajeev.thread.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
	
class MyProcessor implements Runnable{
		CountDownLatch latch;
		
		public MyProcessor(CountDownLatch latch) {
			this.latch=latch;
		}

		public void run() {
			System.out.println("Starting : "+Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("Completed : "+Thread.currentThread().getName());
			latch.countDown();
		}
		
}		
	
public class ExecutorWithCountDownLatchExample1 {	
	
public static void main(String[] args) {
		
	CountDownLatch latch =new CountDownLatch(3);
		ExecutorService executor=Executors.newFixedThreadPool(10);
		// Created threadpool of size two ,each will complete their task and then take new task
		
		for(int i=0;i<3;i++) {
			
			MyProcessor newTask=new MyProcessor(latch);
			
			executor.submit(newTask);
			
		}
		
		
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("All Tasks Completed : Current Running Thread"+Thread.currentThread().getName());
		
	}

}


