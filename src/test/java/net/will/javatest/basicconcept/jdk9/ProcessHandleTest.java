package net.will.javatest.basicconcept.jdk9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessHandleTest {
    @Test
    public void testCurrent() {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println( String.valueOf(currentProcess.pid()) );
        assertTrue(currentProcess.pid() > 0);
    }
}
