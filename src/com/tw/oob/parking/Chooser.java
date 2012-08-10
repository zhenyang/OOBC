package com.tw.oob.parking;

import java.util.List;

public interface Chooser {
    ParkingLot chooseLot(List<ParkingLot> lots);
}
