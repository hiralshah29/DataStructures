package model;

//Class for a tree node
public class TreeNode {

    // data members
    public int key;
    public TreeNode left;
    public TreeNode right;

    // Accessor methods
    public int key() {
        return key;
    }

    public TreeNode left() {
        return left;
    }

    public TreeNode right() {
        return right;
    }

    // Constructor
    public TreeNode(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    // Methods to set left and right subtrees
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
