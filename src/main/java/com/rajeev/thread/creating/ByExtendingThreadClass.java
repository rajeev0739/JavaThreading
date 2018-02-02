package com.rajeev.thread.creating;



class WorkRunner extends Thread{
	
	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}


public class ByExtendingThreadClass {

	
	
	public static void main(String ars[]) {
	
		WorkRunner t1= new WorkRunner();
		WorkRunner t2= new WorkRunner();
		
		t1.start();
		t2.start();
		
	}
	
	

}
