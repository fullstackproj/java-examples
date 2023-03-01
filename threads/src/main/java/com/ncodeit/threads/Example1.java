package com.ncodeit.threads;

public class Example1 extends Thread {
	
	@Override
	public void run(){
		try {
			Thread.sleep(10000);
			for(int i=0;i<100;i++){
				System.out.println(i);
			}		
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}
	
	public static void main(String args[]){
		System.out.println(Thread.currentThread().getName());
		Thread t1=new Thread(new Example1());
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exit "+Thread.currentThread().getName());
	}

}
