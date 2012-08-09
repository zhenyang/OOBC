package com.tw.oob.parking;

import java.util.List;

public class SmartParkingManager extends ParkingManager{
    public SmartParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        ParkingLot lot = getMostFreeAreasLot();
        return lot.park(car);
    }

    private ParkingLot getMostFreeAreasLot() {
        ParkingLot lot = new ParkingLot(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getFreeAreaSize() > lot.getFreeAreaSize()) {
                lot = parkingLot;
            }
        }
        return lot;
    }
}
