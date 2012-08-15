package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingService;

import java.util.List;

public class SillyChooser implements Chooser{
    public ParkingService choose(List<ParkingService> lots) {
        ParkingService lot = null;
        for (ParkingService parkingLot : lots) {
            if (parkingLot.getFreeAreaSize() > 0) {
                lot = parkingLot;
                break;
            }
        }
        return lot;
    }
}
