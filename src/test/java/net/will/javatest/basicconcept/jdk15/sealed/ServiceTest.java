package net.will.javatest.basicconcept.jdk15.sealed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {
    @Test
    public void testGetMaxDistanceBetweenServicesInKilometers() {
        Car car = new Car(4, "ccc-aaa-rrr");
        assertEquals(100_000, car.getMaxDistanceBetweenServicesInKilometers());

        Truck truck = new Truck(50, "ttt-rrr-uuu-ccc-kkk");
        assertEquals(100_000, truck.getMaxDistanceBetweenServicesInKilometers());
    }

    @Test
    public void testGetMaxServiceIntervalInMonths() {
        Car car = new Car(4, "ccc-aaa-rrr");
        assertEquals(12, car.getMaxServiceIntervalInMonths());

        Truck truck = new Truck(50, "ttt-rrr-uuu-ccc-kkk");
        assertEquals(18, truck.getMaxServiceIntervalInMonths());
    }
}
