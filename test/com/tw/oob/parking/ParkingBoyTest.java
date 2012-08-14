package com.tw.oob.parking;

import com.tw.oob.parking.chooser.SillyChooser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    @Test
    public void test_should_park_car_when_two_parking_lots_are_empty() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.setParkingLots(createParkingLots(2, 1));

        Car car = new Car(1);
        Ticket ticket = parkingBoy.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_park_car_when_first_parking_lot_is_full() throws Exception {
        ParkingBoy parkingBoy1 = new ParkingBoy(new SillyChooser());
        parkingBoy1.setParkingLots(createParkingLots(2, 1));
        ParkingBoy parkingBoy = parkingBoy1;

        parkingBoy.park(new Car(1));

        Car car = new Car(2);
        Ticket ticket = parkingBoy.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_not_park_car_when_all_parking_lots_are_full() throws Exception {
        ParkingBoy parkingBoy1 = new ParkingBoy(new SillyChooser());
        parkingBoy1.setParkingLots(createParkingLots(2, 1));
        ParkingBoy parkingBoy = parkingBoy1;

        parkingBoy.park(new Car(1));
        parkingBoy.park(new Car(2));

        Car car = new Car(3);
        Ticket ticket = parkingBoy.park(car);

        assertThat(ticket, nullValue());
    }

    @Test
    public void test_should_unpark_car_when_ticket_is_valid() throws Exception {
        ParkingBoy parkingBoy1 = new ParkingBoy(new SillyChooser());
        parkingBoy1.setParkingLots(createParkingLots(2, 1));
        ParkingBoy parkingBoy = parkingBoy1;

        Car car = new Car(1);
        Ticket ticket = parkingBoy.park(car);

        Car sameCar = parkingBoy.unPark(ticket);

        assertThat(car, sameInstance(sameCar));
    }

    @Test
    public void test_should_park_car_to_first_not_full_parking_lot() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLots.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        ParkingBoy parkingBoy1 = new ParkingBoy(new SillyChooser());
        parkingBoy1.setParkingLots(parkingLots);
        ParkingBoy parkingBoy = parkingBoy1;

        Car car = new Car(1);
        Ticket ticket = parkingBoy.park(car);

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
