package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class BST_To_GreaterTree {

	int sum = 0;
    
	 public static void main(String[] args) {
	
    /* Constructing below tree							
		         8
		       /   \
		      4     12
		    /  \   /    \
		   2    6 10   14
	*/
	 //convert to

	/* Constructing below tree							
				    44
				  /   \
				 54     26
			   /  \      /   \
			  56  50 36   14
	  */
		 BST_To_GreaterTree tree = new BST_To_GreaterTree();
		 
			Node root  = new Node(8);
			root.left = new Node(4);
			root.right = new Node(12);
			root.left.left = new Node(2);
			root.left.right = new Node(6);
			root.right.left = new Node(10);
			root.right.right = new Node(14);
			
			tree.reverInordre(root);
	}
    
    public void reverInordre(Node cur) {
        if (cur == null) return;
        reverInordre(cur.right);
        cur.data += sum;
        sum = cur.data;
        reverInordre(cur.left);
    }
}
