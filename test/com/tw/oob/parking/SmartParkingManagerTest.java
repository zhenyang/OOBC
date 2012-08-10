package com.tw.oob.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class SmartParkingManagerTest {
    @Test
    public void test_should_park_car_to_the_parking_lot_which_has_larger_free_areas() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLots.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        ParkingManager smartParkingManager = new ParkingManager(new SmartChooser());
        smartParkingManager.setParkingLots(parkingLots);

        Car car = new Car(1);
        Ticket ticket = smartParkingManager.park(car);

        Car sameCar = parkingLot1.unPark(ticket);

        assertThat(car, sameInstance(sameCar));
    }

    @Test
    public void test_should_unpark_car_when_ticket_is_valid() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLots.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        ParkingManager smartParkingManager = new ParkingManager(new SmartChooser());
        smartParkingManager.setParkingLots(parkingLots);
        ParkingManager parkingManager = smartParkingManager;

        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        Car sameCar = parkingManager.unPark(ticket);

        assertThat(car, sameInstance(sameCar));
    }
}
