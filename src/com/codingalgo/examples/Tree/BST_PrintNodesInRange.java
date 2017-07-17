package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class BST_PrintNodesInRange {

	 
		public void printNodesInRange(Node root, int k1, int k2){
			
			if(root == null) return;
			
			printNodesInRange(root.left, k1, k2);
			
			if(k1 <= root.data && root.data <= k2){
				System.out.print(root.data + " ");
			}
			printNodesInRange(root.right, k1, k2);
		}
		
		 public static void main(String[] args) {
				
			 BST_PrintNodesInRange tree = new BST_PrintNodesInRange();
			 
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
				
				tree.printNodesInRange(root,2,12);
			}
}
