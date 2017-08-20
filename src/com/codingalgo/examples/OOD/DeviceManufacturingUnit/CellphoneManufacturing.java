package com.codingalgo.examples.OOD.DeviceManufacturingUnit;

public class CellphoneManufacturing extends AbstractManufacturingProcess {

	CellphoneManufacturing(String processName) {
		super(processName);
	}

	@Override
	public void assembleDevice() {
		System.out.println("Cellphone is assembled");
	}

	@Override
	public void testDevice() {
		System.out.println("Cellphone is tested");
	}

	@Override
	public void packageDevice() {
		System.out.println("Cellphone is packed");
	}

	@Override
	public void storeDevice() {
		System.out.println("Cellphone is stored");
	}

}
