package com.codingalgo.examples.misc;

public class FindPrimeNumber
{

	public static void main(String[] args) {
		System.out.println(isPrime(37));
	}

	public static boolean isPrime(int N){
		
		for(int x = 2 ; x *  x <= N ; x++){
			if(N % x == 0){
				return false;
			}
		}
		return true;
	}
}
