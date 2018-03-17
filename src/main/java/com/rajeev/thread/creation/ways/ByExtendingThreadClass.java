package com.rajeev.thread.creation.ways;

public class ByExtendingThreadClass {
	public static void main(String[] args) {
		
		System.out.println("Thread by Extending thread class !");
		
		APP1 app1=new APP1();
		app1.start();
		
		APP1 app2=new APP1();
		app2.start();
	}

}

class APP1 extends Thread{
	@Override
    public void run() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" i="+i);
		}
	}
}
