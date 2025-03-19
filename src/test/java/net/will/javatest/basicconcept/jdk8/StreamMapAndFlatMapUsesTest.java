package net.will.javatest.basicconcept.jdk8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamMapAndFlatMapUsesTest {
    @Test
    public void testMap() {
        StreamMapAndFlatMapUses obj = new StreamMapAndFlatMapUses();
        assertEquals(Arrays.asList("A", "B"), obj.map());
    }

    @Test
    public void testFlatMapOnNestedList() {
        StreamMapAndFlatMapUses obj = new StreamMapAndFlatMapUses();
        assertEquals(Arrays.asList("A", "B", "C", "D"), obj.flatMapOnNestedList());
    }
}
