package net.will.javatest.java.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TryCatchFinallyTest {

    @Test
    public void testIncreaseIt() {
        assertEquals(2, TryCatchFinally.increaseIt());
    }

}
