package com.ncodeit.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Example7 {
	


	public static void main(String[] args) {
		System.out.println("Main Thread:"+Thread.currentThread().getName());
		
		Supplier<String> sp=()->{
			System.out.println("Supplier thread "+Thread.currentThread().getName());
			return printNumbers();
		};
		
		/*CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(sp)
				.thenApplyAsync(rs->{
					System.out.println("Apply thread "+Thread.currentThread().getName());
					return rs+" Successfully";
				});
		*/
		
		/*CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(sp)
				.thenCompose(r->{
					return CompletableFuture.supplyAsync(()->r+" Successfully");
				});
		*/
		
		 CompletableFuture.supplyAsync(sp)
				.thenCompose(r->{
					return r+" Successfully");
				});
		
		
		try {
			String result=completableFuture.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Finished");
	}
	
	public static String printNumbers(){
		System.out.println("Completable Future Thread:"+Thread.currentThread().getName());
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
		return "Finished";
	}	
	
	
	

}
