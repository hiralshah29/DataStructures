package com.codingalgo.examples.Tree;

import java.util.HashMap;

import com.codingalgo.model.Node;

public class MorrisInorderTreeTraversal {

	Node root;
	  
    /* Function to traverse binary tree without recursion and 
       without stack */
    void MorrisTraversal(Node root) {
        Node current, pre;
          
        if (root == null)
            return;
          
        current = root;
        while (current != null) 
        {
            if (current.left == null) 
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else
            {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;
                 
                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) 
                {
                    pre.right = current;
                    current = current.left;
                } 
  
                 /* Revert the changes made in if part to restore the 
                    original tree i.e.,fix the right child of predecessor*/
                 else
                 {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */
                  
            } /* End of if condition current->left == NULL*/
              
        } /* End of while */
          
    }
    
    public boolean isBalanced(Node root) {
        return getDepth(root)!=-1;
    }
    
    public int getDepth(Node root){
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left!=-1){
            int right = getDepth(root.right);
            if(right!=-1){
                return Math.abs(left-right)<=1?1+Math.max(left,right):-1;
            }
        }
        return -1;
    }
      
    public static void main(String args[]) 
    {
    	
    	/* Constructed binary tree is
			               1
			             /   \
			            2      3
			          /  \
			        4     5
        */
    	
    	MorrisInorderTreeTraversal tree = new MorrisInorderTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
          
//        tree.MorrisTraversal(tree.root);
        tree.isBalanced(tree.root);
    }
}
