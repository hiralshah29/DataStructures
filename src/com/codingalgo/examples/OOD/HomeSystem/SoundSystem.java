package com.codingalgo.examples.OOD.HomeSystem;

public class SoundSystem extends Device {

	private void turnOnSoundSystem(){
		System.out.println("Sound system turned on");
	}
	
	private void turnOffSoundSystem(){
		System.out.println("Sound system turned off");
	}
	
	private void raiseVolume(){
		System.out.println("System volume raised");
	}
	
	private void lowerVolume(){
		System.out.println("System volume lowered");
	}
	
	private void mute(){
		System.out.println("System volume muted");
	}

	@Override
	public void turnOnDevice() {
		turnOnSoundSystem();		
	}

	@Override
	public void turnOffDevice() {
		turnOffSoundSystem();		
	}
}
