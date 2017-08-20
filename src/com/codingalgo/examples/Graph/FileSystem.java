package com.codingalgo.examples.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 root
-> folder1
-> folder2
      -> folder3
      -> file1
-> file1
-> file2
*/


/*
 mkdir folder1
-> folder1 is created
mkdir folder1
-> folder1 already exists
mkdir folder2
-> folder2 is created
mkdir folder2
-> folder2 already exists
mkdir folder3
-> folder3 is created
cd folder2
-> you are at folder2
make file1
-> file1 is created
cd ..
-> you are at root

*/
class FileSystem{
	
	class Node {
	
		private String objName;
		private Map<String, Node> children;
		private Node parentNode;
		private boolean isFolder;
		
		Node(String name, Node parent, boolean isFolder)
		{
		    objName = name;
		    children = new HashMap<>();
		    this.parentNode = parent;
		    this.isFolder = isFolder;
		 }
		 
		 
		 public Map<String,Node> getChildren(){
		     return children;
		 
		 }
		 
		 public String getObjName(){
		     return objName;
		 }
	
	}
	
	Node root = null;
	Node crawl = null;
	
	public FileSystem(){
	    root = new Node("root", null, true);
	    crawl = root;
	}
	
	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		List<String> commands = new ArrayList<>();
		commands.add("mkdir folder1");
		commands.add("mkdir folder1");
		commands.add("mkdir folder2");
		commands.add("mkdir folder2");
		commands.add("mkdir folder3");
		commands.add("cd folder2");
		commands.add("make file1");
		commands.add("cd..");
		commands.add("cd..");
		
		fs.processInput(commands);
	}
	
	public void processInput(List<String> commands){
	    
	    String output="";
	    for(String command : commands){
	        
	        String[] inputs = command.split(" ");
	        
	        if(inputs[0].equals("mkdir")){
	            output = mkdir(inputs[1]);
	        }else if(inputs[0].equals("cd..")){
	            output = changeDirToTopLevel();
	        }else if(inputs[0].equals("cd")){
	            output = changeDirTo(inputs[1]);
	        }else if(inputs[0].equals("make")){
	            output = createFile(inputs[1]);
	        }
	        
	        System.out.println(output);
	    }
	}   
	    
	    public String mkdir(String folderName){
	    
	        Map<String,Node> children = crawl.getChildren();
	
	        if(children!= null && children.containsKey(folderName)){
	            return folderName+ " already exist.";
	        
	        }else{
	            Node folder = new Node(folderName, crawl,true);
	            children.put(folderName,folder);
	       
	            return folderName + " created";
	        }
	    
	    }
	    
	    
	    public String changeDirToTopLevel(){
	    
	        if(crawl == root){
	            return "Cannot perform the action";        
	        }
	                
	        crawl = crawl.parentNode;
	        return "You are at "+crawl.getObjName();   
	    
	    }
		
	    
	    public String changeDirTo(String folderName){
	    
	       Map<String,Node> children = crawl.getChildren();
	       
	       if(children!= null && children.containsKey(folderName)){
	           crawl = children.get(folderName);
	           return "You are at "+folderName;
	       
	       }
	       return "No such folder exist" ;
	    }
	    
	    public String createFile(String fileName){
	    
	        if(crawl == null){
	        
	            return "File cannot be created";
	        }
	        
	        Map<String,Node> children = crawl.getChildren();
	        Node file = new Node(fileName,crawl, false);
	        children.put(fileName,file);
	        
	        return fileName+ " created";
	
	    }
	
}


