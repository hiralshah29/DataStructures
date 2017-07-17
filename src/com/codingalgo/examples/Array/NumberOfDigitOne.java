package com.codingalgo.examples.Array;

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

	For example:
	Given n = 13,
	Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * @author hiralsha
 *
 */
public class NumberOfDigitOne {
	
	public static void main(String[] args) {
		System.out.println(count(13));
	}
	
	public static int count(int n){
		int count = 1;
		for(int i = 10 ; i <= n ; i++){
			count+=countOfDigitOne(i);
		}
		
		return count;
	}
	
	public static int countOfDigitOne(int i){
		int count = 0;
		while(i > 0){
			if(i%10==1){
				count++;
			}
			i=i/10;
		}
		return count;
	}
}
