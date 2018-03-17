package com.rajeev.thread.producerconsumer;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerUsingWaitNotifyAndLinkedList {
	
static Processsor processor=new Processsor();
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
			try {
				processor.producer();
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

class Processsor {
	
	Object lock=new Object();
	LinkedList<Integer> liskedList=new LinkedList<Integer>();
	private final int LIMIT=10;
	
	
	
	public void producer() throws InterruptedException {
		
		System.out.println("Producer stated :: ");
		Random rd=new Random();
		while (true) {
			
			synchronized (lock) {
			    int inetgerToAddInList=rd.nextInt(1000);
			    System.out.println("  inetgerToAddingInList :"+inetgerToAddInList+" liskedList.size :"+liskedList.size());
			    while(liskedList.size()==LIMIT){
			    	lock.wait();
			    }
			    liskedList.add(inetgerToAddInList);
			    lock.notify();
				
			}
			
		}
	}
	public void consumer() throws InterruptedException {
		System.out.println("consumer strted :: ");
		Random rd=new Random();
		while(true) {
			
			    synchronized (lock) { 
				
				 while(liskedList.size()==0) {
						lock.wait();
				 }
				 int inetgerRemovedFromList=liskedList.removeFirst();
				 System.out.println(" inetgerRemovedFromList :"+inetgerRemovedFromList+" liskedList.size :"+liskedList.size());
			
				 lock.notify();
			}
			Thread.sleep(rd.nextInt(5000));
		}
	}
	
}
