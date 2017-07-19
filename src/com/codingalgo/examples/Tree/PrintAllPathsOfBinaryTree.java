package com.codingalgo.examples.Tree;

import java.util.ArrayList;

import com.codingalgo.model.Node;

public class PrintAllPathsOfBinaryTree {

	// Driver program to test the above functions
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
		
		PrintAllPathsOfBinaryTree tree = new PrintAllPathsOfBinaryTree();
		
		Node root  = new Node(10);
		root.left = new Node(28);
		root.right = new Node(13);
		root.right.left = new Node(14);
		root.right.right = new Node(15);
		root.right.left.left = new Node(21);
		root.right.left.right = new Node(22);
		root.right.right.right = new Node(24);
		root.right.right.left = new Node(23);
		
		tree.printAllPath(root, new ArrayList<Node>());
		
	}

	public void printAllPath(Node root, ArrayList<Node> paths){
		if(root == null){
			return;
		}
		paths.add(root);

		if(root.left == null && root.right == null){
			print(paths);
		}
		
		printAllPath(root.left,paths);
		printAllPath(root.right,paths);
		paths.remove(root);
		
	}
	
	public void print(ArrayList<Node> paths){
		for(Node n : paths){
			System.out.print(n.data + " ");
		}
		System.out.println();
	}
}
