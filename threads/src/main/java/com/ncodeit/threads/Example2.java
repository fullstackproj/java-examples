package com.ncodeit.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example2 {

	public static void main(String[] args) {
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		
		Runnable task=()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<10;i++){
				System.out.println(i);
			}
		};
		
		executorService.submit(task);
		executorService.shutdown();

	}

}
