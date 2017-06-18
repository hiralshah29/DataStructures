package com.codingalgo.examples;

import java.util.ArrayList;
import java.util.HashMap;

import com.codingalgo.model.TreeNode;

// Class for a Binary Tree
class Tree {

    private TreeNode root;

    // Constructors
    public Tree() {
        root = null;
    }

    public Tree(TreeNode n) {
        root = n;
    }

    // Method to be called by the consumer classes like Main class
    public void VerticalSumMain() {
        VerticalSum(root);
    }

    // A wrapper over VerticalSumUtil()
    private void VerticalSum(TreeNode root) {

        // base case
        if (root == null) {
            return;
        }

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        HashMap<Integer, ArrayList> hM2 = new HashMap<Integer, ArrayList>();
        // Calls the VerticalSumUtil() to store the vertical sum values in hM
        // hd is horizontal distance of current node with respect to root.
        // VerticalSumUtil(root, 0, hM);
        printVeritcalNodes(root, 0, hM2);
        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            // System.out.println(hM.entrySet());
        }
        System.out.println(hM2.entrySet());
    }

    // Traverses the tree in Inoorder form and builds a hashMap hM that
    // contains the vertical sum
    private void VerticalSumUtil(TreeNode root, int hD, HashMap<Integer, Integer> hM) {

        // base case
        if (root == null) {
            return;
        }

        // Store the values in hM for left subtree
        VerticalSumUtil(root.left(), hD - 1, hM);

        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.key());

        // Store the values in hM for right subtree
        VerticalSumUtil(root.right(), hD + 1, hM);
    }

    // contains the vertical sum
    private void printVeritcalNodes(TreeNode root, int hD, HashMap<Integer, ArrayList> hM) {

        // base case
        if (root == null) {
            return;
        }

        // Store the values in hM for left subtree
        printVeritcalNodes(root.left(), hD - 1, hM);

        // Update vertical sum for hD of this node
        // int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        ArrayList temp = (hM.get(hD) == null) ? new ArrayList() : hM.get(hD);
        temp.add(root.key());
        hM.put(hD, temp);

        // Store the values in hM for right subtree
        printVeritcalNodes(root.right(), hD + 1, hM);
    }

    void serialize(TreeNode root) {
        // If current node is NULL, store marker
        if (root == null) {
            System.out.print(-1 + ",");
            return;
        }

        // Else, store current node and recur for its children
        System.out.print(root.key() + ",");
        serialize(root.left());
        serialize(root.right());
    }

    TreeNode deSerialize(TreeNode node, int[] array, Integer index) {
        // Read next item from file. If theere are no more items or next
        // item is marker, then return
        int val = index.intValue();
        if (array[index] == -1) {
            index++;
            return null;
        }

        // Else create node with this item and recur for children
        node = new TreeNode(array[index]);
        index++;
        deSerialize(node.left(), array, index);
        deSerialize(node.right(), array, index);
        return node;
    }
}

// Driver class to test the verticalSum methods
public class PrintTreeVertically {

    public static void main(String[] args) {

        // Create following Binary Tree
        // 1
        // / \
        // 2 3
        /// /\ /\
        // 4 5 6 7
        // \ \
        // 8 9
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left()
                .setLeft(new TreeNode(4));
        root.left()
                .setRight(new TreeNode(5));
        root.right()
                .setLeft(new TreeNode(6));
        root.right()
                .setRight(new TreeNode(7));
        root.right()
                .left()
                .setRight(new TreeNode(8));
        root.right()
                .right()
                .setRight(new TreeNode(9));

        Tree t = new Tree(root);
        System.out.println("Following are the values of vertical sums with " + "the positions of the columns with respect to root ");
        t.VerticalSumMain();
        // t.serialize(root);

        TreeNode node = null;
        int[] array = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, 8, -1, -1, 7, -1, 9, -1, -1 };
        node = t.deSerialize(node, array, new Integer(0));
        System.out.println(node);
        // t.serialize(node);
    }
}