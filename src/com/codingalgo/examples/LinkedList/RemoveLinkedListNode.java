package com.codingalgo.examples.LinkedList;

import com.codingalgo.model.ListNode;

/** Program to remove all linked list nodes having value greater than k */

public class RemoveLinkedListNode {
	
		public static void main(String[] args) {
			 	
				ListNode head = new ListNode(5);
				ListNode one = new ListNode(1);
				ListNode two = new ListNode(2);
				ListNode three = new ListNode(3);
				ListNode four = new ListNode(4);
				ListNode five = new ListNode(5);
				ListNode six = new ListNode(6);
				ListNode one1 = new ListNode(1);
				ListNode three3 = new ListNode(3);
				
				head.next = one;
				one.next=two;
				two.next=three;
				three.next=four;
				four.next=five;
				five.next=six;
				six.next=one1;
				one1.next=three3;
				
				print(head);
				System.out.println();
				print(removeNode(head,3));
				
		}
		
		public static ListNode removeNode(ListNode head, int k){
			
			ListNode curr = head;
			
			if(head.intData >k){
				head = head.next;
			}		
			
			while(curr.next != null){
				if(curr.next.intData <= k){
					curr = curr.next;
				}else{
					ListNode n = curr.next;
					curr.next = curr.next.next;
					n.next = null;
				}
			}			
			return head;
		}
		
		public static void print(ListNode head){
			
			ListNode curr = head;
			
			while(curr != null){
				System.out.print(curr.intData +" ");
				curr = curr.next;
			}
		}
}
