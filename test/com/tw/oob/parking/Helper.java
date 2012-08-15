package com.tw.oob.parking;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<ParkingService> createParkingLots(int lotsSize, int eachAreaSize) {
        List<ParkingService> parkingLots = new ArrayList<ParkingService>();
        for (int i = 0; i < lotsSize; i++) {
            parkingLots.add(new ParkingLot(eachAreaSize));
        }
        return parkingLots;
    }
}
