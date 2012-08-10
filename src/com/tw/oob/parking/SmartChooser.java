package com.tw.oob.parking;

import java.util.List;

public class SmartChooser implements Chooser {
    public  ParkingLot chooseLot(List<ParkingLot> lots) {
        ParkingLot lot = null;
        int max = 0;
        for (ParkingLot parkingLot : lots) {
            if (parkingLot.getFreeAreaSize() > max) {
                max = parkingLot.getFreeAreaSize();
                lot = parkingLot;
            }
        }
        return lot;
    }
}
