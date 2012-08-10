package com.tw.oob.parking;

import java.util.List;

public class ParkingManager
{
    protected List<ParkingLot> parkingLots;

    public ParkingManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot lot = chooseParkingLot();
        if (lot != null) {
            return lot.park(car);
        }
        return null;
    }

    protected ParkingLot chooseParkingLot() {
        ParkingLot lot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getFreeAreaSize() > 0) {
                lot = parkingLot;
                break;
            }
        }
        return lot;
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
