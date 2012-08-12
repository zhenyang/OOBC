package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingLot;

import java.util.List;

public class SillyChooser implements Chooser{
    public ParkingLot choose(List<ParkingLot> lots) {
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
