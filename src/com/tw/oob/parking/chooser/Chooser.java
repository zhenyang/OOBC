package com.tw.oob.parking.chooser;

import com.tw.oob.parking.ParkingService;

import java.util.List;

public interface Chooser {
    ParkingService choose(List<ParkingService> lots);
}
