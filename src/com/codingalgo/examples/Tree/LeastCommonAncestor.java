package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

/** Find LCA in binary tree */

public class LeastCommonAncestor {
	
	public Node findLCA(Node node,int n1,int n2){
		
		if(node == null){
			return null;
		}
		
		if(node.data == n1 || node.data ==n2){
			return node;
		}
		
		Node left = findLCA(node.left,n1,n2);
		Node right = findLCA(node.right,n1,n2);
		
		if(left != null && right != null){
			return node;
		}
		
		return (left == null) ? right : left;
	}	
	
	public static void main(String[] args) {
		
		LeastCommonAncestor lca = new LeastCommonAncestor();
		
		 /* Constructing below tree							
				        1
				      /   \
				    40     12
				   /  \      /  \
			    22    10 60   14
			   /
			30
		*/
		
		Node root  = new Node(1);
		root.left = new Node(40);
		root.right = new Node(12);
		root.left.left = new Node(22);
		root.left.left.left = new Node(30);
		root.left.right = new Node(10);
		root.right.left = new Node(60);
		root.right.right = new Node(14);
		
		Node node = lca.findLCA(root,30,10);
		if (node == null) 
			System.out.println("none");
		else 
			System.out.println(node.data);
	}
}