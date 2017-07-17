package com.codingalgo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Book {
	private String name;
	private int price;
	
    public 	Book(String name){
		this.name=name;
	}
    
    public 	Book(String name,int price){
		this.name=name;
		this.price=price;
	}
	
	public String toString(){
		return name;
	}
	
//	@Override
//	public int hashCode(){
//		return price;
//	}
//	
//	@Override
//	public boolean equals(Object o){
//		if(this == o) return true;
//		if(!(o instanceof Book)){
//			return false;
//		}
//		Book b = (Book)o;
//		return name == b.name && price == b.price;
//	}
//	
	public static void main(String[] args) {
		List<Book> set = new ArrayList<>();
		Book b1 = new Book("ABC",10);
		Book b2 = new Book("ABC",10);
		Book b3 = new Book("EFG",30);
		
		set.add(b1);
		set.add(b2);
		set.add(b3);
		
		Iterator<Book> it = set.iterator();
		while(it.hasNext()){
			Book b = ((Book)it.next());
			System.out.println(b.name);
			if(b.price == 10){
				it.remove();
			}
		}
		
//		set.forEach(book -> {
//			System.out.println(book.name);
//			if(book.price == 10){
//				set.remove(book);
//			}
//		});
		
		System.out.println(set.size());
		
	}
}