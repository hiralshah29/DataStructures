package com.codingalgo.examples.Tree;

import java.util.ArrayList;
import java.util.List;

import com.codingalgo.model.Node;

public class PrintAncestorsOfNode {

		/*******************************
			  10
			/      \
		28         13
				    /     \
				  14       15
				 /   \     /  \
			21   22   23   24
	
	*******************************/

	public static void main(String[] args) {
			
		PrintAncestorsOfNode tree = new PrintAncestorsOfNode();
			
			Node root  = new Node(10);
			root.left = new Node(28);
			root.right = new Node(13);
			root.right.left = new Node(14);
			root.right.right = new Node(15);
			root.right.left.left = new Node(21);
			root.right.left.right = new Node(22);
			root.right.right.right = new Node(24);
			root.right.right.left = new Node(23);
			
			tree.printAncestors(root,new ArrayList<Integer>(),23);
	}
	
	public void printAncestors(Node n, List<Integer> list, int k){
		if(n == null){
			return;
		}
		list.add(n.data);
		
		if(n.data == k ){
			print(list);
		}
		printAncestors(n.left,list,k);
		printAncestors(n.right,list,k);
		list.remove(Integer.valueOf(n.data));
	}
	
	public void print(List<Integer> list){
		list.forEach(item -> {
			System.out.print(item + " ");
		});
	System.out.println();		
	}
}
