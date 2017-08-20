package com.codingalgo.examples.OOD.HomeSystem;

import java.util.HashMap;
import java.util.Map;

public class UniversalRemoteControl {

	private static UniversalRemoteControl INSTANCE = new UniversalRemoteControl();
	private Device device = null;
	private Map<DeviceType, Device> deviceList = new HashMap<>();
	
	private UniversalRemoteControl(){
		
	}
	 
	public static UniversalRemoteControl getInstance(){
		return INSTANCE;
	}
	
	public void configureDevice(DeviceType type,  Device device){
		deviceList.put(type, device);
	}
	
	public void connectToDevice(DeviceType type){
		device = deviceList.get(type);
		System.out.println("Connected to " + type.toString());
	}
	
	public void clickOnDevice(){
		device.turnOnDevice();
	}
	
	public void clickOffDevice(){
		device.turnOffDevice();
	}
	
}
