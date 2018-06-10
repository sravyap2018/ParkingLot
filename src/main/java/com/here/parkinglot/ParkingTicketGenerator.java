package com.here.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.here.entities.Car;
import com.here.utils.Actions;

public class ParkingTicketGenerator {
	ParkingStatus parkingStatus = new ParkingStatus();
	List<Integer> emptySlots = new ArrayList<>();
	HashMap<Integer, Car> parkingMap = new HashMap<>();
	int noOfSlots = 0;

	public void generateTicket(String[] details) {
		String action = details[0];
		if (action.trim().equalsIgnoreCase(Actions.CREATE_PARKING_LOT.getAction())) {
			noOfSlots = Integer.parseInt(details[1]);
			for (int i = 1; i <= noOfSlots; i++) {
				parkingMap.put(i, null);
				emptySlots.add(i);
			}
			System.out.println("Created a parking lot with " + noOfSlots + " slots");
		} else if (action.trim().equalsIgnoreCase(Actions.PARK.getAction())) {
			if (!emptySlots.isEmpty()) {
				Car car = new Car();
				car.setRegistrationNumber(details[1]);
				car.setColor(details[2]);
				parkingMap.put(emptySlots.get(0), car);
				System.out.println("Allocated slot No: " + emptySlots.get(0));
				emptySlots.remove(emptySlots.get(0));
			} else {
				System.out.println("Sorry, parking lot is full");
			}
		} else if (action.trim().equalsIgnoreCase(Actions.LEAVE.getAction())) {
			parkingMap.put(Integer.parseInt(details[1]), null);
			System.out.println("Slot Number " + details[1] + " is free");
			emptySlots.add(Integer.parseInt(details[1]));
			if (emptySlots.size() > 1) {
				Collections.sort(emptySlots);
			}
		} else if (action.trim().equalsIgnoreCase(Actions.STATUS.getAction())) {
			parkingStatus.displayParkingStatus(parkingMap);
		}else if(action.trim().equalsIgnoreCase(Actions.REG_NOS_WITH_COLOR.getAction())) {
			parkingStatus.getRegNoWithCarColors(parkingMap, details[1]);
		}else if(action.trim().equalsIgnoreCase(Actions.SLOT_NO_FOR_REG_NUMBER.getAction())) {
			parkingStatus.getSlotsByRegNo(parkingMap, details[1]);
		}else if(action.trim().equalsIgnoreCase(Actions.SLOT_NOS_WITH_COLOR.getAction())) {
			parkingStatus.getSlotsWithCarColors(parkingMap, details[1]);
		}
	}
}
