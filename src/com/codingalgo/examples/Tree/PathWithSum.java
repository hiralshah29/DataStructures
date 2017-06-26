package com.codingalgo.examples.Tree;

import java.util.ArrayList;
import java.util.List;

import com.codingalgo.model.Node;

/** Program to find all paths starting from root having sum equal to k  */

public class PathWithSum {

	/*******************************
				  10
				/       \
			28         13
					    /     \
					  14       15
					 /   \     /  \
				21   22   23   24
	
	*******************************/
	public void pathWithSumFromRootNode(Node node, int k, int sum, List<Node> path){
		
			if(node == null){
				return;
			}
			
			sum+=node.data;
			path.add(node);
			
			if(sum == k){
				printPath(path);
			}
			
			pathWithSumFromRootNode(node.left, k, sum,path);
			pathWithSumFromRootNode(node.right, k, sum,path);
			path.remove(node);
	}

	private void printPath(List<Node> path){
		path.forEach(item -> {
				System.out.print(item.data + " ");
			});
		System.out.println();		
	}

	public static void main(String[] args) {
			
			PathWithSum tree = new PathWithSum();
			
			Node root  = new Node(10);
			root.left = new Node(28);
			root.right = new Node(13);
			root.right.left = new Node(14);
			root.right.right = new Node(15);
			root.right.left.left = new Node(21);
			root.right.left.right = new Node(22);
			root.right.right.right = new Node(24);
			root.right.right.left = new Node(23);
			
			tree.pathWithSumFromRootNode(root,38,0,new ArrayList<Node>());
	}
}
