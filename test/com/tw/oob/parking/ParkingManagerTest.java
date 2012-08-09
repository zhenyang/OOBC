package com.tw.oob.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingManagerTest {
    @Test
    public void test_should_park_car_when_two_parking_lots_are_empty() throws Exception {
        ParkingManager parkingManager = new ParkingManager(createParkingLots(2, 1));

        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_park_car_when_first_parking_lot_is_full() throws Exception {
        ParkingManager parkingManager = new ParkingManager(createParkingLots(2, 1));

        parkingManager.park(new Car(1));

        Car car = new Car(2);
        Ticket ticket = parkingManager.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_not_park_car_when_all_parking_lots_are_full() throws Exception {
        ParkingManager parkingManager = new ParkingManager(createParkingLots(2, 1));

        parkingManager.park(new Car(1));
        parkingManager.park(new Car(2));

        Car car = new Car(3);
        Ticket ticket = parkingManager.park(car);

        assertThat(ticket, nullValue());
    }

    @Test
    public void test_should_unpark_car_when_ticket_is_valid() throws Exception {
        ParkingManager parkingManager = new ParkingManager(createParkingLots(2, 1));

        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        Car sameCar = parkingManager.unPark(ticket);

        assertThat(car, sameInstance(sameCar));
    }

    @Test
    public void test_should_park_car_to_first_not_full_parking_lot() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLots.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        ParkingManager parkingManager = new ParkingManager(parkingLots);

        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        Car sameCar = parkingLot1.unPark(ticket);

        assertThat(car, sameInstance(sameCar));
    }

    private List<ParkingLot> createParkingLots(int lotsSize, int eachAreaSize) {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        for (int i = 0; i < lotsSize; i++) {
            parkingLots.add(new ParkingLot(eachAreaSize));
        }
        return parkingLots;
    }
}
