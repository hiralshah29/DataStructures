package com.codingalgo.examples.misc;

import com.codingalgo.model.Book;
import java.util.Iterator;

public class CustomIterator {

	public static void main(String[] args) {
		BookShop shop = new BookShop();
		shop.addBook(new Book("abc"));
		shop.addBook(new Book("def"));
		shop.addBook(new Book("xyz"));
		System.out.println(shop.size());
		
		for(Book b : shop){
			System.out.println("Name = "+b);
		}
		
//		Iterator<Book> itr = shop.iterator();
//		while(itr.hasNext()){
//			System.out.println("Name = " +itr.next());
//		}	
	}
}

class BookShop  implements Iterable<Book> {
	
	Book[] list = new Book[5];
	int curr_index = 0;
	
  @Override
	public Iterator<Book> iterator() {
		return new BookListIterator();
	}
  
    public int size(){
    	return curr_index;
    }
   public void addBook(Book b){
	   list[curr_index++]=b;
   }
  	class BookListIterator implements Iterator<Book> {
  		
  		int index = 0;
  		
  		public boolean hasNext(){
  			return index >= curr_index ? false : true;
  		}
  		
  		public Book next(){
  			return list[index++];
  		}
  		
  		public void remove(){
  			list[index]=null;
  			--index;
  		}
  	}
}