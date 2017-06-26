package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class CountOfLeafNodes {

/*******************************
			  10
			/       \
		28         13
				    /     \
				  14       15
				 /   \     /  \
			21   22   23   24

*******************************/
	
public int countofLeafNodes(Node node){
		
		if(node == null){
			return 0; 
		}
		
		if(node.left == null && node.right == null){
			return 1;
		}
		
		return countofLeafNodes(node.left) + countofLeafNodes(node.right);
	}
	
	public static void main(String[] args) {
		
		Node root  = new Node(10);
		root.left = new Node(28);
		root.right = new Node(13);
		root.right.left = new Node(14);
		root.right.right = new Node(15);
		root.right.left.left = new Node(21);
		root.right.left.right = new Node(22);
		root.right.right.right = new Node(24);
		root.right.right.left = new Node(23);

		int c = new CountOfLeafNodes().countofLeafNodes(root);
		System.out.println("Count = "+c);
	}
}
