package com.tw.oob.parking;

import com.tw.oob.parking.chooser.SillyChooser;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingCEOTest {
    private ParkingBoy parkingCEO;

    @Test
    public void test_should_manage_a_parking_boy() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.addParkingServices(Helper.createParkingLots(2, 2));

        ParkingBoy parkingCEO = new ParkingBoy(new SillyChooser());
        parkingCEO.addParkingService(parkingBoy);

        Car car = new Car(1);

        Ticket ticket = parkingCEO.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_manage_a_parking_manager() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.addParkingServices(Helper.createParkingLots(2, 2));

        ParkingBoy parkingManager = new ParkingBoy(new SillyChooser());
        parkingManager.addParkingServices(Helper.createParkingLots(1, 2));

        ParkingBoy parkingCEO = new ParkingBoy(new SillyChooser());
        parkingCEO.addParkingService(parkingManager);
        parkingCEO.addParkingService(parkingBoy);

        Car car = new Car(1);

        Ticket ticket = parkingCEO.park(car);

        Car sameCar = parkingManager.unPark(ticket);

        assertThat(car, is(sameCar));
    }
    @Test
    public void test_should_un_park_from_parking_boy_when_manager_is_next_to_boy() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.addParkingServices(Helper.createParkingLots(2, 2));

        ParkingBoy parkingManager = new ParkingBoy(new SillyChooser());
        parkingManager.addParkingServices(Helper.createParkingLots(1, 2));

        ParkingBoy parkingCEO = new ParkingBoy(new SillyChooser());
        parkingCEO.addParkingService(parkingBoy);
        parkingCEO.addParkingService(parkingManager);

        Car car = new Car(1);

        Ticket ticket = parkingCEO.park(car);

        Car sameCar = parkingCEO.unPark(ticket);

        assertThat(car, is(sameCar));
    }
}
