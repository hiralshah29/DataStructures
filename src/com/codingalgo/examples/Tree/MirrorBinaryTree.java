package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class MirrorBinaryTree {
	  Node root = null;
	  public static void main(String args[]) 
	    {
	    	
	    	/* Constructed binary tree is
				               1        
				             /   \
				            2      3
				          /  \
				        4     5
				        
			   change to 
				        
			        	   1
			             /   \
			           3      2
					          /  \
					        4     5
	        */
	    	
		  	MirrorBinaryTree tree = new MirrorBinaryTree();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        
	        tree.mirror(tree.root);
	    }
	  
	   Node mirror(Node node)
	    {
	        if (node == null)
	            return node;
	 
	        /* do the subtrees */
	        Node left = mirror(node.left);
	        Node right = mirror(node.right);
	 
	        /* swap the left and right pointers */
	        node.left = right;
	        node.right = left;
	 
	        return node;
	    }
}
