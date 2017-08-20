package com.codingalgo.examples.Tree;

import java.util.LinkedList;
import java.util.Queue;

import com.codingalgo.model.Node;

public class BST_To_Heap {

	public static int countForMinHeap = 0;
	public static int countForMaxHeap = 0;
	
	public static Node rootOfMinHeap = null;
	public static Node rootOfMaxHeap = null;
	
	public static Queue<Node> q1 = new LinkedList<Node>();
	public static Queue<Node> q2 = new LinkedList<Node>();

	//BST to Min Heap
	private static void convertBstToMinHeap(Node root)
	{
		if(root==null){
			return;
		}
		convertBstToMinHeap(root.left);
		countForMinHeap++;
		if(q1.size()==0)
		{
			rootOfMinHeap = new Node(root.data);
			q1.add(rootOfMinHeap);
		}
		else if(countForMinHeap%2==1)
		{
			Node n1 = q1.poll();
			n1.right = new Node(root.data);
			q1.add(n1.right);
		}
		else
		{
			Node n2 = q1.peek();
			n2.left = new Node(root.data);
			q1.add(n2.left);
		}
		convertBstToMinHeap(root.right);
	}
	
	//BST to Max Heap
	private static void convertBstToMaxHeap(Node root)
	{
		if(root==null){
			return;
		}
		
		convertBstToMaxHeap(root.right);		
		countForMaxHeap++;
		
		if(q2.size()==0)
		{
			rootOfMaxHeap = new Node(root.data);
			q2.add(rootOfMaxHeap);
		}
		else if(countForMaxHeap%2==1)
		{
			Node n1 = q2.poll();
			n1.right = new Node(root.data);
			q2.add(n1.right);
		}
		else
		{
			Node n2 = q2.peek();
			n2.left = new Node(root.data);
			q2.add(n2.left);
		}
		convertBstToMaxHeap(root.left);
	}
	
	
 public static void inorder(Node root){
		if(root == null){
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {

		 /* Constructing below tree							
		                8
		              /   \
		             4     12
		           /  \   /  \
		          2    6 10   14
		  */

		/* Output - Min Heap
		                2
		              /   \
		             4     6
		           /  \   /  \
		          8   10 12   14
	   */
		
		/* Output - Max Heap
					14
			       /    \
			     12     10
			    /  \     / \
			   8    6   4   2
		*/
		
		Node root  = new Node(8);
		root.left = new Node(4);
		root.right = new Node(12);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.right.left = new Node(10);
		root.right.right = new Node(14);
		
		System.out.print("BST - ");
		inorder(root);
		
//		convertBstToMinHeap(root);
//		System.out.println();
//		System.out.print("Min - ");
//		inorder(rootOfMinHeap);
		
		convertBstToMaxHeap(root);
		System.out.println();
		System.out.print("Max - ");
		inorder(rootOfMaxHeap);
		
	}
}
