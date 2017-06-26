package com.codingalgo.examples.Tree;

import java.util.LinkedList;
import java.util.Queue;

import com.codingalgo.model.Node;

public class SumOfLevel {
	
	/*******************************
					 	 1
					   /    \
					 2       3
				   /	\	/    \
		         4		5  6      7
						     \       \
					          8       9
	*******************************/
	
	public boolean sum(Node root, int K){	
		
		if(root != null){
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);

			int sum;
			while(!q.isEmpty()){
				
				Queue<Node> r = q;
				q = new LinkedList<Node>();
				sum = 0;

				for(Node n : r){
					sum += n.data;
					
					if(n.left != null){
						q.add(n.left);
					}
					if(n.right != null){
						q.add(n.right);
					}
			     }
				if(sum == K){
					return true;
				}
		}
	}		
		return false;
	}

	public static void main(String[] args) {
		
		SumOfLevel tree = new SumOfLevel();
		
		  /*******************************
				  	 1
				  /    	 \
			    2         3
			  /	  \	     /    \
			4		5  6      7
					     \       \
				           8       9

		 *******************************/
		
		Node root  = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);

		System.out.println(tree.sum(root, 22));
	}
}
