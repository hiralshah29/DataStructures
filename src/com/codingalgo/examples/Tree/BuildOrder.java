package com.codingalgo.examples.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//You are given a list of projects and a list of dependencies (which is a list of pairs of
//projects, where the second project is dependent on the first project). All of a project's dependencies
//must be built before the project is. Find a build order that will allow the projects to be built. If there
//is no valid build order, return an error.

public class BuildOrder {
	
	Map<String, List<String>> adj = new HashMap<>();
	Map<String,Boolean> visited = null;
	List<String> buildlist = new ArrayList<>();
	
	BuildOrder(String[] arr){
		visited = new HashMap<String,Boolean>();
		for(String n : arr){
			adj.put(n, new ArrayList<>());
		}
	}
	
	public void addEdge(String[][] a){
		List<String> list = null;
		
		for(String[] p : a){
			list = adj.get(p[1]);
			list.add(p[0]);
			adj.put(p[1], list);
		}
	}
	
	public void createBuildOrder(){
		Queue<String> q = new LinkedList<>();
		for(Map.Entry<String, List<String>> entry : adj.entrySet()){
			if(entry.getValue().size() == 0){
				q.offer(entry.getKey());
			}
		}
		
		while(!q.isEmpty()){
			String x = q.poll();
			buildlist.add(x);
			visited.put(x, true);
			for(String dep : adj.get(x)){
				if(!visited.containsKey(dep)){
					q.offer(dep);
				}
			}
		}		
	}
	
	public void printOrder(){
		buildlist.forEach(proj -> {
			System.out.print(proj + " ");
		});
	}
	// output - f, e, a, b, d, c
	public static void main(String[] args) {
		
		String a = new String("A");
		String b = new String("B");
		String c = new String("C");
		String d = new String("D");
		String e = new String("E");
		String f = new String("F");

		String[] projects = new String[6];
		projects[0]=a;
		projects[1]=b;
		projects[2]=c;
		projects[3]=d;
		projects[4]=e;
		projects[5]=f;
		
		String[][] dep = {{a,d},{f,b},{b,d},{f,a},{d,c}};
		
		BuildOrder build = new BuildOrder(projects);
		build.addEdge(dep);
		build.createBuildOrder();
		build.printOrder();
	}
}
