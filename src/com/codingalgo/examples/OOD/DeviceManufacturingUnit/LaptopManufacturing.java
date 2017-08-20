package com.codingalgo.examples.OOD.DeviceManufacturingUnit;

public class LaptopManufacturing extends AbstractManufacturingProcess {

	LaptopManufacturing(String processName) {
		super(processName);
	}

	@Override
	public void assembleDevice() {
		System.out.println("Laptop is assembled");
	}

	@Override
	public void testDevice() {
		System.out.println("Laptop is tested");
	}

	@Override
	public void packageDevice() {
		System.out.println("Laptop is packed");
	}

	@Override
	public void storeDevice() {
		System.out.println("Laptop is stored");
	}

}
