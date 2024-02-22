package net.will.javatest.basicconcept.jdk7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwitchStringsTest {
    @Test
    public void testGetShortNameOfWeekDay() {
        SwitchStrings obj = new SwitchStrings();
        assertTrue( "Mon".equals(obj.getShortNameOfWeekDay("Monday")) );
        assertTrue( "Sat".equals(obj.getShortNameOfWeekDay("Saturday")) );
        
        assertTrue( "".equals(obj.getShortNameOfWeekDay("typo")) );
    }
}
