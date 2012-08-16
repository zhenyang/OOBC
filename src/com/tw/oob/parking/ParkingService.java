package com.tw.oob.parking;

public interface ParkingService {
    Ticket park(Car car);

    Car unPark(Ticket ticket);

    int getFreeAreaSize();

    double getFreeAreaRatio();

    int getAreaSize();

    String report(String indent);
}
