package com.rajeev.thread.synchronization;

public class RajeevVolatileTest {
	
	public static void main(String[] args) {
		SharedVariable sharedVariableObj=new SharedVariable();
		ReaderThread reader=new ReaderThread(sharedVariableObj);
		WriterThread writer=new WriterThread(sharedVariableObj);
		reader.start();
		writer.start();
		
	}

}

class SharedVariable{
	
	public  volatile int count=0;
	
	
	public void reader() {
		
		int local_count_stale_value = count;
		 
		while (true){
			if( local_count_stale_value!= count){
				 System.out.println("Value of count Changed to "+ count+" from thread"+Thread.currentThread().getName());
				 local_count_stale_value = count;
			}
		}
	}
	

	public void writer() {
		
	    int local_count_stale_value = count;
	    while (true){
	        System.out.println("Value of count Incrementing  to "+(local_count_stale_value+1)+" from thread"+Thread.currentThread().getName());
	    	  count = ++local_count_stale_value;
	        try {
	            Thread.sleep(500);
	        }catch (InterruptedException e)
	        { 
	        	e.printStackTrace(); 
	        }
	    }
	}
	
}

class ReaderThread extends Thread{
	SharedVariable sharedVariable;
	
public ReaderThread(SharedVariable sharedVariable) {
	this.sharedVariable=sharedVariable;
	
}

@Override
	public void run() {
	sharedVariable.reader();
	}
	
}


class WriterThread extends Thread{
	SharedVariable sharedVariable;
	
public WriterThread(SharedVariable sharedVariable) {
	this.sharedVariable=sharedVariable;
	
}

@Override
	public void run() {
	sharedVariable.writer();
	}
	
}
