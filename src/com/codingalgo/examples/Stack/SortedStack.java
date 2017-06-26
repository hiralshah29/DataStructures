package com.codingalgo.examples.Stack;

import java.util.Stack;

//Sort the given stack
public class SortedStack {

	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<>();
		int[] a = new int[]{4,2,6,1,5};		
		for(int i = 0 ; i < a.length ; i++){
			s1.push(a[i]);						
		}
		
		System.out.print("Before sort: ");
		for(int i : a){
			System.out.print(i+ " ");
		}
		sortStack(s1);
		
		
	}
	public static void sortStack(Stack<Integer> s1){
		Stack<Integer> s2 = new Stack<>();
		
		int temp;
		while(!s1.isEmpty()){
			temp = s1.pop();
			
			while(!s2.isEmpty() && s2.peek() > temp){
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
		
		System.out.print("\nAfter sort: ");
		for(int i : s1){
			System.out.print(i+ " ");
		}
	}
}
