package com.codingalgo.examples.Array;

/**
 * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. 
 * The array might also contain duplicates. 
 * You may assume that both x and y are different and present in arr[].

	Examples:
	Input: arr[] = {1, 2}, x = 1, y = 2
	Output: Minimum distance between 1 and 2 is 1.
	
	Input: arr[] = {3, 4, 5}, x = 3, y = 5
	Output: Minimum distance between 3 and 5 is 2.
	
	Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
	Output: Minimum distance between 3 and 6 is 4.
	
	Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
	Output: Minimum distance between 3 and 2 is 1.
 *
 */
public class FindMinDistanceBetweenTwoNumbers {

	public static void main(String[] args) {
		System.out.println(findDistance(new int[] {2, 5, 3, 5, 4, 4, 3, 2}, 3, 2));
	}
	
	public static int findDistance(int[] a, int x , int y){
		
		if(a==null || a.length < 2) return 0;
		
		int prev=0, i=0, dist=Integer.MAX_VALUE;
		
		for( i = 0 ; i < a.length ; i++){
			if(a[i] == x || a[i] == y){
				prev = i;
				break;
			}	
		}
		
		for(; i < a.length; i++){
			if(a[i] == x || a[i] == y){
				if(a[i] != a[prev] && (i-prev) < dist){
					dist = i - prev;
				}
				prev =i;
			}
		}
		return dist;
	}
}
