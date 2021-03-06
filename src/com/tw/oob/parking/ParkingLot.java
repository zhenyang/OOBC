package com.tw.oob.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements ParkingService {
    private List<Car> areas;
    private int areaSize;
    private String name;

    public ParkingLot(int areaSize) {
        this(areaSize, "default ParkingLot");
    }

    public ParkingLot(int areaSize, String name) {
        this.areaSize = areaSize;
        this.name = name;
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

    public int getAreaSize() {
        return areaSize;
    }

    public int getFreeAreaSize() {
        return areaSize - areas.size();
    }

    public double getFreeAreaRatio() {
        return (double) getFreeAreaSize() / areaSize;
    }

    public String report(String indent) {
        return new StringBuilder().append(indent).append(name).append(" ").append(areas.size())
                .append("/").append(areaSize).append("\n").toString();
    }

}
