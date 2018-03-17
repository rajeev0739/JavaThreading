package com.rajeev.thread.producerconsumer;

import java.util.Scanner;

public class WaitNotifyExample {
	static Processor processor=new Processor();
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
			try {
				processor.prodcuer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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

class Processor {
	
	
	public   void  prodcuer() throws InterruptedException {
		
		synchronized(this) {
			System.out.println("Producing......");
			wait();
			System.out.println("Resumed......");
		}
	}
	
	public  void consumer() throws InterruptedException {
		
		
		Scanner scanner=new Scanner(System.in);
		
		synchronized(this) {
			
		System.out.println("Consumer waiting for retunrn key press......");
		scanner.nextLine();
		System.out.println("Return key pressed......");
		System.out.println("notifying......");
		Thread.sleep(1000);
		notify();
		}
		
	}
}
