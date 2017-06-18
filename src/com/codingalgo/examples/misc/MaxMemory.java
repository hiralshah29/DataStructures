package com.codingalgo.examples.misc;

import java.util.ArrayList;
import java.util.List;

import com.codingalgo.model.Task;

/** Program to find maximum memory required to complete a list of task */

public class MaxMemory {

	public static void main(String[] args) {
		
		List<Task> list = new ArrayList<>();
		list.add(new Task(2,5,4));
		list.add(new Task(1,3,2));
		list.add(new Task(4,7,3));
		list.add(new Task(3,6,1));
		
		System.out.println("Maximum memory: "+findMaxMemory(list));
	}
	
	public static int findMaxMemory(List<Task> list){
		
		int maxEndTime = 0; 
		for(int i = 0 ; i < list.size() ; i++){
			Task k = list.get(i);
			if(maxEndTime < k.getEnd()){
				maxEndTime = k.getEnd();
			}
		}	
		
		int a[] = new int[maxEndTime + 2];
		int maxMemory=0;
		int totalMemory = 0;
		
		for(int i = 0 ; i < list.size() ; i++){
			Task k = list.get(i);
			a[k.getSt()]+=k.getMemory();
			a[k.getEnd()+1]-=k.getMemory();
		}	
		
		for(int i = 0 ; i < a.length ; i++){
			
			totalMemory+=a[i];
			a[i] = totalMemory;
			if(totalMemory > maxMemory){
				maxMemory = totalMemory;
			}		
		}		
		return maxMemory;
	}
}
