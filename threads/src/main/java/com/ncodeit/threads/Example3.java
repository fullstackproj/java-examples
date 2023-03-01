package com.ncodeit.threads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example3 {

	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		
		Runnable task=()->{
			System.out.println("Thread Name:"+Thread.currentThread().getName());
			for(int i=0;i<100;i++){
				System.out.println(i);
			}
		};
		
		executorService.submit(task);
		executorService.submit(task);
		executorService.submit(task);
		
		List<Runnable> runnables=executorService.shutdownNow();
		System.out.println("Size:"+runnables.size());
	}

}
