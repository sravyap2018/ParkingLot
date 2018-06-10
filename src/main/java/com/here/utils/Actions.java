package com.here.utils;

public enum Actions
{
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park"),
    STATUS("status"),
    LEAVE("leave"),
	SLOT_NOS_WITH_COLOR("slot_numbers_for_cars_with_color"),
	REG_NOS_WITH_COLOR("registration_numbers_for_cars_with_color"),
	SLOT_NO_FOR_REG_NUMBER("slot_number_for_registration_number");
 
    private String action;
 
    Actions(String action) {
        this.action = action;
    }
 
    public String getAction() {
        return action;
    }
}
