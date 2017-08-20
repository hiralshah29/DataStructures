package com.codingalgo.examples.LinkedList;

import java.util.Stack;

import com.codingalgo.model.ListNode;

public class AddLargeNumbers {
	
	  ListNode result = null;

	   public static void main(String[] args) {
		   AddLargeNumbers list = new AddLargeNumbers();
		   ListNode  ahead = new ListNode(1234);
		   ahead.next = new ListNode(9856);
		   ahead.next.next = new ListNode(8888);
		   
		   ListNode  bhead = new ListNode(9276);
		   bhead.next = new ListNode(8123);
		   bhead.next.next = new ListNode(1354);
		   
		   list.add(ahead,bhead);
		   

//		   LinkedList<Integer> alist = new LinkedList<>();
//		   alist.add(1234);
//		   alist.add(9856);
//		   alist.add(8888);
//		   alist.add(914);
//		   
//		   LinkedList<Integer> blist = new LinkedList<>();
//		   blist.add(1276);
//		   blist.add(8123);
//		   blist.add(1354);
//		   blist.add(9876);
//		   
//	        list.add(alist,blist);
	    }    
	   
	   public void add(ListNode a, ListNode b){
		  
		   final int  BASE = 10000;
		   int offset = 0;
		   Stack<ListNode>	s1 = new Stack<>();
		   Stack<ListNode>	s2 = new Stack<>();
		   Stack<ListNode>	r = new Stack<>();
		   
		   while(a != null){
			   s1.push(a);
			   a=a.next;
		   }
		   
		   while(b != null){
			   s2.push(b);
			   b=b.next;
		   }
		   
		   while(!s1.isEmpty() || !s2.isEmpty()){
			   
			   int x = s1.pop().intData;
			   int y = s2.pop().intData;
			   
			   int sum = (x + y + offset);
			  
			   if(s1.size() >= 1 || s2.size() >= 1){
				   sum = sum % BASE;
				   offset = (x + y) / BASE;
			   }
			  
			   ListNode n = new ListNode(sum);
			   r.push(n);
		   }
		   
		  if(!s1.isEmpty() || !s2.isEmpty()){
			   if(s1.isEmpty())
				   appendRemaining(r, s1);
			  else
				   appendRemaining(r, s2);
		   }
		   
		  appendRemaining(r,null);
	   }
	   
	   public void appendRemaining(Stack<ListNode> r, Stack<ListNode> s){
		   
			   if(s != null){
				   while(!s.isEmpty()){
					   r.push(s.pop());
				   }
			   }
		  
			if(r != null){
				System.out.print(r.peek().intData);
				result = r.pop();
				ListNode c = result;
				while(!r.isEmpty()){
					System.out.print(r.peek().intData);
					c.next = r.pop();
				}
			}	  
	   }
	   
}
