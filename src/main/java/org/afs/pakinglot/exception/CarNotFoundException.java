package org.afs.pakinglot.exception;

public class CarNotFoundException extends Exception {

    public static final String CAR_DOES_NOT_EXIST = "Car does not exist.";

    public CarNotFoundException() {
        super(CAR_DOES_NOT_EXIST);
    }
}
