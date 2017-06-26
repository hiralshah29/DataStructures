package com.codingalgo.examples.Stack;

import com.codingalgo.model.ListNode;

// using custom linked list
public class StackImplementationUsingCustomQueue<Integer> {

	ListNode head;
	
	public void push(int x){
		if(head == null){
			head = new ListNode(x);
		}else{
			ListNode n = new ListNode(x);
			n.next=head;
			head=n;
		}		
	}
	
	public int pop(){
		ListNode n = head;
		head=head.next;
		return n.intData;
	}
		
	public int peek(){
		return head.intData;
	}
	public static void main(String[] args) {
		
		StackImplementationUsingCustomQueue stack = new StackImplementationUsingCustomQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
}
