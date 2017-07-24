package com.codingalgo.examples.misc;

public class FindPrimeNumber
{
	public static void main(String[] args) {
		findCompostie(20);
	}

	//method 1
	static boolean isPrime(int N){
		
		for(int i =  2 ; i * i <= N ; i++){
			if(N % i == 0){
				return false;
			}
		}
		return true;		
	}
	
	//method 2
	static void findCompostie(int n){
		
		int flag = 0;
		for(int i=2;i<=n;i++ )
	        {
	            flag=0;
	           for(int j=2;j<i;j++)
	             {
	                 if(i % j == 0)
	                    flag++;
	             }
	           if(flag==0){
	            System.out.println(i + " is Prime number");
	           }
	           else{
	        	   System.out.println(i + " is Composite number");
	           }
	        }
	}
}
