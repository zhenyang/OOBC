package com.tw.oob.parking;

import com.tw.oob.parking.chooser.Chooser;

import java.util.List;

public class ParkingBoy
{
    private List<ParkingLot> parkingLots;
    private Chooser chooser;

    public ParkingBoy(Chooser chooser) {
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
        if(parkingLots == null){
            return  null;
        }
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
