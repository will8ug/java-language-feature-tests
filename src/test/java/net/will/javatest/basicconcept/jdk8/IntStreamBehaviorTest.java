package net.will.javatest.basicconcept.jdk8;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntStreamBehaviorTest {
    @Test
    public void testEmptyList() {
        IntStreamBehavior obj = new IntStreamBehavior();
        assertEquals(-1, obj.findFirstElementStartsWithDash(Collections.emptyList()));
    }

    @Test
    public void testOneValidElement() {
        IntStreamBehavior obj = new IntStreamBehavior();
        assertEquals(0, obj.findFirstElementStartsWithDash(List.of("-a")));
    }

    @Test
    public void testFirstInvalidAndFollowedByValidElement() {
        IntStreamBehavior obj = new IntStreamBehavior();
        assertEquals(1, obj.findFirstElementStartsWithDash(List.of("a", "-a")));
    }

    @Test
    public void testMultipleInvalidElements() {
        IntStreamBehavior obj = new IntStreamBehavior();
        assertEquals(-1, obj.findFirstElementStartsWithDash(List.of("a", "b")));
    }
}
