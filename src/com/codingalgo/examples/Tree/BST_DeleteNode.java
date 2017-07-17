package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class BST_DeleteNode {

	public static Node deleteNode(Node n,int k){
		
		if(n == null){
			return n;
		}
		
		if(k < n.data){
			n.left = deleteNode(n.left, k);
		}else if(k > n.data){
			n.right = deleteNode(n.right, k);
		}else{
			if(n.left == null){
				return n.right;
			}else if(n.right == null){
				return n.left;
			}else{
				n.data = minVal(n.right);
				n.right=deleteNode(n.right, n.data);
			}
		}
		return n;
	}
	
	public static int minVal(Node n){
		int min = n.data;
		while(n.left != null){
			min = n.left.data;
			n=n.left;
		}
		return min;
	}
	
	 public static void main(String[] args) {
			
		 /* Constructing below tree							
		                8
		              /   \
		             4     12
		           /  \   /    \
		          2    6 10   14
		  */
	 	
		Node root  = new Node(8);
		root.left = new Node(4);
		root.right = new Node(12);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.right.left = new Node(10);
		root.right.right = new Node(14);
		
		Node n = deleteNode(root,6);
		System.out.println(n.data);
		
	}
}
