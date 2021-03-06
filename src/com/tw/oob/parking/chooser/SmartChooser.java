package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingService;

import java.util.List;

public class SmartChooser implements Chooser {
    public ParkingService choose(List<ParkingService> lots) {
        ParkingService lot = null;
        int max = 0;
        for (ParkingService parkingLot : lots) {
            if (parkingLot.getFreeAreaSize() > max) {
                max = parkingLot.getFreeAreaSize();
                lot = parkingLot;
            }
        }
        return lot;
    }
}
