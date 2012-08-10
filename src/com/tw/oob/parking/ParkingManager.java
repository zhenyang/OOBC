package com.tw.oob.parking;

import java.util.List;

public class ParkingManager
{
    private List<ParkingLot> parkingLots;
    private Chooser chooser;

    protected ParkingManager(){}

    public ParkingManager(Chooser chooser) {
        this.chooser = chooser;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot lot = chooseParkingLot(parkingLots);
        if (lot != null) {
            return lot.park(car);
        }
        return null;
    }

    protected ParkingLot chooseParkingLot(List<ParkingLot> lots) {
        return chooser.chooseLot(lots);
    }

    public Car unPark(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
