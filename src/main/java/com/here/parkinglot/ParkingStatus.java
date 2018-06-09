package com.here.parkinglot;

import java.util.Map;

public class ParkingStatus {
	
	public void displayParkingStatus(Map<Integer,Car> parkingMap) {
		System.out.println("Slot No.\tRegistration Number\tColor");
		for (Map.Entry<Integer, Car> pair : parkingMap.entrySet()) {
			if(pair.getValue()!=null) {
				System.out.println(pair.getKey()+"\t"+pair.getValue().getRegistrationNumber()+"\t"+pair.getValue().getColor());
			}
		}
	}

}
