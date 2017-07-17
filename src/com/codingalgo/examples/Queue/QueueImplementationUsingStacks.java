package com.codingalgo.examples.Queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueImplementationUsingStacks<T> {
	
	    Stack<T> temp = new Stack<>();
	    Stack<T> value = new Stack<>();
	 
	    // Push element x to the back of queue.
	    public void offer(T x) {
	    	value.push(x);
	    }
	 
	    // Removes the element from in front of queue.
	    public T poll() {
	        
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
	    		q.offer(i);
		    	System.out.println("Offer: "+i);
	    	}
	    	
	    	System.out.println("Peek: "+q.peek());
	    	System.out.println("Poll: "+q.poll());
	    	System.out.println("Peek: "+q.peek());
	    	
		}
}
