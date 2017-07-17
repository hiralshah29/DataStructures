package com.codingalgo.examples.DesignPattern;

import java.util.Observable;
import java.util.Observer;

class DataStore extends Observable{
	private String data;
	
	public String getData(){
		return data;
	}
	
	public void setData(String d){
		this.data=d;
		setChanged();
	}
}

class Screen implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);			
	}		
}

public class ObserverPattern {

	public static void main(String[] args) {
		Screen screen = new Screen();
		DataStore store = new DataStore();
		store.addObserver(screen);
		updateData(store);
	}
	
	public static void updateData(DataStore store){
		store.setData("test");
		store.notifyObservers();
	}
}
