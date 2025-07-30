package net.will.javatest.java.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BigDecimalTest {
    @Test
    public void testUnexpectedDecimalNumber() {
        BigDecimal decimalUsingDoubleArgument = new BigDecimal(0.1);
        BigDecimal decimalusingStringArgument = new BigDecimal("0.1");

        System.out.println(decimalUsingDoubleArgument);
        System.out.println(decimalusingStringArgument);
        assertNotEquals(decimalUsingDoubleArgument, decimalusingStringArgument);
    }

    @Test
    public void shouldUseTheConstructorWithStringArgument() {
        BigDecimal first = new BigDecimal(Double.toString(0.1));
        BigDecimal second = new BigDecimal(Double.toString(0.2));

        assertEquals(0.3, first.add(second).doubleValue());
    }
}
