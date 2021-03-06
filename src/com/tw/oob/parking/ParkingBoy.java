package com.tw.oob.parking;

import com.tw.oob.parking.chooser.Chooser;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements ParkingService {
    private List<ParkingService> parkingServices;
    private Chooser chooser;
    private String name;

    public ParkingBoy(Chooser chooser) {
        this(chooser, "defaultParkingBoy");
    }

    public ParkingBoy(Chooser chooser, String name) {
        this.chooser = chooser;
        this.name = name;
        this.parkingServices = new ArrayList<ParkingService>();
    }


    public void addParkingServices(List<ParkingService> parkingLots) {
        this.parkingServices.addAll(parkingLots);
    }

    public Ticket park(Car car) {
        ParkingService lot = chooser.choose(parkingServices);
        if (lot != null) {
            return lot.park(car);
        }
        return null;
    }

    public Car unPark(Ticket ticket) {
        for (ParkingService parkingLot : parkingServices) {
            Car car = parkingLot.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public int getFreeAreaSize() {
        int freeAreaSize = 0;
        for (ParkingService parkingLot : parkingServices) {
            freeAreaSize += parkingLot.getFreeAreaSize();
        }
        return freeAreaSize;
    }

    public double getFreeAreaRatio() {
        return (double) getFreeAreaSize() / getAreaSize();
    }

    public int getAreaSize() {
        int totalAreaSize = 0;
        for (ParkingService parkingLot : parkingServices) {
            totalAreaSize += parkingLot.getAreaSize();
        }
        return totalAreaSize;
    }

    public void addParkingService(ParkingService service) {
        parkingServices.add(service);
    }

    public String report(String indent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(indent).append(name).append(" ").append(getAreaSize() - getFreeAreaSize())
                .append("/").append(getAreaSize()).append("\n");
        for (ParkingService parkingService : parkingServices) {
            stringBuilder.append(parkingService.report(indent + "  "));
        }
        return stringBuilder.toString();
    }
}
