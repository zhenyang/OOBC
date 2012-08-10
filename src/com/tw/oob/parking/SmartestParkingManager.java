package com.tw.oob.parking;

import java.util.List;

public class SmartestParkingManager extends ParkingManager{
    public SmartestParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    protected ParkingLot chooseParkingLot() {
        ParkingLot lot = null;
        double max = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getFreeAreaRatio() > max) {
                max = parkingLot.getFreeAreaRatio();
                lot = parkingLot;
            }
        }
        return lot;
    }
    }
