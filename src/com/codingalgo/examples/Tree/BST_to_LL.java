package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

/**
 * Implement a method to convert a binary search tree into a doubly linked list. 
 * The values should be kept in order and the operation should be performed
 * in place (that is, on the original data structure).
 */
public class BST_to_LL {
	
	 Node listhead = null;
	 static Node curr = null;
	 
	 //creating new data structure
	 public void convertoDLL(Node root){
		 if(root == null) 
			 return;
		 
		 convertoDLL(root.left);
		
		 if(listhead == null){
			 listhead = new Node(root.data);
			 curr = listhead;
		 }else{
			 Node n = new Node(root.data);
			 curr.left = n;
			 curr = n;
		 }	 
		 convertoDLL(root.right);
	 }
	
	public void printDLL(Node head){
		curr = head;
		while(curr != null){
			System.out.print(curr.data + " ");
			curr = curr.left;
		}
	}
	 public static void main(String[] args) {
			
		 /* Constructing below tree							
		                20
		              /   \
		            8      22
		           /  \   
		         4    12
		         	  /    \
		         	10    14  
		  */
		 BST_to_LL tree = new BST_to_LL();
		 
		Node root  = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		
		tree.convertoDLL(root);
		tree.printDLL(tree.listhead);
		
	 }	
}
