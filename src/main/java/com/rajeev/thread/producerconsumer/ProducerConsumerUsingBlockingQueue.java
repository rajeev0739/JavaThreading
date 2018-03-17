package com.rajeev.thread.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {
	
	static BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<Integer>(5);
	
	public static void producer() throws InterruptedException {
		Random rd=new Random();
		System.out.println("Producer ::");
			while (true) {
				Integer s=rd.nextInt(100);
				blockingQueue.put(s);
				System.out.println("Produced ::"+s);
		}	
	
	}
	
	public static void consumer ()throws InterruptedException{
		System.out.println(" Consumer ::");
		
		while (true) {
			
			if(new Random().nextInt(10)==0) {
				Integer s=(blockingQueue.take());
				System.out.println("Consumed : "+s +" Queue Size :"+blockingQueue.size());
				Thread.sleep(5000);
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				try {
					
					
					   producer();
				  
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
	Thread t2=new Thread(new Runnable() {
			
			public void run() {
				
				try {
					
						consumer();
					
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
	
	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	}
	
	

}
