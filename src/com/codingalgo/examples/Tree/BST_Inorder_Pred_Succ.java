package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

/**
 * Inorder predecessor and successor for a given key in BST
 */
public class BST_Inorder_Pred_Succ {

	Node pred;
	Node succ;
	
	public void findPreSucc(Node root, int k){
		
		   if(root == null) return;
		   
			if(k < root.data){
				succ = root;
				findPreSucc(root.left, k);
			}else if(root.data < k){
				pred = root;
				findPreSucc(root.right, k);
			}else{
				if(root.left != null){
					// pred = rightmost node of left subtree 
					pred = root.left;
					while(pred.right!=null){
						pred=pred.right;
					}
				}
				
				if(root.right != null){
					// succ = leftmost node of right subtree
					succ = root.right;
					while(pred.left!=null){
						pred=pred.left;
					}
				}
				return;
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
		 BST_Inorder_Pred_Succ tree = new BST_Inorder_Pred_Succ();
		 
		Node root  = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		
		tree.findPreSucc(root,12);
		System.out.println(tree.pred);
		System.out.println(tree.succ);

	}
}
