package net.will.javatest.basicconcept.jdk17.sealed;

import net.will.javatest.basicconcept.jdk15.sealed.Car;
import net.will.javatest.basicconcept.jdk15.sealed.Truck;
import net.will.javatest.basicconcept.jdk15.sealed.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    @Test
    public void testSealedClasses_PatternMatching_SwitchCase_Car() {
        Car car = new Car(4, "ccc-aaa-rrr");

        assertEquals(4, judgeItViaSwitchCase(car));
    }

    @Test
    public void testSealedClasses_PatternMatching_SwitchCase_Truck() {
        Truck truck = new Truck(50, "ttt-rrr-uuu-ccc-kkk");

        assertEquals(50, judgeItViaSwitchCase(truck));
    }

    private int judgeItViaSwitchCase(Vehicle vehicle) {
        switch (vehicle) {
            case Car car -> {
                return car.getNumberOfSeats();
            }
            case Truck truck -> {
                return truck.getLoadCapacity();
            }
        }
    }
}
