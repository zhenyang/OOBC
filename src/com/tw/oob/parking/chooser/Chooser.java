package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingLot;

import java.util.List;

public interface Chooser {
    ParkingLot choose(List<ParkingLot> lots);
}
