package net.will.javatest.basicconcept.jdk7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TryWithResourcesTest {
    @Test
    public void testRead1stLineOfFile() throws Exception {
        String testResourceFileName = getClass().getResource("testfile.txt").getFile();
        
        TryWithResources obj = new TryWithResources();
        String line = obj.read1stLineOfFile(testResourceFileName);
        assertNotNull(line);
        assertTrue(line.contains(obj.getClass().getPackage().getName()));
    }
}
