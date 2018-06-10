package com.here.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.here.entities.Car;

public class ParkingStatus {
	
	public void displayParkingStatus(Map<Integer,Car> parkingMap) {
		System.out.println("Slot No.\tRegistration Number\tColor");
		for (Map.Entry<Integer, Car> pair : parkingMap.entrySet()) {
			if(pair.getValue()!=null) {
				System.out.println(pair.getKey()+"\t"+pair.getValue().getRegistrationNumber()+"\t"+pair.getValue().getColor());
			}
		}
	}
	
	public void getSlotsWithCarColors(Map<Integer,Car> parkingMap,String color) {
		List<Integer> slots = new ArrayList<>();
		for (Map.Entry<Integer, Car> pair : parkingMap.entrySet()) {
			Car car = pair.getValue();
			if(car!=null) {
				if(car.getColor().equalsIgnoreCase(color)) {
					slots.add(pair.getKey());
					System.out.print(pair.getKey()+",");
				}
			}
		}
		if(slots.isEmpty()) {
			System.out.print(color+" not found");
		}
		System.out.println();
	}
	
	public void getSlotsByRegNo(Map<Integer,Car> parkingMap,String regNo) {
		List<Integer> slots = new ArrayList<>();
		for (Map.Entry<Integer, Car> pair : parkingMap.entrySet()) {
			Car car = pair.getValue();
			if(car!=null) {
				if(car.getRegistrationNumber().equalsIgnoreCase(regNo)) {
					slots.add(pair.getKey());
					System.out.print(pair.getKey()+",");
				}
			}
		}
		if(slots.isEmpty()) {
			System.out.print(regNo+" not found");
		}
		System.out.println();
	}
	
	public void getRegNoWithCarColors(Map<Integer,Car> parkingMap, String color) {
		List<String> regNos = new ArrayList<>();
		for (Map.Entry<Integer, Car> pair : parkingMap.entrySet()) {
			Car car = pair.getValue();
			if(car!=null) {
				if(car.getColor().equalsIgnoreCase(color)) {
					regNos.add(car.getRegistrationNumber());
					System.out.print(car.getRegistrationNumber()+",");
				}
			}
		}
		if(regNos.isEmpty()) {
			System.out.print(color+" not found");
		}
		System.out.println();
	}

}
