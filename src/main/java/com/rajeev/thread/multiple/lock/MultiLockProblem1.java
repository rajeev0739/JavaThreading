package com.rajeev.thread.multiple.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class worker {
	
	
	private Random random=new Random();
	public List<Integer> list1=new ArrayList<Integer>();
	public List<Integer> list2=new ArrayList<Integer>();
	
	
	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
	}
	
	public void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
	}
	
	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();		}
	}
}

public class MultiLockProblem1 {

	public static void main(String[] args) {
		
		System.out.println("Starting....");
		Long start=System.currentTimeMillis();
		worker w1=new worker();
		w1.process();
		
		Long end=System.currentTimeMillis();
		
		System.out.println("Time Taken :"+(end-start));
		
		System.out.println("List1 size :"+w1.list1.size()+" List2 Size :"+w1.list2.size());
		
		
		
		
	}
}


