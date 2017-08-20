package com.codingalgo.examples.OOD.DeviceManufacturingUnit;

public abstract class AbstractManufacturingProcess {
	
	private String processName;
	AbstractManufacturingProcess(String processName){
		this.processName = processName;
	}
	
	protected abstract void assembleDevice();
	protected abstract void testDevice();
	protected abstract void packageDevice();
	protected abstract void storeDevice();
	
	//template method
	public void launchProcesses(){
		if(processName != null && !processName.isEmpty()){
			assembleDevice();
			testDevice();
			packageDevice();
			storeDevice();
		}else{
			System.out.println("No process name specified");
		}
	}
}