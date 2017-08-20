package com.codingalgo.examples.OOD.HomeSystem;

public class TV extends Device {

	private void turnOnTV(){
		System.out.println("TV turned on");
	}
	
	private void turnOffTV(){
		System.out.println("TV turned off");
	}
	
	private void switchChannel(){
		System.out.println("Channel switched");
	}
	
	private void raiseVolume(){
		System.out.println("TV volume raised");
	}
	
	private void lowerVolume(){
		System.out.println("TV volume lowered");
	}
	
	private void mute(){
		System.out.println("TV volume muted");
	}
	
	@Override
	public void turnOnDevice() {
		turnOnTV();		
	}

	@Override
	public void turnOffDevice() {
		turnOffTV();		
	}

}
