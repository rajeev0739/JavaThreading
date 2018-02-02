package com.rajeev.thread.synchronization;

import java.util.Scanner;

class Processor extends Thread{
	 
	 private  boolean isRunning=true;
	 
	// private volatile boolean isRunning=true;
	 
	 // here one thread is reading the isRunning in loop while main thread is writing the isRunning varibale so 
	 // that using volatile will gives the guarantee of visibility

	@Override
	public void run() {
		int i=0;
		
       while(isRunning) {
    	    System.out.println(i++);
    	   
    	    try {
	  			Thread.sleep(3000);
	  		} catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
       }
		
		
	}
	
	public void shutdown() {
		isRunning=false;
	}
}



public class ThreadSynchronizationByVloatileKeyword {
	
	public static void main(String ars[]) {
		Processor proc1=new Processor();
		proc1.start(); // this create a new thread and start running the run method of processors class
		
		
		
	System.out.println("Press enter for stop the programme..");
	
	 Scanner scanner = new Scanner(System.in);
	 scanner.nextLine();
	 
	 proc1.shutdown(); // this method will run by main thread
	}
	
	

}
