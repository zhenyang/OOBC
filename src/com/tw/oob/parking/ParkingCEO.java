package com.tw.oob.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCEO {

    private List<ParkingBoy> parkingBoys;

    public ParkingCEO() {
        parkingBoys = new ArrayList<ParkingBoy>();
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoys.add(parkingBoy);
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingBoy parkingBoy : parkingBoys) {
             ticket = parkingBoy.park(car);
        }
        return ticket;
    }

    public Car unPark(Ticket ticket) {
        Car car = null;
        for (ParkingBoy parkingBoy : parkingBoys) {
            car = parkingBoy.unPark(ticket);
            if(car != null){
                return car;
            }
        }
        return null;
    }
}
