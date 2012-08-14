package com.tw.oob.parking;

import com.tw.oob.parking.chooser.SmartChooser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {
    @Test
    public void test_should_park_car_to_the_parking_lot_which_has_larger_free_areas() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLots.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        ParkingBoy smartParkingBoy = new ParkingBoy(new SmartChooser());
        smartParkingBoy.setParkingLots(parkingLots);

        Car car = new Car(1);
        Ticket ticket = smartParkingBoy.park(car);

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
        ParkingBoy smartParkingBoy = new ParkingBoy(new SmartChooser());
        smartParkingBoy.setParkingLots(parkingLots);
        ParkingBoy parkingBoy = smartParkingBoy;

        Car car = new Car(1);
        Ticket ticket = parkingBoy.park(car);

        Car sameCar = parkingBoy.unPark(ticket);

        assertThat(car, sameInstance(sameCar));
    }
}
