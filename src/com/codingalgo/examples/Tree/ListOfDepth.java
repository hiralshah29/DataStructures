package com.codingalgo.examples.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.codingalgo.model.Node;

public class ListOfDepth {
	/*******************************
				  10
				/       \
			28         13
					    /     \
					  14       15
					 /   \     /  \
				21   22   23   24
	
	*******************************/
	public static List<LinkedList<Node>>  createList(Node n){
		
		if(n == null){
			return null;
		}
		
		List<LinkedList<Node>> list = new ArrayList<>();
		LinkedList<Node> q = new LinkedList<>();
		q.offer(n);
		
		while(!q.isEmpty()){
			
			list.add(q);
			LinkedList<Node> r = q;
			q = new LinkedList<>();
			for(Node n1 : r){				
				if(n1.left != null){
					q.add(n1.left);				
				}
				if(n1.right != null){
					q.add(n1.right);				
				}
			}	
		}				
		return list;
	}
	
	public static void main(String[] args) {
		
		Node root  = new Node(10);
		root.left = new Node(28);
		root.right = new Node(13);
		root.right.left = new Node(14);
		root.right.right = new Node(15);
		root.right.left.left = new Node(21);
		root.right.left.right = new Node(22);
		root.right.right.right = new Node(24);
		root.right.right.left = new Node(23);
		
		List<LinkedList<Node>> list = createList(root);
		
		list.forEach(l -> {
			l.forEach(i ->{
				System.out.print(i + " ");
			});
			System.out.println();
		});
		
	}
}
