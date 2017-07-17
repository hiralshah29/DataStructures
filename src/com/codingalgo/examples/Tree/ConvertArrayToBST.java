package com.codingalgo.examples.Tree;

import com.codingalgo.model.Node;

public class ConvertArrayToBST {
	public static void main(String[] args) {
		converToBST(new int[] {1, 2, 3, 4, 5, 6, 7});
//		int[] a = null;
//		converToBST(a);
	}	
	
	public static void converToBST(int[] a){
		if(a != null && a.length != 0){
			Node n =convert(a,0,a.length-1);
			System.out.println(n.data);
		}else
		System.out.println("Invalid array");
	}
	
	/**
	 * 1 2 3 4 5 6 7
	 * 
	 *           4
	 *         /    \
	 *       2       6
	 *     /   \    /   \
	 *   1     3 5     7  
	 *     
	 */	
	
	public static Node convert(int[] ar, int st, int end){
		
		if(end < st) return null;
		int mid = (st + end) / 2;
		Node root = new Node(ar[mid]);
		root.left = convert(ar, 0, mid-1);
		root.right = convert(ar, mid+1, end);
		return root;
	}
}
