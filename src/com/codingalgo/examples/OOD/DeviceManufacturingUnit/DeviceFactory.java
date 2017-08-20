package com.codingalgo.examples.OOD.DeviceManufacturingUnit;

public class DeviceFactory {
	 public static void main(String[] args) {
		 AbstractManufacturingProcess manufacture = new CellphoneManufacturing("Smarphone process");
		 manufacture.launchProcesses();
		 
		 manufacture = new LaptopManufacturing("Apple Air process");
		 manufacture.launchProcesses();
	}
}
