package com.codingalgo.examples;

public class AddWithoutPlus {
	
	public static void main(String[] args) {
		
		int sum = new AddWithoutPlus().add(135,176);
		System.out.println(sum);
	}

	public int add(int a ,int b){
		
		
		while(b!=0){
			
			int sum = a ^ b;
			int carry = (a & b) << 1;
			a=sum;
			b=carry;			
		}
		return a;
	}
}
