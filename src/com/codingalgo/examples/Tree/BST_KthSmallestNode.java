package com.codingalgo.examples.Tree;

import java.util.Stack;

import com.codingalgo.model.Node;


public class BST_KthSmallestNode {

	 public static Node findKthSmallest(Node node, int k){
			
			Stack<Node> s = new Stack<Node>();
			Node smallest = null;
			
			while(!s.isEmpty() || node != null){
				
				if(node != null){
					s.add(node);
					node = node.left;
				}else{
					node = s.pop();
					k--;
					if(k == 0 ){
						smallest = node;
						break;		
					}
					node = node.right;
				}
			}
			return smallest;
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
			
			Node n = findKthSmallest(root,3);
			System.out.println(n.data);
			
		}
}
