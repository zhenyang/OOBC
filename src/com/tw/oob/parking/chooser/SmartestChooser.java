package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingLot;

import java.util.List;

public class SmartestChooser implements Chooser{
    public ParkingLot choose(List<ParkingLot> lots) {
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
