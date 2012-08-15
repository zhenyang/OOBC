package com.tw.oob.parking;

import com.tw.oob.parking.chooser.SillyChooser;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingManagerTest {
    @Test
    public void test_should_manage_parking_lots() throws Exception {
        ParkingBoy parkingManager = new ParkingBoy(new SillyChooser());
        parkingManager.addParkingServices(Helper.createParkingLots(2, 1));

        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        assertThat(ticket.getCarId(), is(car.getId()));
    }

    @Test
    public void test_should_manage_a_parking_boy_to_park() throws Exception {
        ParkingBoy parkingManager = new ParkingBoy(new SillyChooser());

        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.addParkingServices(Helper.createParkingLots(2, 2));
        parkingManager.addParkingService(parkingBoy);

        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        Car sameCar = parkingBoy.unPark(ticket);
        assertThat(car, is(sameCar));
    }

    @Test
    public void test_should_manage_multiple_parking_boys_to_park() throws Exception {
        ParkingBoy parkingManager = new ParkingBoy(new SillyChooser());

        ParkingBoy parkingBoy = new ParkingBoy(new SillyChooser());
        parkingBoy.addParkingServices(Helper.createParkingLots(2, 0));
        parkingManager.addParkingService(parkingBoy);

        ParkingBoy parkingBoy1 = new ParkingBoy(new SillyChooser());
        parkingBoy1.addParkingServices(Helper.createParkingLots(2, 2));
        parkingManager.addParkingService(parkingBoy1);


        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        Car sameCar = parkingBoy1.unPark(ticket);
        assertThat(car, is(sameCar));
    }

    @Test
    public void test_should_manage_parking_lots_to_un_park_car() throws Exception {
        ParkingBoy parkingManager = new ParkingBoy(new SillyChooser());
        parkingManager.addParkingServices(Helper.createParkingLots(2, 1));

        Car car = new Car(1);
        Ticket ticket = parkingManager.park(car);

        Car sameCar = parkingManager.unPark(ticket);

        assertThat(car, is(sameCar));
    }

    @Test
    public void test_should_manage_parking_boys_to_un_park_car() throws Exception {
        ParkingBoy parkingManager = new ParkingBoy(new SillyChooser());
        parkingManager.addParkingServices(Helper.createParkingLots(2, 0));

        ParkingBoy boy1 = new ParkingBoy(new SillyChooser());

        ParkingBoy boy2 = new ParkingBoy(new SillyChooser());
        boy2.addParkingServices(Helper.createParkingLots(2, 2));
        parkingManager.addParkingService(boy1);
        parkingManager.addParkingService(boy2);
        Car car = new Car(1);
        Ticket ticket = boy2.park(car);

        Car sameCar = parkingManager.unPark(ticket);

        assertThat(car, is(sameCar));
    }


}
