package com.codingalgo.model;

public class ListNode {
    public String data;
    public ListNode next;
    
    public ListNode prev;
    public int intData;

    public ListNode(String data) {
        this.data = data;
        next = null;
    }
    
    public ListNode(int data) {
        this.intData = data;
        next = null;
        prev = null;
    }
}