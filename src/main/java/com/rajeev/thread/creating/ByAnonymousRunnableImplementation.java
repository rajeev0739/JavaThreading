package com.rajeev.thread.creating;

public class ByAnonymousRunnableImplementation {
	public static void main(String ars[]) {
		
		Thread t1= new Thread(
								new Runnable() {
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
						     );
		
		
		
	
		
		t1.start();
		
		
	}
}
