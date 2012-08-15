package com.tw.oob.parking;

import com.tw.oob.parking.chooser.Chooser;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements ParkingService {
    private Chooser chooser;
    private List<ParkingService> parkingLots;

    public ParkingManager(Chooser chooser) {
        this.chooser = chooser;
        parkingLots = new ArrayList<ParkingService>();
    }

    public void setParkingLots(List<ParkingService> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public Ticket park(Car car) {
        ParkingService lot = chooser.choose(parkingLots);
        if (lot != null) {
            return lot.park(car);
        }
        return null;
    }

    public Car unPark(Ticket ticket) {
        return null;
    }

    public int getFreeAreaSize() {
        return 0;
    }

    public double getFreeAreaRatio() {
        return 0;
    }

    public int getAreaSize() {
        return 0;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingLots.add(parkingBoy);
    }
}
