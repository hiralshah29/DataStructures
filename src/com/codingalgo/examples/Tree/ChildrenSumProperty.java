package com.codingalgo.examples.Tree;

import java.util.LinkedList;
import java.util.Queue;

import com.codingalgo.model.Node;

public class ChildrenSumProperty {
	
	public static void main(String[] args) {
	 /* Constructing below tree							
					    10
					  /   \
					8      2
				   /  \   /  
				  3   5 2
     */

			Node root  = new Node(10);
			root.left = new Node(8);
			root.right = new Node(2);
			root.left.left = new Node(3);
			root.left.right = new Node(5);
			root.right.left = new Node(2);
			
			int result = new ChildrenSumProperty().isChildrenProperty(root);
			if(result == 1){
				System.out.println("Satisfies");
			}else{
				System.out.println("Does not satisfy");
			}
	}
	
	//method 2
	public int isChildrenProperty_2(Node root){

		int left = 0;
		int right = 0;
		
		if(root == null || (root.left == null && root.right == null)) {
			return 1;
		}
		
		if(root.left != null){
			left = root.left.data;
		}
		if(root.right != null){
			left = root.right.data;
		}
		
		if(root.data == (left + right) && isChildrenProperty_2(root.left)!=0 && isChildrenProperty_2(root.right) != 0){
			return 1;
		}else{
			return 0;
		}
	}
	
	//method 1
	public int isChildrenProperty(Node root){
		if(root == null) return 1;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()){
			Node n = q.poll();
			int left = 0;
			int right = 0;
			
			if(n.left == null && n.right == null){
				continue;
			}else{
			
				if(n.left != null){
					left = n.left.data;
					q.offer(n.left);
				}
				
				if(n.right !=null){
					q.offer(n.right);
					right=n.right.data;				
				}
				
				if(n.data != (left + right)){
					return 0;
				}	
			}	
		}
		return 1;
	}
}
