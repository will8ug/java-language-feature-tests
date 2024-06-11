package net.will.javatest.basicconcept.jdk15.sealed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    @Test
    public void testSealedClasses_IfElsePatternMatching_Car() {
        Car car = new Car(4, "ccc-aaa-rrr");

        assertEquals(4, judgeItViaIfElse(car));
    }

    @Test
    public void testSealedClasses_IfElsePatternMatching_Truck() {
        Truck truck = new Truck(50, "ttt-rrr-uuu-ccc-kkk");

        assertEquals(50, judgeItViaIfElse(truck));
    }

    private int judgeItViaIfElse(Vehicle vehicle) {
        if (vehicle instanceof Car car) {
            return car.getNumberOfSeats();
        } else if (vehicle instanceof Truck truck) {
            return truck.getLoadCapacity();
        } else {
            throw new RuntimeException("Unknown instance of Vehicle");
        }
    }
}
