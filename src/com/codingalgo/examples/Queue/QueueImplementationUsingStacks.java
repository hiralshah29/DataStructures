package com.codingalgo.examples.Queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueImplementationUsingStacks<T> {
	
	    Stack<T> temp = new Stack<>();
	    Stack<T> value = new Stack<>();
	 
	    // Push element x to the back of queue.
	    public void push(T x) {
	    	value.push(x);
	    }
	 
	    // Removes the element from in front of queue.
	    public T pop() {
	        
	    	if(value.isEmpty() && temp.isEmpty())
	    		throw new NoSuchElementException();
	    	
	    	if(temp.isEmpty()){
		    	while(!value.isEmpty()){
		        	temp.push(value.pop());
		        }
	    	}
	        return temp.pop();
	    }
	 
	    // Get the front element.
	    public T peek() {
	    	if(value.isEmpty() && temp.isEmpty())
	    		throw new NoSuchElementException();
	    	
	    	if(temp.isEmpty()){
		    	while(!value.isEmpty()){
		        	temp.push(value.pop());
		        }
	    	}
	        return temp.peek();
	    }
		    
	    public static void main(String[] args) {
			
	    	QueueImplementationUsingStacks<Integer> q = new QueueImplementationUsingStacks<>();
	    	for(int i = 1 ; i <=5 ; i++){
	    		q.push(i);
		    	System.out.println("Added: "+i);
	    	}
	    	
	    	System.out.println("Peek: "+q.peek());
	    	System.out.println("Pop: "+q.pop());
	    	System.out.println("Peek: "+q.peek());
	    	
		}
}
