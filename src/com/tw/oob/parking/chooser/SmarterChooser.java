package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingService;

import java.util.List;

public class SmarterChooser implements Chooser {
    public ParkingService choose(List<ParkingService> lots) {
        ParkingService lot = null;
        double min = 1;
        for (ParkingService parkingLot : lots) {
            if (parkingLot.getFreeAreaRatio() < min) {
                min = parkingLot.getFreeAreaRatio();
                lot = parkingLot;
            }
        }
        return lot;
    }
}