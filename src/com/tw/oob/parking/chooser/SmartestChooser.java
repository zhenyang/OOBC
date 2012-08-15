package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingService;

import java.util.List;

public class SmartestChooser implements Chooser{
    public ParkingService choose(List<ParkingService> lots) {
        ParkingService lot = null;
        double max = 0;
        for (ParkingService parkingLot : lots) {
            if (parkingLot.getFreeAreaRatio() > max) {
                max = parkingLot.getFreeAreaRatio();
                lot = parkingLot;
            }
        }
        return lot;
    }
}
