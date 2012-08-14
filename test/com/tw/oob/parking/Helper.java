package com.tw.oob.parking;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<ParkingLot> createParkingLots(int lotsSize, int eachAreaSize) {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        for (int i = 0; i < lotsSize; i++) {
            parkingLots.add(new ParkingLot(eachAreaSize));
        }
        return parkingLots;
    }
}
