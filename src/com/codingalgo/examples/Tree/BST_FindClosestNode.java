package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class BST_FindClosestNode {

	 public static void main(String[] args) {
		 BST_FindClosestNode tree = new BST_FindClosestNode();
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
		
		Node n = tree.findClosestNode(root,5);
		System.out.println(n.data);
		
	}
	 
	int max = Integer.MAX_VALUE;
	public Node findClosestNode(Node root, int K){
		 
		if(root == null){
			return root;
		}
		
		if(root.data == K){
			return root;
		}
		
		if(max > Math.abs(root.data - K)){
			max = Math.abs(root.data - K);
		}
		
		Node n = null;
		if(root.data > K){
			 n = findClosestNode(root.left, K);
		}else{
			 n = findClosestNode(root.right, K);
		}
		
		return (n == null ? root : n);
	 }
}
