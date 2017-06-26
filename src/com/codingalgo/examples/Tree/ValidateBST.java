package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class ValidateBST {
	
	static Integer prev = null;
	
	// left < node <= right
	public static boolean validateBST(Node n){
		
		if(n == null){
			return true;
		}
		
		if(!validateBST(n.left)) return false;
		
		if(prev != null && prev >= n.data){
			return false;
		}
		
		prev = n.data;
		if(!validateBST(n.right)) return false;
		
		return true;
	}

	public static void main(String[] args) {
		
	/* Constructing below tree							
			        8
			      /   \
			     4     12
			   /  \   /  \
			  2    6 10   14
	*/

		Node root  = new Node(8);
		root.left = new Node(4);
		root.right = new Node(12);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.right.left = new Node(10);
		root.right.right = new Node(14);
		
		System.out.println(validateBST(root));
	}
}
