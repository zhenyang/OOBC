package com.tw.oob.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {
    @Test
    public void test_should_park_car_when_parking_lot_is_empty() {
        ParkingLot parkingLot = new ParkingLot(5);

        Car car = new Car(1);
        Ticket ticket = parkingLot.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_not_park_car_when_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.park(new Car(1));

        Ticket ticket1 = parkingLot.park(new Car(2));

        assertNull(ticket1);
    }

    @Test
    public void test_should_park_car_when_parking_lot_is_not_full() {
        ParkingLot parkingLot = new ParkingLot(3);

        parkingLot.park(new Car(1));

        Car car = new Car(2);
        Ticket ticket = parkingLot.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_unPark_car_when_ticket_is_valid() {
        ParkingLot parkingLot = new ParkingLot(3);

        Car car = new Car(1);
        Ticket ticket = parkingLot.park(car);

        Car sameCar = parkingLot.unPark(ticket);

        assertThat(car, is(sameCar));
    }

    @Test
    public void test_should_not_unPark_car_when_ticket_is_invalid() {
        ParkingLot parkingLot = new ParkingLot(3);

        Car car = new Car(1);
        Ticket ticket = parkingLot.park(car);

        Car upParkCar = parkingLot.unPark(new Ticket(10));

        assertNull(upParkCar);
    }



}
