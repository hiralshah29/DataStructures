package com.codingalgo.examples.misc;

public class FindPrimeNumber
{
	public static void main(String[] args) {
		System.out.println(isPrime(39));
	}

	static boolean isPrime(int N){
		
		for(int i =  2 ; i * i <= N ; i++){
			if(N % i == 0){
				return false;
			}
		}
		return true;		
	}
}
