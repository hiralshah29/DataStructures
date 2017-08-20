package com.codingalgo.examples.OOD.HomeSystem;

public class User {

	public static void main(String[] args) {
		
		UniversalRemoteControl remote = UniversalRemoteControl.getInstance();
		
		TV lg = new TV();
		SoundSystem bose = new SoundSystem();
		
		remote.configureDevice(DeviceType.TV, lg);
		remote.configureDevice(DeviceType.SoundSystem, bose);	
		
		remote.connectToDevice(DeviceType.TV);		
		remote.clickOnDevice();
		
		remote.connectToDevice(DeviceType.SoundSystem);		
		remote.clickOnDevice();
	}
	
}
