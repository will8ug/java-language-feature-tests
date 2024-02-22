package net.will.javatest.basicconcept.jdk9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrivateMethodsInInterfaceTest implements PrivateMethodsInInterface {
    public void logInfo(String uuid) {
        System.out.println(uuid);
    }
    
    @Test
    public void testCreateUuid() {
        String uuid = createUuid();
        assertNotNull(uuid);
    }
}
