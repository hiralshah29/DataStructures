package CodingAlgo;

import model.ListNode;

class LinkedListPalindrome {
    ListNode head;

    // A utility function to check if str is palindrome
    // or not
    boolean isPalidromeUtil(String str) {
        int length = str.length();

        // Match characters from beginning and
        // end.
        for (int i = 0; i < length; i++)
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;

        return true;
    }

    // Returns true if string formed by linked
    // list is palindrome
    boolean isPalindrome() {
        ListNode node = head;

        // Append all nodes to form a string
        String str = "";
        while (node != null) {
            str = str.concat(node.data);
            node = node.next;
        }

        // Check if the formed string is palindrome
        return isPalidromeUtil(str);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        LinkedListPalindrome list = new LinkedListPalindrome();
        list.head = new ListNode("a");
        list.head.next = new ListNode("bc");
        list.head.next.next = new ListNode("d");
        list.head.next.next.next = new ListNode("dcb");
        list.head.next.next.next.next = new ListNode("a");

        System.out.println(list.isPalindrome());

    }
}