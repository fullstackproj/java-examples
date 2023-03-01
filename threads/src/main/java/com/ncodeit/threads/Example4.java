package com.ncodeit.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Example4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService executorService=Executors.newScheduledThreadPool(1);
		
		/*Callable<String> c1=()->{
			System.out.println("executing callable block");
			return "Finsihed";
		};*/
		
		Runnable r1=()->{
			System.out.println("executing callable block");
		};	
		//Future<String> result=executorService.schedule.c1, 1, TimeUnit.SECONDS);
		Future result=executorService.scheduleAtFixedRate(r1, 10, 25, TimeUnit.SECONDS);
		
		Thread.sleep(100000);
		
		result.cancel(true);
		
		executorService.shutdown();
	}

}
