package com.tw.oob.parking;

import com.tw.oob.parking.chooser.SmartestChooser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class SmartestParkingBoyTest {
    @Test
    public void test_should_park_car_to_the_parking_lot_which_has_larger_free_ratio() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new Car(1));
        parkingLots.add(parkingLot);
        ParkingLot parkingLot1 = new ParkingLot(5);
        parkingLot1.park(new Car(2));
        parkingLots.add(parkingLot1);
        ParkingBoy smartestParkingBoy = new ParkingBoy(new SmartestChooser());
        smartestParkingBoy.setParkingLots(parkingLots);

        Car car = new Car(3);
        Ticket ticket = smartestParkingBoy.park(car);

        Car sameCar = parkingLot1.unPark(ticket);

        assertThat(car, sameInstance(sameCar));
    }
}
