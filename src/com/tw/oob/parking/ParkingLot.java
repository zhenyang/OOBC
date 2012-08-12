package com.tw.oob.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> areas;
    private int areaSize;

    public ParkingLot(int areaSize) {
        this.areaSize = areaSize;
        this.areas = new ArrayList<Car>(areaSize);
    }

    public Ticket park(Car car) {
        if (areas.size() == areaSize) {
            return null;
        }
        areas.add(car);
        return new Ticket(car.getId());
    }

    public Car unPark(Ticket ticket) {
        int carId = ticket.getCarId();
        for (Car car : areas) {
            if (car.getId() == carId) {
                areas.remove(car);
                return car;
            }
        }
        return null;
    }

    public int getFreeAreaSize() {
        return areaSize - areas.size();
    }

    public double getFreeAreaRatio() {
        return (double)getFreeAreaSize() / areaSize;
    }
}
