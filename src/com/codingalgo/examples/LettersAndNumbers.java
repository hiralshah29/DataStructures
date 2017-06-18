package com.codingalgo.examples;

import java.util.HashMap;

public class LettersAndNumbers {
	
	public static void main(String[] args) {
		
		new LettersAndNumbers().findLongestSubarray(new char[] {'a', 'a' ,'a' ,'a', '1', '1', 'a' ,'1', '1', 'a', 'a', '1', 'a', 'a' ,'1', 'a', 'a', 'a', 'a', 'a'});
	}
	
	void findLongestSubarray(char[] array) {
		/* Compute deltas between count of numbers and count of letters. */
		int[] deltas = computeDeltaArray(array);

		/* Find pair in deltas with matching values and largest span. */
		int[] match = findlongestMatch(deltas);

		System.out.println("Index from = " + (match[0] + 1) +" to = "+match[1]);
		
		/* Return the subarray. Note that it starts one *after* the initial occurence of
		* this delta.*/
//		 return extract(array, match[0] + 1, match[1]);
	 }
	
	 /* Compute the difference between the number of letters and numbers between the
	 * beginning of the array and each index. */
	 int[] computeDeltaArray(char[] array) {
		 int[] deltas = new int[array.length];
		 int delta = 0;
		 for (int i= 0; i < array.length; i++) {
			 if (Character.isLetter(array[i])) {
				 delta++;
			 } else if (Character.isDigit(array[i])) {
				 delta--;
			 }
			 deltas[i] = delta;
		 }
		 return deltas;
	 }

	 /* Find the matching pair of values in the deltas array with the largest
	 * difference in indices. */
	 int[] findlongestMatch(int[] deltas) {
		 HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		 map.put(0, -1);
		 int[] max= new int[2];
		 for (int i= 0; i < deltas.length; i++) {
			 if (!map.containsKey(deltas[i])) {
				 map.put(deltas[i], i);
			 } else {
				 int match= map.get(deltas[i]);
				 int distance= i - match;
				 int longest= max[1] - max[0];
				 if (distance > longest) {
					 max[1] = i;
					 max[0] = match;
				 }
			 }
		 }
		 return max;
	 }

	 char[] extract(char[] array, int start, int end) {
		 return null;
	 }
}
