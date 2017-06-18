package com.codingalgo.examples;

import java.util.Arrays;
import java.util.List;

class Comparator {

    public boolean Compare(int a, int b) {
        if (a == b) {
            return true;
        }
        return false;
    }

    public boolean Compare(String a, String b) {
        if (a != null && b != null) {
            return a.equals(b);
        }
        return false;
    }

    public boolean Compare(int[] a, int[] b) {
        if (a != null && b != null && a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }

            }
            return true;
        }
        return false;
    }
}

public class TestMainPro {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestMainPro pro = new TestMainPro();
        // pro.testElectionCount();
        // pro.permutation("", "123");
        int[] arry = { 2, 3, 10, 2, 4, 8, 1 };
        int[] arry2 = { 7, 9, 5, 6, 3, 2 };
        // System.out.println(pro.isBinaryPal(11000011));
        // System.out.println(pro.maxDifference(arry2));

        try {
            List ints = Arrays.asList(1, 2, 3);
            // System.out.println(ints.get(4));
        } catch (NullPointerException e) {

        }

        int a = 2;
        int b = 1;
        int c = 1;
        int d = 1;

        String s = "" + a + b + c + d;

        a = (int) Math.pow(Integer.parseInt(s), 0);

        System.out.println(a);
    }

    /*
     * private void testElectionCount() {
     * 
     * List<Integer> voterCount = new ArrayList<Integer>(); voterCount.add(8); voterCount.add(12); voterCount.add(17); voterCount.add(20); voterCount.add(22); voterCount.add(5); voterCount.add(6);
     * 
     * Collections.sort(voterCount, new Comparator<Integer>() {
     * 
     * @Override public int compare(Integer o1, Integer o2) { // TODO Auto-generated method stub return o2.compareTo(o1); }
     * 
     * });
     * 
     * System.out.println(voterCount); }
     */
    public static boolean isBinary(int number) {
        int copyOfInput = number;
        while (copyOfInput != 0) {
            if (copyOfInput % 10 > 1) {
                return false;
            }
            copyOfInput = copyOfInput / 10;
        }
        return true;
    }

    public boolean isBinaryPal(int orig) {
        int copy = orig;
        int reversed = 0;

        while (copy != 0) {
            reversed <<= 1;
            reversed |= (copy & 1);
            copy >>>= 1;
        }
        return (reversed == orig);
    }

    // Check if binary representation of a number is palindrome

    // Is 1000111 binary? :true
    // Is 10300111 binary? :false

    private void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    private int maxDifference(int array[]) {
        int result = -1;
        int small = 0;
        if (array != null && array.length > 1) {
            small = array[0];
            if (array[0] < array[1]) {
                result = array[0] - array[1];
            }
            for (int i = 1; i < array.length; i++) {
                if (array[i] < small) {
                    small = array[i];
                } else {
                    int temp = array[i] - small;
                    if (temp > result) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}
