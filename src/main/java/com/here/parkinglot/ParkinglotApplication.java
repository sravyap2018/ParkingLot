package com.here.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkinglotApplication {

	public static void main(String[] args) {
		List<Integer> emptySlots = new ArrayList<>();
		HashMap<Integer, Car> parkingMap = new HashMap<>();
		ParkingTicketGenerator parkingTicketGenerator = new ParkingTicketGenerator();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input=reader.readLine();
			String[] cmnds;
			int noOfSlots = 0;
			while(!input.equals("Exit")) {
				
			/*	if(cmnds[0].trim().equalsIgnoreCase("create_parking_lot")) {
					noOfSlots=Integer.parseInt(cmnds[1]);
					for(int i=1;i<=noOfSlots;i++) {
						parkingMap.put(i, null);
						emptySlots.add(i);					}
				}
				else if(cmnds[0].trim().equalsIgnoreCase("park")) {
					if(!emptySlots.isEmpty()) {
						Car car = new Car();
						car.setRegistrationNumber(cmnds[1]);
						car.setColor(cmnds[2]);
						parkingMap.put(emptySlots.get(0), car);
						emptySlots.remove(emptySlots.get(0));
					}
					else {
						System.out.println("Sorry, parking lot is full");
					}
				}
				else if(cmnds[0].trim().equalsIgnoreCase("leave")) {
					parkingMap.put(Integer.parseInt(cmnds[1]),null);
					emptySlots.add(Integer.parseInt(cmnds[1]));
					if(emptySlots.size()>1) {
						Collections.sort(emptySlots);
					}
				}
				else if(cmnds[0].trim().equalsIgnoreCase("status")) {
					System.out.println("Slot No.\tRegistration Number\tColor");
					for (Map.Entry<Integer, Car> pair : parkingMap.entrySet()) {
						if(pair.getValue()!=null) {
							System.out.println(pair.getKey()+"\t"+pair.getValue().getRegistrationNumber()+"\t"+pair.getValue().getColor());
						}
					}
				}*/
				cmnds = input.split(" ");
				if(cmnds[0].trim().contains(".txt")) {
					//Similar logic like above
					File file = new File(cmnds[0]);
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						cmnds = line.split(" ");
						parkingTicketGenerator.generateTicket(cmnds);
					}
					fileReader.close();
					break;
				}else {
					parkingTicketGenerator.generateTicket(cmnds);
					input=reader.readLine();
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
