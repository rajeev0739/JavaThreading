package com.rajeev.thread.multiple.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLockProblemSolution {
	
	private static Random random=new Random();
	public static List<Integer> list1=new ArrayList<Integer>();
	public static List<Integer> list2=new ArrayList<Integer>();
	public static Object lock1=new Object();
	public static Object lock2=new Object();
	
	
	public  static void stageOne() {
		
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
		
	}
	
	public  static void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	public static void process() {
		
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();		}
	}

	public static void main(String[] args) {
		
		System.out.println("Starting....");
		Long start=System.currentTimeMillis();
		
		
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				process();
				
			}
		});
		

		
	   Thread t2=new Thread(new Runnable() {
			
			public void run() {
				process();
				
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Long end=System.currentTimeMillis();
		
		System.out.println("Time Taken :"+(end-start));
		
		System.out.println("List1 size :"+list1.size()+" List2 Size :"+list2.size());
		
		
		
		
	}
}
