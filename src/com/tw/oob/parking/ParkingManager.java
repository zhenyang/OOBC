package com.tw.oob.parking;

import com.tw.oob.parking.chooser.Chooser;

import java.util.List;

public class ParkingManager
{
    protected List<ParkingLot> parkingLots;
    protected Chooser chooser;

    public ParkingManager(Chooser chooser) {
        this.chooser = chooser;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot lot = chooser.choose(parkingLots);
        if (lot != null) {
            return lot.park(car);
        }
        return null;
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
