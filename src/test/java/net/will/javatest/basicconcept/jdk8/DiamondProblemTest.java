package net.will.javatest.basicconcept.jdk8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiamondProblemTest {
    @Test
    public void testDiamondProblem() {
        MyClass obj = new MyClass();
        obj.log("something");
        
        System.out.println(obj.toString());
        assertNotNull(obj.toString());
    }
}
