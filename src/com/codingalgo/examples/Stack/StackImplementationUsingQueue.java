package com.codingalgo.examples.Stack;

import java.util.LinkedList;

//using java.util.LinkedList
public class StackImplementationUsingQueue<T> {

	LinkedList<T> list = new LinkedList<>();
	
	public void push(T x){
		list.addFirst(x);
	}
	
	public T pop(){
		return list.removeFirst();
	}
	
	public T peek(){
		return list.getFirst();
	}

	public static void main(String[] args) {
		
		StackImplementationUsingQueue<Integer> stack = new StackImplementationUsingQueue<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
}


