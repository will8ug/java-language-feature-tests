package net.will.javatest.basicconcept.jdk21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwitchCaseSyntaxTest {
    @Test
    public void testIdentifyNumber() {
        SwitchCaseSyntax switchCaseSyntax = new SwitchCaseSyntax();
        assertEquals("negative", switchCaseSyntax.identifyNumber(-1));
        assertEquals("positive", switchCaseSyntax.identifyNumber(5));
        assertEquals("non-negative", switchCaseSyntax.identifyNumber(0));
    }
}