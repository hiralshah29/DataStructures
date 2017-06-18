package com.codingalgo.examples.misc;

/** Finds the binary equivalent of an int  */

public class BinaryEquivalentOfInteger {
	
	public static void main(String[] args) {
		new BinaryEquivalentOfInteger().binaryEquiv(955);
	}
	
	public void binaryEquiv(int n){
		
		int[] d = new int[30];
		int l = 0 ;
		int p;
		
		while (n > 0){
			d[l]=n%2;
			n = n/2;
			l++;
		}
		
		for(int i = l-1 ; i >= 0 ; i--){
		       System.out.print(d[i]);
		}
	}
}
