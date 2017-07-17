package com.codingalgo.examples.Array;

import java.util.Random;

public class Shuffle {

	public void shuffle(int[] a){
		Random random = new Random();
		for(int i = 1 ; i < a.length ; i++){
			int k = random.nextInt(i);
			int temp = a[i];
			a[i] = a[k];
			a[k] = temp;
		}
	}
}