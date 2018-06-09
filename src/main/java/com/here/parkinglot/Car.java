package com.here.parkinglot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Car {

	//@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String registrationNumber;
	
	//@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String color;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
