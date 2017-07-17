package com.codingalgo.examples.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a method to find the frequency of occurrences of any given word in a book. What if we were running this algorithm multiple times
 */

public class WordFrequencies {

	Map<String,Integer> wordFreqMapping = new HashMap<>();
	
	public static void main(String[] args) {
		WordFrequencies obj = new WordFrequencies();
		obj.setFrequency(new String[] {"hello","hi","hello","hey"});
	
		System.out.println(obj.getFrequency("HELLO"));
		System.out.println(obj.getFrequency("hI"));
		System.out.println(obj.getFrequency("heY"));
		
	}
	
	public void setFrequency(String[] book){
		for(String word : book){
			wordFreqMapping.computeIfPresent(word.toLowerCase(), (k,v)->v+1);
			wordFreqMapping.putIfAbsent(word, 1);
		}		
	}
	
	public int getFrequency(String word){
		return wordFreqMapping.get(word.toLowerCase())	;
	}
	

}
