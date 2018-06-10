package com.here.parkinglot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.here.utils.Actions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingTicketGeneratorTests {
	
	ParkingTicketGenerator generator = new ParkingTicketGenerator();

	@Test
	public void test_noOfSlots() {
		String[] cmnds = new String[2];
		cmnds[0]=Actions.CREATE_PARKING_LOT.getAction();
		cmnds[1]=6+"";
		generator.generateTicket(cmnds);
		assertEquals(6, generator.noOfSlots);
	}

	@Test(expected=Exception.class)
	public void test_nan() {
		String[] cmnds = new String[2];
		cmnds[0]=Actions.CREATE_PARKING_LOT.getAction();
		cmnds[1]="a";
		generator.generateTicket(cmnds);
	}
}
