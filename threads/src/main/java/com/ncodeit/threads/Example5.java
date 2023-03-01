package com.ncodeit.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example5 {

	public static void main(String[] args) {
		System.out.println("Main Thread:"+Thread.currentThread().getName());
		Runnable r1=()->{
			printNumbers();
		};
		
		CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(r1);
		try {
			completableFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Finished");
	}
	
	public static void printNumbers(){
		System.out.println("Completable Future Thread:"+Thread.currentThread().getName());
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
	}

}
