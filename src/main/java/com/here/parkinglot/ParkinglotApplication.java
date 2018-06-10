package com.here.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.here.utils.Constants;

/**
 * Class which is the main entry point of the automatic ticketing system
 * @author sravya
 *
 */
@SpringBootApplication
public class ParkinglotApplication {

	public static void main(String[] args) {
		ParkingTicketGenerator parkingTicketGenerator = new ParkingTicketGenerator();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = reader.readLine();
			String[] cmnds;
			while (!input.equalsIgnoreCase(Constants.EXIT)) {
				cmnds = input.split(Constants.CMD_SEPARATOR);
				/* Logic if the input is a text file */
				if (cmnds[0].trim().contains(Constants.FILE_FORMAT)) {
					File file = new File(cmnds[0]);
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						cmnds = line.split(Constants.CMD_SEPARATOR);
						parkingTicketGenerator.generateTicket(cmnds);
					}
					fileReader.close();
					break;
				} else { /* Logic if the input is entered through command line */
					parkingTicketGenerator.generateTicket(cmnds);
					input = reader.readLine();
				}

			}
		} catch (IOException e) {
			System.out.println("Received IOException while processing "+e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Received Exception while processing "+e.getMessage());
		}
	}
}
