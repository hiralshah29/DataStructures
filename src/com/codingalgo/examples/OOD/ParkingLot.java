package com.codingalgo.examples.OOD;

import java.util.Date;

//Design a system for a parking lot where drivers can also have memberships (but also support guest drivers). The parking lot has counter screens on each row
public class ParkingLot {

	Floor[] levels;
	int minLevels;	
	
	public void parkVehicle(Vehicle v){
		
	}
}

enum Level{
	FIRST, SECOND,THIRD
}

class Floor {
	Level level;
	Row[] rows;
	
}

class Row{
	int capacity;
	int availableSpots;
	Spot[] spots;
	
	public int checkAvailability(){
		return availableSpots;
	}
}

enum SpotType {HANDICAP, MEMBER_ONLY, ELECTRIC, REGULAR};

abstract class  Spot {
	SpotType type;
	boolean isAvailable=true;
	boolean isOccupied(){ return isAvailable;}
}

class PaySystem{
	
	//checkMembership()
	//calculatePayment()
	//processPayment()
	//dispenseBill();
}

abstract class Vehicle{
	String numberPlate;
	Driver driver;
}

class Car extends Vehicle{
	
}

class Truck extends Vehicle{
	
}

class Bike extends Vehicle{
	
}

class Driver {
	String fName;
	String lName;
	String driverLicenceNumber;
	Membership member;
}

class Membership{
	String membershipNumber;
	Date membershipValidFrom;
	Date membershipValidTo;
}
