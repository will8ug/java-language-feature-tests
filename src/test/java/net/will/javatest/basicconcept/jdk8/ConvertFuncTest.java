package net.will.javatest.basicconcept.jdk8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConvertFuncTest {
    @Test
    public void testRegularImplementation() {
        IConvertFunc<String, Integer> obj = new ConvertFuncImpl();
        assertEquals(obj.convert("100"), Integer.valueOf(100));
    }

    @Test
    public void testMethodRefImplementation() {
        ConvertFuncImplViaMethodRef obj = new ConvertFuncImplViaMethodRef();
        assertEquals(obj.convertWithIntegerValueOf("100"), Integer.valueOf(100));
    }
}
