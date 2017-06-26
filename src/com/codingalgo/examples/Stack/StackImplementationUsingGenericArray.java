package com.codingalgo.examples.Stack;

/** Stack implementation using generic array */

public class StackImplementationUsingGenericArray<T> {
	
	T[] arr;
	int top;
	
	StackImplementationUsingGenericArray(int size){
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
		
		StackImplementationUsingGenericArray<Integer> s = new StackImplementationUsingGenericArray<>(3);
		
		s.push(29);
		s.push(3);
		s.push(10);
		s.push(12);
		s.push(2);
		s.push(16);
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		
	}
}
