package com.codingalgo.examples.misc;

import com.codingalgo.model.TreeNode;

public class FlipBinaryTree {

    // http://www.geeksforgeeks.org/flip-binary-tree/

    TreeNode flipBinaryTree(TreeNode root) {
        // Base cases
        if (root == null)
            return root;
        if (root.left == null && root.right == null)
            return root;

        // recursively call the same method
        TreeNode flippedRoot = flipBinaryTree(root.left);

        // rearranging main root Node after returning
        // from recursive call
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return flippedRoot;
    }

}
