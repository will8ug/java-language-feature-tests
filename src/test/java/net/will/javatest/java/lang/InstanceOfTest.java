package net.will.javatest.java.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstanceOfTest {

    @Test
    public void testInstanceOf_NotNull() {
        String s = "s";
        assertTrue(s instanceof String);
    }
    
    @Test
    public void testInstanceOf_Null() {
        String s = null;
        assertFalse(s instanceof String);
    }

}
