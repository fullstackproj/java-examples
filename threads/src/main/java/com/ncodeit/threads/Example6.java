package com.ncodeit.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Example6 {

	public static void main(String[] args) {
		System.out.println("Main Thread:"+Thread.currentThread().getName());
		
		Supplier<String> sp=()->{
			return printNumbers();
		};
		
		CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(sp);
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
		return "Finished Successfully";
	}	
	
}
