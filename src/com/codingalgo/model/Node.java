package com.codingalgo.model;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int item) {
        data = item;
        left = right = null;
    }

    public String toString(){
    	return ""+data;
    }
}