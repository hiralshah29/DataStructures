package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class BST_MinAbsDifference {
	 Node root;
	 
	    int min = Integer.MAX_VALUE;
	    Integer prev = null;
	    
	    public int getMinimumDifference(Node root) {
	        if (root == null) return min;
	        
	        getMinimumDifference(root.left);
	        
	        if (prev != null) {
	            min = Math.min(min, root.data - prev);
	        }
	        prev = root.data;
	        
	        getMinimumDifference(root.right);
	        
	        return min;
	    }
	 
	 public static void main(String args[]) 
	    {
	        /* Constructed binary tree is
				               5
				             /   \
				            2      6
				          /  \
				        1    4 
	        */
		 BST_MinAbsDifference tree = new BST_MinAbsDifference();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	          
	        System.out.println(tree.getMinimumDifference(tree.root));
//	        System.out.println(tree.prev);
	    }

}
