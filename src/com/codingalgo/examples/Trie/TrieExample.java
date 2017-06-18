package com.codingalgo.examples.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieExample {

    class TrieNode {

        char c;
        int count;
        boolean isEnd;
        Map<Character, TrieNode> map;

        TrieNode(char d) {
            c = d;
            isEnd = false;
            map = new HashMap<Character, TrieNode>();
            count = 1;
        }

        public Map<Character, TrieNode> getChildren() {
            return map;
        }

        public int getCount() {
            return count;
        }

        public void setIsEnd() {
            isEnd = true;
        }

        public void incrementCount() {
            count++;
        }
    }

    TrieNode root;

    TrieExample() {
        root = new TrieNode((char) 0);
    }

    public void add(String contact) {

        TrieNode crawl = root;
        for (int i = 0; i < contact.length(); i++) {

            Map<Character, TrieNode> children = crawl.getChildren();

            if (children.containsKey(contact.charAt(i))) {
                crawl = children.get(contact.charAt(i));
                crawl.incrementCount();
            } else {
                TrieNode child = new TrieNode(contact.charAt(i));
                children.put(contact.charAt(i), child);
                crawl = child;
            }
        }
        crawl.setIsEnd();

    }

    public int find(String contact) {

        TrieNode crawl = root;
        for (int i = 0; i < contact.length(); i++) {

            Map<Character, TrieNode> children = crawl.getChildren();

            if (children.containsKey(contact.charAt(i))) {
                crawl = children.get(contact.charAt(i));
            } else {
                return 0;
            }
        }
        return crawl.getCount();

    }

    public static void main(String[] args) {

        TrieExample trie = new TrieExample();
        trie.add("hacker");
        trie.add("hackerrank");
        trie.add("hack");
        System.out.println(trie.find("hacker"));
        System.out.println(trie.find("hak"));

    }
}
