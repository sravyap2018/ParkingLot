package com.here.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ParkingTicketGenerator {
	ParkingStatus parkingStatus = new ParkingStatus();
	List<Integer> emptySlots = new ArrayList<>();
	HashMap<Integer, Car> parkingMap = new HashMap<>();
	int noOfSlots = 0;

	public void generateTicket(String[] details) {
		String action=details[0];
		if(action.trim().equalsIgnoreCase("create_parking_lot")) {
			noOfSlots=Integer.parseInt(details[1]);
			for(int i=1;i<=noOfSlots;i++) {
				parkingMap.put(i, null);
				emptySlots.add(i);					
			}
			System.out.println("Allocated Parking Lot with "+noOfSlots+" slots");
		}
		else if(action.trim().equalsIgnoreCase("park")) {
			if(!emptySlots.isEmpty()) {
				Car car = new Car();
				car.setRegistrationNumber(details[1]);
				car.setColor(details[2]);
				parkingMap.put(emptySlots.get(0), car);
				System.out.println("Allocated Parking Slot "+emptySlots.get(0));
				emptySlots.remove(emptySlots.get(0));
			}
			else {
				System.out.println("Sorry, parking lot is full");
			}
		}
		else if(action.trim().equalsIgnoreCase("leave")) {
			parkingMap.put(Integer.parseInt(details[1]),null);
			System.out.println("Slot Number "+details[1]+" is free");
			emptySlots.add(Integer.parseInt(details[1]));
			if(emptySlots.size()>1) {
				Collections.sort(emptySlots);
			}
		}
		else if(action.trim().equalsIgnoreCase("status")) {
			parkingStatus.displayParkingStatus(parkingMap);
		}
	}
}
