package com.ncodeit.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Example9 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Supplier<List<String>> s1=()->{
			System.out.println("Supplier thread "+Thread.currentThread().getName());
			List<String> lstStrings = getS1List();
			return lstStrings;
		};

		Supplier<List<String>> s2=()->{
			System.out.println("Supplier thread "+Thread.currentThread().getName());
			List<String> lstStrings = getS2List();
			return lstStrings;
		};
		
		CompletableFuture<List<String>> cf1=CompletableFuture.supplyAsync(s1);
		CompletableFuture<List<String>> cf2=CompletableFuture.supplyAsync(s2);
		
		CompletableFuture<List<String>> result=cf1.thenCombine(cf2, (r1,r2)->{
			System.out.println(r1);
			System.out.println(r2);
			r1.addAll(r2);
			return r1;
		});
		System.out.println("Final Result:"+result.get());
		
	}

	private static List<String> getS2List() {
		List<String> lstStrings=new ArrayList<>();
		lstStrings.add("third");
		lstStrings.add("fourth");
		return lstStrings;
	}

	private static List<String> getS1List() {
		List<String> lstStrings=new ArrayList<>();
		lstStrings.add("first");
		lstStrings.add("second");
		return lstStrings;
	}

}
