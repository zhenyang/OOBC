package com.tw.oob.parking;

import com.tw.oob.parking.chooser.Chooser;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{

    private List<ParkingBoy> parkingBoys;

    public ParkingManager(Chooser chooser) {
        super(chooser);
        parkingBoys = new ArrayList<ParkingBoy>();
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    @Override
    public Car unPark(Ticket ticket) {
        Car car = super.unPark(ticket);
        if(car == null){
           car = getCarFromBoys(ticket);

        }
        return car;
    }

    private Car getCarFromBoys(Ticket ticket) {
        Car car = null;
        for (ParkingBoy parkingBoy : parkingBoys) {
            car = parkingBoy.unPark(ticket);
            if(car != null)
                return car;
        }

        return car;

    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = super.park(car);
        if (ticket != null) {
            return ticket;
        }
        for (ParkingBoy parkingBoy : parkingBoys) {
            ticket = parkingBoy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return ticket;
    }
}
