package com.codingalgo.examples.Stack;

/** Stack implementation using generic array */

public class SpecialStack<T> {
	
	T[] arr;
	int top;
	
	SpecialStack(int size){
		arr = (T[]) new Object[size];
	}
	
	public void push(T ele){
		
		if(top == arr.length) {
			resize(arr.length * 2);
		}
		arr[top++] = ele;		
	}
	
	public T pop(){
		if(top == -1){
			throw new java.util.NoSuchElementException();
		}
		T ele = arr[--top];
		arr[top] = null;
		return ele;
	}
	
	public T peek(){
		if(top == -1){
			throw new java.util.NoSuchElementException();
		}
		return arr[top];
	}
	
	public void resize(int capacity){
		T[] temp = (T[]) new Object[capacity];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr = temp;
	}

	public static void main(String[] args) {
		
		SpecialStack s = new SpecialStack(3);
		
		s.push(29);
		s.push(3);
		s.push(10);
		s.push(12);
		s.push(2);
		s.push(16);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		
	}
	
	/*int[] arr;
	int ptr;
	int max;
	Stack<Integer> min;

	SpecialStack(int size){
		
		max = size;
		arr = new int[size];
		ptr = max - 1;
		min = new Stack<Integer>();
	}


	public void push(int n){

		if(!isFull()){
			arr[ptr] = n;
			ptr--;
			if(min.isEmpty() || n < min.peek()){
				min.push(n);
			}
		}

	}	

	public int pop(){
		
		int x = 0;
		if(!isEmpty()){
			
			if(isFull()){ptr++ ;}
			
			x = arr[ptr];
			arr[ptr] = Integer.MAX_VALUE;
			if(min.peek() == x){
				min.pop();
			}
			ptr++;
		}
		return x;
	}

	public boolean isFull(){
		
		return (ptr == -1);
	}


	public boolean isEmpty(){

		return (ptr == max);
	}
	
	public int getMin(){
		return min.peek();
	}
	
	public static void main(String[] args) {
		
		SpecialStack s = new SpecialStack(6);
		
		s.push(29);
		s.push(3);
		s.push(10);
		s.push(12);
		s.push(2);
		s.push(16);
		
		System.out.println(s.getMin());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.getMin());	
		
	}*/
}
