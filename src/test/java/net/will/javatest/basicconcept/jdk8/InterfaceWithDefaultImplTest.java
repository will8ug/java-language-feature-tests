package net.will.javatest.basicconcept.jdk8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceWithDefaultImplTest implements InterfaceWithDefaultImpl {
    @Override
    public void firstMethod() {
        System.out.println("This is a real implementation in the sub-class.");
    }
    
    @Test
    public void testDefaultImplementationOfInterface() {
        InterfaceWithDefaultImplTest obj = new InterfaceWithDefaultImplTest();
        obj.firstMethod();
        System.out.println(obj.secondMethod());
        
        assertNotNull(obj.secondMethod());
    }
    
}
