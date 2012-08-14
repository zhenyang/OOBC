package com.tw.oob.parking;

import com.tw.oob.parking.chooser.SillyChooser;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingCEOTest {
    @Test
    public void test_should_manage_a_parking_boy() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.setParkingLots(Helper.createParkingLots(2, 2));

        ParkingCEO parkingCEO = new ParkingCEO();
        parkingCEO.addParkingBoy(parkingBoy);

        Car car = new Car(1);

        Ticket ticket = parkingCEO.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_manage_a_parking_manager() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.setParkingLots(Helper.createParkingLots(2, 2));

        ParkingManager parkingManager = new ParkingManager(new SillyChooser());
        parkingManager.setParkingLots(Helper.createParkingLots(1, 2));

        ParkingCEO parkingCEO = new ParkingCEO();
        parkingCEO.addParkingBoy(parkingManager);
        parkingCEO.addParkingBoy(parkingBoy);

        Car car = new Car(1);

        Ticket ticket = parkingCEO.park(car);

        Car sameCar = parkingManager.unPark(ticket);

        assertThat(car, is(sameCar));
    }
    @Test
    public void test_should_un_park_from_parking_boy_when_manager_is_next_to_boy() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.setParkingLots(Helper.createParkingLots(2, 2));

        ParkingManager parkingManager = new ParkingManager(new SillyChooser());
        parkingManager.setParkingLots(Helper.createParkingLots(1, 2));

        ParkingCEO parkingCEO = new ParkingCEO();
        parkingCEO.addParkingBoy(parkingBoy);
        parkingCEO.addParkingBoy(parkingManager);

        Car car = new Car(1);

        Ticket ticket = parkingCEO.park(car);

        Car sameCar = parkingCEO.unPark(ticket);

        assertThat(car, is(sameCar));
    }
}
