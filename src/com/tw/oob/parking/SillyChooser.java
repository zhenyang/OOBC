package com.tw.oob.parking;

import java.util.List;

public class SillyChooser implements Chooser {
    public ParkingLot chooseLot(List<ParkingLot> lots) {
        ParkingLot lot = null;
        for (ParkingLot parkingLot : lots) {
            if (parkingLot.getFreeAreaSize() > 0) {
                lot = parkingLot;
                break;
            }
        }
        return lot;
    }
}
