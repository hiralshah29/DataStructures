package com.codingalgo.examples.Tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.codingalgo.model.Node;

// Class for a Binary Tree
public class 	PrintTreeVertically {

	Map<Integer,ArrayList<Integer>> verticle = new TreeMap<>();
	
	private  void getTreeLength(Node node, int hd){
			
		if(node == null){
			return;
		}
		
		ArrayList<Integer> list = verticle.get(hd);		
		if(list == null){
			list = new ArrayList<Integer>();		
		}
		
		list.add(node.data);
		verticle.put(hd, list);
		
		getTreeLength(node.left, hd - 1 );
		getTreeLength(node.right, hd + 1 );	
	}
	
	private void printVerticle(){
		
		verticle.forEach((k,v) -> {
			v.forEach(item -> {
				System.out.print(item + " ");
			});
			System.out.println();
		});
	}
	
	public static void main(String[] args) {
		
		PrintTreeVertically tree = new PrintTreeVertically();
		Node root  = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		
		tree.getTreeLength(root, 0);
		tree.printVerticle();
	}
}