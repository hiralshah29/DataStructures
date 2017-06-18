package com.codingalgo.model;

public class Task {

	private int st;
	private int end;
	private int memory;
	
	public Task(int st, int end, int memory){
		this.st=st;
		this.end=end;
		this.memory=memory;
	}

	public int getSt() {
		return st;
	}

	public int getEnd() {
		return end;
	}

	public int getMemory() {
		return memory;
	}
	
	public String toString(){
		return ""+st+" : "+end+" : "+memory;
	}
}
