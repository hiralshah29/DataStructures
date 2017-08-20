package com.codingalgo.examples.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatteningList {
	public static void main(String[] args) {
		FlatteningList obj = new FlatteningList();
		  List<Object> list = list(1, 3,list(5, list(6,7)),10, list(11, 13, 15, list(16, 17, list(18, 19))), 20);
//		    List<Integer> returnList =  obj.flattenList(list);
//		    // -> flatten=[1, 3, 5, 6, 7, 8, 9, 10, 11, 13, 15, 16, 17, 18, 19, 20]
//		    for(Integer a : returnList){
//		    	System.out.println(a +" ");
//		    }
		  
		  obj.flattenList(list);
	}

//	  public List<Integer> flattenList(List<Object> nestedList){
//		    
//		  List<Integer> flatList = new ArrayList<Integer>();
//		 
//		  for(Object obj : nestedList){
//		        if(obj instanceof List){ // If the value is a List
//		          for(Integer integer : flattenList((List<Object>)obj)){ // traverse the returned list and add it to the list.
//		            flatList.add(integer);
//		          } 
//		        }  
//		        if(obj instanceof Integer){ // If the value is an integer number add it to list
//		          flatList.add((Integer)obj);
//		        }  
//		     } 
//		    return flatList;
//		  }
	  
	//Recursive solution
	  public void flattenList(List<Object> nestedList){
			 
		  for(Object obj : nestedList){
		        
			   if(obj instanceof List){ 
				  flattenList((List<Object>)obj);
		        }  
		        if(obj instanceof Integer){
		        	System.out.print(obj + " ");
		        }  
		     } 
		  }
	  
	  //Iterative solution
//	  public static List<Object> flattenNonRecursive(List<Object> list) {
//		    List<Object> result = new ArrayList<>();
//		    LinkedList<Object> que = new LinkedList<>(list);
//		    while (que.size() > 0) {
//		        Object e = que.remove();
//		        if (e instanceof List<?>)
//		            que.addAll(0, (List<?>)e);
//		        else
//		            result.add(e);
//		    }
//		    return result;
//		}
	  
	  public static List<Object> list(Object... args) {
		    return Arrays.asList(args);
		}
}
