package com.codingalgo.examples.Tree;

import java.util.LinkedList;

import com.codingalgo.model.TreeNode;

public class SerializeBinaryTree {

		/*******************************
				  10
				/       \
			28         13
					    /     \
					  14      15
					 /   \     /   \
				  21   22   23   24
	
	*******************************/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                sb.append(String.valueOf(t.key) + ",");
                queue.add(t.left);
                queue.add(t.right);
            } else {
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();

            if (t == null)
                continue;

            if (!arr[i].equals("#")) {
                t.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.left);

            } else {
                t.left = null;
                queue.offer(null);
            }
            i++;

            if (!arr[i].equals("#")) {
                t.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.right);

            } else {
                t.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
    	
    	TreeNode root  = new TreeNode(10);
		root.left = new TreeNode(28);
		root.right = new TreeNode(13);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(15);
		root.right.left.left = new TreeNode(21);
		root.right.left.right = new TreeNode(22);
		root.right.right.right = new TreeNode(24);
		root.right.right.left = new TreeNode(23);
        
		String ser = new SerializeBinaryTree().serialize(root);
		TreeNode n = new SerializeBinaryTree().deserialize(ser);
		System.out.println(n.key);

    }

}
