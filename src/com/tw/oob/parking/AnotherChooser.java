package com.tw.oob.parking;

import com.tw.oob.parking.chooser.Chooser;

import java.util.List;

public class AnotherChooser implements Chooser {
    public ParkingLot choose(List<ParkingLot> lots) {
        ParkingLot lot = null;
        double max = 0;
        for (ParkingLot parkingLot : lots) {
            double occupiedAreaRatio = 1 - parkingLot.getFreeAreaRatio();
            if (occupiedAreaRatio > max) {
                max = occupiedAreaRatio;
                lot = parkingLot;
            }
        }
        return lot;
    }
}
