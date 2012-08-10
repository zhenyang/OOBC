package com.tw.oob.parking;

import java.util.List;

public class SmartestChooser implements Chooser{
    public  ParkingLot chooseLot(List<ParkingLot> lots) {
        ParkingLot lot = null;
        double max = 0;
        for (ParkingLot parkingLot : lots) {
            if (parkingLot.getFreeAreaRatio() > max) {
                max = parkingLot.getFreeAreaRatio();
                lot = parkingLot;
            }
        }
        return lot;
    }
}
