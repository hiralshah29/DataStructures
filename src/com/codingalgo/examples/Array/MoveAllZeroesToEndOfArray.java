package com.codingalgo.examples.Array;

/**
 *	eg.  {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}  to be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
 *
 */
public class MoveAllZeroesToEndOfArray {
	public static void main(String[] args) {
		MoveAllZeroesToEndOfArray obj = new MoveAllZeroesToEndOfArray();
		int[] arr = new int[] {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		
		int max = arr.length;
		for (int i = 0,  j = 0; j < max; j++) {
		  if (arr[j] != 0) {
		    if (i < j) {
		      swap(arr, i, j);
		    }
		    i++;
		  }
		}
		
		for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
	}															      
	
	public static void swap(int[] a, int i , int j){
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;  // Count of non-zero elements
 
        // Traverse the array. If element encountered is non-zero, then replace the element at index 'count' with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is incremented
 
        // Now all non-zero elements have been shifted to front and 'count' is set as index of first 0. Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }	
	

}
