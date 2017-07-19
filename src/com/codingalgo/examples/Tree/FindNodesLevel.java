package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class FindNodesLevel {
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

	public int findLevelOfNode(Node root, int k, int level){
		if(root == null){
			return 0;
		}
		if(root.data == k){
			return level;
		}
		
		int nLevel = findLevelOfNode(root.left, k, level+1);
		if (nLevel != 0)
            return nLevel;
		
		nLevel = findLevelOfNode(root.right, k, level+1);
		return nLevel;
	}
	
	public static void main(String[] args) {
		
		FindNodesLevel tree = new FindNodesLevel();
		
		Node root  = new Node(10);
		root.left = new Node(28);
		root.right = new Node(13);
		root.right.left = new Node(14);
		root.right.right = new Node(15);
		root.right.left.left = new Node(21);
		root.right.left.right = new Node(22);
		root.right.right.right = new Node(24);
		root.right.right.left = new Node(23);
		
		int level = tree.findLevelOfNode(root, 23, 1);
		System.out.println(level);
	}

}
