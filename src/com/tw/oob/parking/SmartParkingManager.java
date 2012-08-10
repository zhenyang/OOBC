package com.tw.oob.parking;

import java.util.List;

public class SmartParkingManager extends ParkingManager {
    public SmartParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    protected ParkingLot chooseParkingLot() {
        ParkingLot lot = null;
        int max = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getFreeAreaSize() > max) {
                max = parkingLot.getFreeAreaSize();
                lot = parkingLot;
            }
        }
        return lot;
    }
}
