package com.codingalgo.examples.OOD;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {

	T[] arr;
	int index=0;
	
	public CircularArray(int size) {
		arr = (T[])new Object[size];
	}
	
	//add
	public void set(int i, T val){
		if(i >= arr.length)
			arr[rightRotate(i)] = val;
		else{
			arr[i] = val;
		}
	}
	
	//get
	public T get(int i){
		if(i < 0 || i >= arr.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		return arr[i];
	}
	
	//shift
	public int rightRotate(int shift){
		if(index + shift < arr.length){
			index = index + shift;
			return index;
		}else{
			shift = (index + shift) - arr.length;
			index = 0;
			return rightRotate(shift);
		}
	}
	
	public void print(){
		for(T i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public Iterator iterator(){
		return new CircularIterator();
	}
	
	class CircularIterator<T> implements Iterator<T> {
		
		int i = -1;
		
		public boolean hasNext(){
			return (i < arr.length - 1) ;
		}
		
		public T next(){
			i++;
			return (T) arr[i];
		}

		public void remove(){
			arr[i] = null;
			i--;
		}
		
	}
	
	
	public static void main(String[] args) {
		CircularArray<Integer> a = new CircularArray<>(5);
		a.set(0, 2);
		a.set(1, 4);
		a.set(2, 6);
		a.set(3, 212);
		a.set(4, 288);
//		
//		a.print();
//		a.set(2, 2);
//		a.print();
		
		Iterator itr = a.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		for(Integer i : a){
			System.out.println(i);
		}
		
	}
}
