package com.codingalgo.examples.Tree;

import java.util.Stack;

import com.codingalgo.model.Node;


public class BST_KthSmallestNode {
     //Method -1
	 public static Node findKthSmallest_1(Node node, int k){
			
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
	 
//	Method -2 
	int count = 0;
	Integer smallest = null;

	public void findKthSmallest_2(Node root, int k) {

		if (root == null) {
			return;
		}

		findKthSmallest_2(root.left, k);
		count++;
		if (k == count) {
			smallest = root.data;
			return;
		}
		findKthSmallest_2(root.right, k);

	}
	
	 public static void main(String[] args) {
			
		 BST_KthSmallestNode tree = new BST_KthSmallestNode();
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
			
//			Node n = findKthSmallest_1(root,3);
//			System.out.println(n.data);
			
//			tree.findKthSmallest_2(root,3);
//			System.out.println(tree.smallest);
		}
}
