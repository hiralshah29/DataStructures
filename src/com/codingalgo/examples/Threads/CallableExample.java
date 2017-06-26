package com.codingalgo.examples.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableExample {
	
	public static void main(String[] args) {
//		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		ExecutorService executor = Executors.newFixedThreadPool(4);
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		
		for(int j = 0 ; j < 6 ; j++){
			
			Future<Integer> future = executor.submit(new Calculator(j * 3));
			list.add(future);
			
		}
		
		list.forEach(
				future->{
					try {
						System.out.println("Future returned = " +future.get());
					} catch (Exception e) {
						e.printStackTrace();
					}});
	
		//shut down the executor service now
        executor.shutdown();
	}
}

class Calculator implements Callable<Integer> {
	
	int n;
	public Calculator(int i){
		n = i;
	}
	public Integer call(){
		
		int sum = 0;
		for(int i = 0 ; i < n ; i++ ){
			sum+=i;
			try {
				TimeUnit.MILLISECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("Sum is = "+sum);
		
		return sum;
	}
}
